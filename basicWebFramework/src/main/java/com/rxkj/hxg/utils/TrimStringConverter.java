package com.rxkj.hxg.utils;


import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * 类名称: TrimStringConverter <br>
 * 类描述: 发送http请求到controller时，将一个字符串去掉首位空格<br>
 *
 * @author: yangming
 * @since: 2017/1/3 22:10
 * @version: 1.0.0
 */
public class TrimStringConverter implements Converter<String,String>{

	@Override
	public String convert(String resource){
		if(StringUtils.isNotEmpty(resource)){
			return resource.trim();
		}
		return resource;
	}
	
}
