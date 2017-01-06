package com.rxkj.hxg.exception;

import com.yeepay.g3.utils.common.exception.YeepayBizException;

/**
 * 基础异常类
 */
public class BaseException extends YeepayBizException implements ExceptionDesc{
    private Throwable cause;
    public BaseException(String errorCode, String errorDesc) {
        super(errorCode);
        super.setMessage(errorDesc);
    }

    public BaseException(String errorCode, String errorDesc, Throwable cause) {
        this(errorCode,errorDesc);
        this.cause=cause;
    }

    public String getErrorCode() {
        return super.getDefineCode();
    }

    public void setErrorCode(String errorCode) {
        super.defineCode=errorCode;
    }

    public String getErrorDesc() {
        return super.getMessage();
    }

    public void setErrorDesc(String errorDesc) {
        super.setMessage(errorDesc);
    }
}
