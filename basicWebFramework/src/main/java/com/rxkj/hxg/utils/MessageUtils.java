package com.rxkj.hxg.utils;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志信息国际化支持工具
 */
public class MessageUtils {

    private static Logger logger = Logger.getLogger(MessageUtils.class);

    /**
     * 获取国际化日志信息
     * @param key 日志信息对应的Key
     * @param variables 日志信息中的可变变量
     * @return 正确时返回Key对应的日志信息，出错时返回Null
     */
    public static String getLocaleMessage(String key, Object... variables){
        HttpServletRequest request =  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return getLocaleMessage(request, key, variables);
    }

    /**
     * 获取国际化日志信息
     * @param request 请求对象
     * @param key 日志信息对应的Key
     * @param variables 日志信息中的可变变量
     * @return 正确时返回Key对应的日志信息，出错时返回Null
     */
    public static String getLocaleMessage(HttpServletRequest request, String key, Object... variables) {
        String localeMessage = null;
        try {
            RequestContext requestContext = new RequestContext(request);
            localeMessage = requestContext.getMessage(key, variables);
            requestContext.getMessage(key);
        } catch (Exception e) {
            logger.error("Get locale message error!", e);
        } finally {
            return localeMessage;
        }
    }
}
