package com.rxkj.hxg.exception;

/**
 * 基础运行时异常
 */
public class SDKRuntimeException extends BaseException implements ExceptionDesc {

    public SDKRuntimeException(String errorCode, String errorDesc) {
        super(errorCode,errorDesc);
    }

    public SDKRuntimeException(String errorCode, String errorDesc, Throwable cause) {
        super(errorCode,errorDesc,cause);
    }

}
