package com.falstaff.core.service;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.falstaff.FalstaffApplication;
import com.falstaff.service.MagicNumberService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FalstaffApplication.class)
public class MagicNumbersServiceTest {

    @Autowired
    MagicNumberService magicNumbersService;

    @Test
    public void create() throws IOException {
    	magicNumbersService.create();
    }

}
