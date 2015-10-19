/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.falstaff;

import java.util.concurrent.Executor;

import javax.servlet.MultipartConfigElement;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.falstaff.core.alignable.extender.AlignmentExtender;
import com.falstaff.core.alignable.extender.AlignmentExtenderPoolTargetSource;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.repository.dao.FileFormatDao;
import com.falstaff.service.FeaturedSignaturesSetService;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties
@EnableAsync
public class FalstaffApplication implements AsyncConfigurer {
		
	@Value("${falstaff.core.alignable.extender.alignment_extender_pool_target_source.max_size}")
	String maxSize;
	
	@Value("${falstaff.core.alignable.extender.alignment_extender.max_skip}")
	int maxSkip;
	
	@Value("${falstaff.core.service.max_file_size}")
	String maxFileSize;
	
	@Value("${falstaff.core.service.max_request_size}")
	String maxRequestSize;
	
	@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(maxFileSize);
        factory.setMaxRequestSize(maxRequestSize);
        return factory.createMultipartConfig();
    }
	
	@Bean
    public ProxyFactoryBean alignmentExtender() {
		ProxyFactoryBean alignmentExtender = new ProxyFactoryBean();
		alignmentExtender.setTargetSource(targetSource());
        return alignmentExtender;
    }
	
	@Bean
    public AlignmentExtenderPoolTargetSource targetSource() {
		AlignmentExtenderPoolTargetSource targetSource = new AlignmentExtenderPoolTargetSource();
		targetSource.setTargetBeanName("targetBean");
		targetSource.setMaxSize(new Integer(maxSize));
        return targetSource;
    }
	
	@Bean
	@Scope("prototype")
    public AlignmentExtender targetBean() {
		AlignmentExtender targetBean = new AlignmentExtender();
		targetBean.setMaxSkip(maxSkip);
        return targetBean;
    }
	
	@Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(50);
        executor.setThreadNamePrefix("FalstaffExecutor-");
        executor.initialize();
        return executor;
    }
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(FalstaffApplication.class, args);
	}

}
