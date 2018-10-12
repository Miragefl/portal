/**  
 * Project Name:loan-pubsys  
 * File Name:ConfigUtil.java  
 * Package Name:com.shanghe.loan.pubsys.config  
 * Date:2018-2-13  
 * Copyright (c) 2018, www.shanghe-china.com All Rights Reserved.  
 *  
*/

package com.soap.management.util;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;


/**  
 * ConfigUtil.java <br/>
 * <b>功能描述：<b><br/>
 *
 * TODO(这里描述类功能 –必选 ).<br/>
 *
 * @author qiangl@shanghe-china.com  
 * @since 1.0 2018-2-13  
 * @lastmodified 2018-2-13  
 */
@Component
public class ConfigUtil
{
	private static Properties prop = null;

	private static Logger logger = LoggerFactory.getLogger(ConfigUtil.class);

	private static String configPath = "config/config.properties";

	public void setConfigPath(String configPath)
	{
		if(StringUtils.isNotBlank(configPath)){
			this.configPath = configPath;
		}
	}

	public static void init()
	{	
		prop = new Properties();
		try
		{
			prop.load(new InputStreamReader(ConfigUtil.class.getClassLoader().getResourceAsStream(configPath), "UTF-8"));
			logger.info("configUtil init { } success"+configPath);
		}
		catch (IOException e)
		{
			logger.error("读取config配置发生错误", e);
		}
	}

	public static String get(String key)
	{
		String value = null;
		try
		{
			value = prop.getProperty(key);
		}
		catch (Exception e1)
		{
			value = key;
		}
		return value;
	}

	public static boolean getBool(String key)
	{
		return Boolean.parseBoolean(get(key));
	}

	public static int getInt(String key)
	{
		return Integer.parseInt(get(key));
	}

	public static char getChar(String key)
	{
		return get(key).charAt(0);
	}

}
