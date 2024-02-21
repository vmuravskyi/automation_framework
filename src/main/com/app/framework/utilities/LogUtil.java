package com.app.framework.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.app.framework.config.Settings;

@Deprecated(since = "Using Log4j, see config in log4j.xml")
public class LogUtil {

	// file format for the log name
	private ZonedDateTime zonedDateTime = ZonedDateTime.now();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
	private String fileNameFormat = zonedDateTime.format(formatter);
	private BufferedWriter bufferedWriter = null;

	// create log file
	public void createLogFile() {
		try {
			File dir = new File(Settings.LOG_PATH);
			if (!dir.exists()) {
				dir.mkdir();
			}
			File logFile = new File(dir + File.separator + fileNameFormat);
			FileWriter fileWriter = new FileWriter(logFile.getAbsolutePath());
			bufferedWriter = new BufferedWriter(fileWriter);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// write message withing a log file
	public void write(String message) {
		try {
			bufferedWriter.write(message);
			bufferedWriter.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
