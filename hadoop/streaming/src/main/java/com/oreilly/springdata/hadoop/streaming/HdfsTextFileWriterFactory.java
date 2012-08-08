package com.oreilly.springdata.hadoop.streaming;

import org.apache.hadoop.fs.FileSystem;
import org.springframework.util.Assert;

public class HdfsTextFileWriterFactory implements HdfsWriterFactory {

	private FileSystem fileSystem;

	public static final String DEFAULT_BASE_FILENAME = "data";
	public static final String DEFAULT_BASE_PATH = "/data/";
	public static final String DEFAULT_FILE_SUFFIX = "log";

	private String baseFilename = DEFAULT_BASE_FILENAME;
	private String basePath = DEFAULT_BASE_PATH;
	private String fileSuffix = DEFAULT_FILE_SUFFIX;

	public HdfsTextFileWriterFactory(FileSystem fileSystem) {
		Assert.notNull(fileSystem, "Hadoop FileSystem must not be null.");
		this.fileSystem = fileSystem;
	}

	public String getFileSuffix() {
		return fileSuffix;
	}

	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	public String getBaseFilename() {
		return baseFilename;
	}

	public void setBaseFilename(String baseFilename) {
		this.baseFilename = baseFilename;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	

	@Override
	public HdfsWriter createWriter() {
		HdfsTextFileWriter textFileWriter = new HdfsTextFileWriter(fileSystem);
		textFileWriter.setBasePath(basePath);
		textFileWriter.setBaseFilename(baseFilename);
		textFileWriter.setFileSuffix(fileSuffix);
		return textFileWriter;
	}

}
