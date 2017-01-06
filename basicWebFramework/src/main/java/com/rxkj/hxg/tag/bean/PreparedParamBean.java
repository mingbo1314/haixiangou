/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay) 
 */
package com.rxkj.hxg.tag.bean;


/**
 * @author：junning.li
 * @since：2012-5-20 下午06:11:13
 * @version:
 */
public class PreparedParamBean {

	private String name;

	private Object value;

	/**
	 * 是否首选(覆盖请求参数)
	 */
	private boolean preferred = true;

	public PreparedParamBean(String _name, Object _value, boolean _prefered) {
		this.name = _name;
		this.value = _value;
		this.preferred = _prefered;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public boolean isPreferred() {
		return preferred;
	}

	public void setPreferred(boolean preferred) {
		this.preferred = preferred;
	}
}
