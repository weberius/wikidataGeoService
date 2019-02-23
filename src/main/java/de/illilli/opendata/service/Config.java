package de.illilli.opendata.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	private static final String fileName = "/config.properties";
	private static Properties properies;

	public static String getProperty(String key) {
		if (properies == null) {
			properies = new Properties();
			InputStream inputStream = Config.class.getResourceAsStream(fileName);
			try {
				properies.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properies.getProperty(key);
	}

}
