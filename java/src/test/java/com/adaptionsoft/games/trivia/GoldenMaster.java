package com.adaptionsoft.games.trivia;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class GoldenMaster {
	
	@Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	
	public void buildFileWithGoldenResult() throws IOException {
		FileUtils.writeStringToFile(new File("src/test/resources/goldenMaster/executionResult.txt"), systemOutRule.getLog(), Charset.defaultCharset());
	}

}
