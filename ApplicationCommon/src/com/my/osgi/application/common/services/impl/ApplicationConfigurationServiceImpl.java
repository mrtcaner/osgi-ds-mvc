package com.my.osgi.application.common.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

import com.my.osgi.application.common.util.IApplicationConfigurationService;

//Create a different instance for each bundle
@Component(servicefactory = true)
public class ApplicationConfigurationServiceImpl implements IApplicationConfigurationService {

	private static final String LANGUAGE = "en_EN";

	private Properties configuration;

	private ResourceBundle textResourceBundle;
	private ResourceBundle messageResourceBundle;

	private HashMap<String, ArrayList<String>> reverseDictionary;

	private String languageFilePath;
	private String configurationFilePath;
	
	@Override
	public void loadProperties(String bundleName) {
		configuration = new Properties();

		try {// .plugins/bundleName/conf/bundleName.properties
			configuration.load(new FileInputStream("plugins" + File.separator + bundleName + File.separator + "conf"
					+ File.separator + bundleName + ".properties"));
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		try {
			// .plugins/bundleName/lang
			File file = new File("plugins" + File.separator + bundleName + File.separator + "lang");
			URL[] urls = { file.toURI().toURL() };

			ClassLoader classLoader = new URLClassLoader(urls);

			String lang = System.getProperty("lang");
			if (lang == null || "".equals(lang)) {
				lang = LANGUAGE;
			}

			// bundleName_en.properties
			textResourceBundle = ResourceBundle.getBundle(bundleName, Locale.forLanguageTag(lang), classLoader);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		reverseDictionary = new HashMap<String, ArrayList<String>>();

		for (Object key : textResourceBundle.keySet()) {
			String value = textResourceBundle.getString((String) key);

			if (!reverseDictionary.containsKey(value)) {
				reverseDictionary.put(value, new ArrayList<String>());
			}

			if (!reverseDictionary.get(value).contains(key)) {
				reverseDictionary.get(value).add((String) key);
			}
		}

	}


	@Override
	public String getText(String text) {
		return textResourceBundle.containsKey(text) ? textResourceBundle.getString(text) : text;
	}

	@Override
	public String getKeyFromValue(String value) {
		return getKeyFromValue(null, value);
	}

	@Override
	public String getKeyFromValue(String keyPrefix, String value) {
		if (reverseDictionary.containsKey(value)) {
			ArrayList<String> keys = reverseDictionary.get(value);

			if (keys.isEmpty()) {
				return value;
			} else {
				if (keyPrefix == null || keyPrefix.isEmpty()) {
					return keys.get(0);
				} else {
					for (String key : keys) {
						if (key.startsWith(keyPrefix)) {
							return key;
						}
					}

					return value;
				}
			}
		} else {
			return value;
		}
	}


	@Override
	public String[] getKeysStartingWith(String keyPrefix) {
		ArrayList<String> result = new ArrayList<String>();

		for (Object key : textResourceBundle.keySet()) {
			if (key instanceof String) {
				String keyString = (String) key;

				if (keyString.startsWith(keyPrefix)) {
					result.add(keyString);
				}
			}
		}

		Object[] objects = result.toArray();

		String[] strings = new String[result.size()];

		for (int resultIndex = 0; resultIndex < objects.length; resultIndex++) {
			strings[resultIndex] = (String) objects[resultIndex];
		}

		return strings;
	}

	@Override
	public String getConfiguration(String key) {
		return this.configuration.getProperty(key);
	}

	@Override
	public String getMessageText(String key) {
		return messageResourceBundle.containsKey(key) ? textResourceBundle.getString(key) : key;
	}

}
