package com.rxkj.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求路径写法：http://localhost:8080/springMVC_demo/test1/multi?action=add
 * @author yp-tc-m-2649
 *
 */
public class MultiController extends MultiActionController {
	
	public ModelAndView add(HttpServletRequest req, HttpServletResponse res) {
		String method = "add";
		return new ModelAndView("multi", "method", method+"多个方法请求");
	}

	public ModelAndView update(HttpServletRequest req, HttpServletResponse res) {
		String method = "update";
		return new ModelAndView("multi", "method", method+"多个方法请求");
	}
}
