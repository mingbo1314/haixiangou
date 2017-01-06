package com.rxkj.hxg.exception;

/**
 * 异常信息描述接口
 */
public interface ExceptionDesc {

    /**
     * 获取错误代码
     * @return
     */
    String getErrorCode();

    /**
     * 获取错误描述
     * @return
     */
    String getErrorDesc();
}
