/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.rxkj.utils;

import com.google.common.collect.Lists;
import com.rxkj.enumtype.ConfigEnum;
import com.yeepay.g3.utils.common.CheckUtils;
import com.yeepay.g3.utils.common.StringUtils;
import com.yeepay.g3.utils.config.ConfigParam;
import com.yeepay.g3.utils.config.ConfigParamGroup;
import com.yeepay.g3.utils.config.ConfigurationUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 获取统一配置工具类
 * 
 * @author：tong.yue
 * @since：2016年3月21日 上午9:36:49
 * @version:
 */
public class NativeConfigurationUtils {

	/**
	 * 获取系统开关
	 * 
	 * @param key
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, Object> getSystemSwitch(String key) {
		ConfigParamGroup configParamGroup = ConfigurationUtils.getConfigParamGroup("config_type_sys");
		return (Map<String, Object>) configParamGroup.getConfig(key).getValue();
	}

	/**
	 * 获取系统开关值
	 * 
	 * @param switchKey
	 * @param valueKey
	 * @return
	 */
	public static String getSystemSwitchValue(String switchKey, String valueKey) {
		return (String) getSystemSwitch(switchKey).get(valueKey);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getSysConfigParam(ConfigEnum configEnum) {
		ConfigParam<T> configParam = ConfigurationUtils.getSysConfigParam(configEnum.getConfigKey());
		// getValue方法使用了同步锁，防止获取值时重复加锁，未使用（configParam != null && configParam.getValue() != null）
		if (configParam != null) {
			T value = configParam.getValue();
			return value != null ? value : (T)configEnum.getDefaultValue();
		} else {
			return (T)configEnum.getDefaultValue();
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> Map<String, T> getSysMapConfigParam(ConfigEnum configEnum) {
		ConfigParam<Map<String, T>> configParam = ConfigurationUtils.getSysConfigParam(configEnum.getConfigKey());
		if (configParam != null) {
			Map<String, T> value = configParam.getValue();
			return value != null ? value : (Map<String, T>)configEnum.getDefaultValue();
		} else {
			return (Map<String, T>)configEnum.getDefaultValue();
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> getSysListConfigParam(ConfigEnum configEnum) {
		ConfigParam<List<T>> configParam = ConfigurationUtils.getSysConfigParam(configEnum.getConfigKey());
		if (configParam != null) {
			List<T> value = configParam.getValue();
			return value != null ? value : (List<T>)configEnum.getDefaultValue();
		} else {
			return (List<T>)configEnum.getDefaultValue();
		}
	}
	
	/**
	 * 获取通知接收者
	 * @param key 接收者列表对应的key值
	 * @return
	 */
	public static List<String> getNotificationRecipients(String key) {
		Map<String, String> recipientMap = getSysMapConfigParam(ConfigEnum.NOTIFICATION_RECIPIENTS);
		if (!CheckUtils.isEmpty(recipientMap)) {
			String recipientStr = recipientMap.get(key);
			if (StringUtils.isNotEmpty(recipientStr)) {
				return Arrays.asList(recipientStr.split(","));
			}
		}
		return Lists.newArrayList();
	}
}
