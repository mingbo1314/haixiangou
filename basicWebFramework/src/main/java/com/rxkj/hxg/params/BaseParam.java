/**
 * Copyright: Copyright (c)2016
 * Company: 仁轩科技(Rxkj)
 */
package com.rxkj.hxg.params;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 类名称: BaseParam <br>
 * 类描述: <br>
 *
 * @author: yangming
 * @since: 2017/1/3 18:28
 * @version: 1.0.0
 */
public class BaseParam implements Serializable {

    private static final long serialVersionUID = 1786418639466131801L;

    /**
     * 平台登录名
     */
    @NotBlank(message = "{BaseParam.loginName.No.null}")
    @Size(max = 32, message = "{BaseParam.loginName.No.size}")
    private String loginName;

    /**
     * 请求流水号
     */
    private String requestId;

    /**
     * 缓存记录
     */
    private String sign;

    public BaseParam() {
    }

    public BaseParam(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
