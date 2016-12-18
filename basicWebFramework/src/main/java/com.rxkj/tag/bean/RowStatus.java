/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay) 
 */
package com.rxkj.tag.bean;

/**
 * 表格中的行状态
 *
 * @author：junning.li
 * @since：2012-5-21 下午09:15:42
 * @version:
 */
public class RowStatus {

	private int startIndex;
	private int index;

	public RowStatus(int _startIndex) {
		this.startIndex = _startIndex;
		index = 0;
	}

	public void next() {
		index++;
	}

	public boolean isEven() {
		return (index % 2) != 1;
	}

	public int getGlobalIndex() {
		return startIndex + index - 1;
	}

	public int getIndex() {
		return index;
	}
}
