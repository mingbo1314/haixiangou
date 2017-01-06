package com.rxkj.hxg.exception;

/**
 * 业务异常类
 */
public class BusinessException extends BaseException {

    public BusinessException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }

    public BusinessException(String errorCode, String errorDesc, Throwable cause) {
        super(errorCode, errorDesc, cause);
    }
}
