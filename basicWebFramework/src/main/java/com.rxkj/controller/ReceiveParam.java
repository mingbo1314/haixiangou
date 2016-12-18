package com.rxkj.controller;

import com.rxkj.entity.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
@RequestMapping("ReceiveParam")
public class ReceiveParam {

	@RequestMapping("query")
	public String query(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("result", "接收参数");
		return "helloWorld";
	}
	
	@RequestMapping("query2")
	public String query2(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("result", "接收参数2");
		return "helloWorld";
	} 
	
	@RequestMapping("query3")
	public String query3(LoginForm loginForm, HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
		//解码
		String username = URLDecoder.decode(loginForm.getUsername(), "UTF-8");
		String age = URLDecoder.decode(loginForm.getAge(), "UTF-8");
		
		req.setAttribute("username", username);
		req.setAttribute("age", age);
		//req.setAttribute("result", username+"--"+age);
		
		return "helloWorld";
	} 
	
	@RequestMapping("query4")
	public void query4(LoginForm loginForm, HttpServletRequest req, HttpServletResponse res) {
		
		PrintWriter out = null;
		
		String data = "{\"username\":\""+loginForm.getUsername()+"\",\"age\":\""+loginForm.getAge()+"\"}";
		System.out.println(data);
		
		res.setContentType("application/json");
		
		try {
			out = res.getWriter();
			out.write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
