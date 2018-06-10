package com.my.osgi.application.common.util;

public interface IApplicationConfigurationService {

	String getMessageText(String key);

	String getText(String key);

	String[] getKeysStartingWith(String prefix);

	String getKeyFromValue(String value);

	String getKeyFromValue(String keyPrefix, String value);

	String getConfiguration(String key);

	void loadProperties(String bundleName);
}
