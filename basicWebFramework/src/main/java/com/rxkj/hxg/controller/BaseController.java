/**
 * Copyright: Copyright (c)2016
 * Company: 仁轩科技(Rxkj)
 */
package com.rxkj.hxg.controller;

import com.rxkj.hxg.utils.MessageUtils;
import com.yeepay.g3.utils.common.log.Logger;
import com.yeepay.g3.utils.common.log.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author: yangming  Date: 2017/1/2 Time: 14:10
 */
public class BaseController {

    private static Logger LOGGER = LoggerFactory
            .getLogger(BaseController.class);

    protected ThreadLocal<HttpServletRequest> request=new ThreadLocal<HttpServletRequest>();
    protected ThreadLocal<HttpServletResponse> response=new ThreadLocal<HttpServletResponse>();
    protected ThreadLocal<HttpSession> session=new ThreadLocal<HttpSession>();

    @ModelAttribute
    protected void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response){
        this.request.set(request);
        this.response.set(response);
        this.session.set(request.getSession());
    }

    /**
     * debug请求参数
     * @param methodName 请求服务名称
     * @param params 请求参数
     * @param logger 日志记录对象
     */
    protected void debugParams(String methodName, Map<String, String> params, com.yeepay.g3.utils.common.log.Logger logger) {
        if(!logger.isDebugEnabled()) {
            return;
        }

        if(params != null) {
            logger.debug(MessageUtils.getLocaleMessage(request.get(), "debug.request.method", methodName));
            for(String key : params.keySet()) {
                logger.debug(MessageUtils.getLocaleMessage(request.get(), "debug.request.params", key, params.get(key)));
            }
        }
    }
}
