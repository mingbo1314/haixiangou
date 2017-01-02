package com.rxkj.enumtype;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一配置键值枚举，包含配置键及对应的默认值
 * 
 * @author：nan.he
 * @since：2016年4月14日 上午10:12:43
 * @version:
 */
public enum ConfigEnum {
	/** 调用天创接口的appkey */
	TC_APPKEY("credittrans_appkey", "87638892"),

	/** 调用天创接口的appkey */
	TC_SECRETKEY("credittrans_secretkey", "54c6eb21c7bb5f6643760388b6006e58"),

	/** 与天创交互的接口URL */
	INTERACTION_URL("credittrans_interactionURL"),

	/** 通知用户即将到期的账单距离限定还款日的天数（还有几天还款），负数表示当前日期往前推的天数、正数则相反 */
	MONITOR_NOTIFY_BILL_FOR_SOON_REMAINING_PERIOD("credittrans_monitor_notify_bill_for_soon_remaining_period", 3L),

	/** 自动还款时，查询还款账单的区间天数，负数表示当前日期往前推的天数、正数则相反 */
	QUERY_REPAYMENT_BILL_PERIOD("credittrans_query_repayment_bill_period", -90L),

	/** 定时补单任务查询还款流水的时间范围，x,y：表示查询x分钟以前y小时以内的流水 */
	CRON_REPAIR_ORDER_QUERY_FLOW_RECORD_PERIOD("credittrans_cron_repair_order_query_flow_record_period", "5,3"),

	/** 支付URL */
	PAY_URL("CREDITTRANS_PAY_URL"),

	/** 易宝支付回调URL */
	CREDITTRANS_YEEPAY_CALLBACK_URL("CREDITTRANS_YEEPAY_CALLBACK_URL"),
	
	/** 车险分期支付URL */
	INSURANCE_PAY_URL("CREDITTRANS_INSURANCE_PAY_URL"),

	/** 车险分期畅捷支付URL */
	INSURANCE_CHANGJIE_PAY_URL("CREDITTRANS_INSURANCE_CHANGJIE_PAY_URL"),

	/** 车险分期合众支付URL */
	INSURANCE_HEZHONG_PAY_URL("CREDITTRANS_INSURANCE_HEZHONG_PAY_URL"),

	/** 自动登陆天数 **/
	AUTO_LOGIN_DAYS("CREDITTRANS_AUTO_LOGIN_DAYS", 30),
	
	/** 商户号对应的账单相关服务实例名称 */
	MERCHANT_NO_TO_INSTANCE_NAME("credittrans_merchant_no_to_instance_name"),
	
	/** 商户业务配置参数 */
	CREDITTRANS_MERCHANT_BIZ_PARAM("credittrans_merchant_biz_param"),
	
	/** 通知收件人 */
	NOTIFICATION_RECIPIENTS("credittrans_notification_recipients"),
	
	/** 关于密码错误账户冻结 */
	/** 资方管理后台用户账户冻结时间(单位秒) */
	MERUSER_FREEZE_DURATION("credittrans_meruser_freeze_duration", 3600l),
	/** 密码连续错误的有效时间范围（单位秒） */
	PWD_ERROR_VALID_DURATION("credittrans_pwd_error_valid_duration", 3600l),
	/** 允许密码错误的最大次数 */
	MAXIMUM_PWD_ERROR_TIME("credittrans_maximum_pwd_error_time", 5l),
	/** 支付通道切换，默认畅捷支付 */
	PAYMENT_CHANNEL_CHANGE("credittrans_payment_channel_change",new HashMap<String,String>().put("changjie","on")),
	/** 畅捷支付: 业务编码 */
	CJ_BUSINESSCODE("credittrans_cj_businesscode"),
	/** 畅捷支付: 商户编号 */
	CJ_MERCHANT_ID("credittrans_cj_merchantid"),
	/** 平台账户号 */
	PLATFORM_ACCOUNT_NUM("platform_account_num","10000000000"),
	/** 二级商户号 */
	CJ_SUB_MERCHANT_ID("credittrans_cj_sub_merchantid"),
	/** 畅捷支付: 企业收付款账号 */
	CJ_CORP_ACCOUNT_NO("credittrans_cj_corp_accountno"),
	/** 畅捷支付: 产品编码 */
	CJ_PRODUCTCODE("credittrans_cj_productcode"),

	/** 畅捷支付: 支付网关地址 */
	CJ_GATEWAY_URL("credittrans_cj_gateway_url"),
	/** 畅捷支付: 银商私钥证书路径 */
	YS_PFX_PATH("credittrans_cj_ys_pfxpath"),
	/** 畅捷支付: 银商私钥证书密码 */
	YS_PFX_PASSWD("credittrans_cj_pfxpassword"),
	/** 畅捷支付: 畅捷公钥证书路径 */
	CJ_CERT_PATH("credittrans_cj_certpath"),
	
	/** 合众支付: 支付网关地址 */
	HZ_GATEWAY_URL("credittrans_hz_gateway_url"),
	/** 合众支付: 支付网关地址 */
	HZ_SINGLE_QUERY_URL("credittrans_hz_single_query_url"),
	/** 合众支付: 合众私钥证书路径 */
	HZ_PFX_PATH("credittrans_hz_pfxpath"),
	/** 合众支付: 合众公钥证书路径 */
	HZ_CERT_PATH("credittrans_hz_certpath"),
	/** 合众支付: 合众私钥证书密码 */
	HZ_PFX_PASSWD("credittrans_hz_pfxpassword"),
	/** 合众支付: 商户编号 */
	HZ_MERCHANT_ID("credittrans_hz_merchantid"),
	/** 合众支付: 获取根根证书的配置文件及证书吊销列表信息 */
	HZ_CVM_PATH("credittrans_hz_cvmpath"),
	
	/** 账单生成策略 */
	BILL_CREATION_POLICY("credittrans_bill_creation_policy");

	
	/** 配置键 */
	private String configKey;

	/** 默认值 */
	private Object defaultValue;

	private static Map<String, ConfigEnum> configEnumMap = new HashMap<String, ConfigEnum>();

	static {
		for (ConfigEnum item : ConfigEnum.values()) {
			configEnumMap.put(item.configKey, item);
		}
	}

	private ConfigEnum(String configKey) {
		this.configKey = configKey;
	}

	ConfigEnum(String configKey, Object defaultValue) {
		this.configKey = configKey;
		this.defaultValue = defaultValue;
	}

	public static ConfigEnum fromConfigKey(String configKey) {
		return configEnumMap.get(configKey);
	}

	public String getConfigKey() {
		return configKey;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}
}
