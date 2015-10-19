package com.falstaff.core.aligner;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.falstaff.FalstaffApplication;
import com.falstaff.core.alignable.INFeaturedAlignable;
import com.falstaff.core.alignable.sequence.NClassifiedFormatFile;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FalstaffApplication.class)
public class ContentPropertiesFeatureAssignerTest {

	@Test
	public void test() {
		ContentPropertiesFeatureAssigner assigner = new ContentPropertiesFeatureAssigner();
		INFeaturedAlignable a1 = new NClassifiedFormatFile(new File("F:\\govdoc1s\\govdocs_selected\\HTML_2\\064116.html"));
		List<INFeaturedAlignable> l = new LinkedList<INFeaturedAlignable>();
		l.add(a1);
		assigner.transformInternal(l);
	}

}
