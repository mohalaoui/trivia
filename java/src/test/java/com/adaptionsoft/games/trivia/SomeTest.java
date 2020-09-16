package com.adaptionsoft.games.trivia;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class SomeTest {
	
	@Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


	@Test
	public void goldenMasterTest() throws Exception {
		
		GoldenGameRunner.run();
		File goldenMasterResult = new File("src/test/resources/goldenMaster/executionResult.txt");
		assertEquals(FileUtils.readFileToString(goldenMasterResult, Charset.defaultCharset()), systemOutRule.getLog());
	}

}
