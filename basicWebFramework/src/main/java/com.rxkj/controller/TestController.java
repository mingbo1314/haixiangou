package com.rxkj.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("test")
public class TestController {

	@RequestMapping("")
	public String test(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException {
		System.out.println(new ObjectMapper().writeValueAsString(req
				.getParameterMap()));
		return "aaa";
	}
}
