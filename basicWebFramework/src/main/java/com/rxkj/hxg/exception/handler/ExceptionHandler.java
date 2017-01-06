package com.rxkj.hxg.exception.handler;

import com.rxkj.hxg.common.DataReturnFormat;
import com.yeepay.g3.utils.common.CheckUtils;
import com.yeepay.g3.utils.common.json.JSONUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 异常处理器
 */
public class ExceptionHandler implements HandlerExceptionResolver {

	private Logger logger = Logger.getLogger(ExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse, Object handler,
                                         Exception ex) {

		ModelAndView mv = new ModelAndView();

		logger.info("",ex);
		
		handle(httpServletRequest, httpServletResponse, ex);

		return mv;
	}

	/**
	 * 返回异常错误码和异常信息
	 * 
	 * @param httpServletResponse
	 * @param convertedException
	 */
	private void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Exception convertedException) {
		httpServletResponse.setStatus(HttpStatus.OK.value());
		httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
		httpServletResponse.setCharacterEncoding("UTF-8");
		httpServletResponse.setHeader("Cache-Control",
				"no-cache,must-revalidate");
		PrintWriter writer = null;
		try {
			writer = httpServletResponse.getWriter();
			DataReturnFormat dataReturnFormat = new DataReturnFormat();
			if(!CheckUtils.isEmpty(httpServletRequest.getParameter("requestId"))) {
				dataReturnFormat.setRequest_id(httpServletRequest.getParameter("requestId"));
			}
			if(!CheckUtils.isEmpty(httpServletRequest.getParameter("sign"))) {
				dataReturnFormat.setSign(httpServletRequest.getParameter("sign"));
			}
			dataReturnFormat.setStatus(DataReturnFormat.Status.FAIL);
//			dataReturnFormat.setError_code(Boolean.FALSE.toString());
			dataReturnFormat.setError_msg(convertedException.getMessage());
//			writer.write(JacksonUtils.toJSon(errorResult));
			writer.write(JSONUtils.toJsonString(dataReturnFormat));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}