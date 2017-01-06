package com.rxkj.hxg.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TransViewsController2 implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView("/transViews");
		for (Object key : request.getParameterMap().keySet()) {
			mav.addObject(key.toString(), request.getParameterMap().get(key));
		}
		System.out.println(new ObjectMapper().writeValueAsString(request
				.getParameterMap()));
		return mav;
	}

}
