package com.rxkj.hxg.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class HelloWorldController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--------------hello world! 世界你好！--------------------");
		String str = "Hello SpringMVC 我来了";
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ym", "杨明");
		map.put("yb", "闫波");
		map.put("hahha", "hahha");
		//return new ModelAndView("/helloWorld","result",str);	
		return new ModelAndView("/helloWorld","map",map);
	}

}
