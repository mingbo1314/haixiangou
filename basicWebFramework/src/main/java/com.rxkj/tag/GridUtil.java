package com.rxkj.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.DynamicAttributes;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GridUtil extends BodyTagSupport implements DynamicAttributes{
	
	private String gridId;

	/**
	 * 
	 */
	private static final long serialVersionUID = -4137555578341448910L;
	
	protected Map<String, Object> dynamicAttributes = new HashMap<String, Object>();

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)this.pageContext.getRequest();
		try {
			JspWriter out = this.pageContext.getOut();
			out.println("<table id='test_grid' border='1' >");
			out.println("<tr>");
			out.println("<td>"+gridId+"</td>");
			out.println("</tr>");
			out.println("</table>");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return EVAL_BODY_BUFFERED;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		String body = this.getBodyContent().getString();
		try {
			this.getPreviousOut().write(body);
			this.pageContext.getOut().write(dynamicAttributes.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		super.release();
	}

	@Override
	public int doAfterBody() throws JspException {
//		String body = getBodyContent().getString();
		// TODO Auto-generated method stub
		return super.doAfterBody();
	}
	
	

	public String getGridId() {
		return gridId;
	}

	public void setGridId(String gridId) {
		this.gridId = gridId;
	}

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value)
			throws JspException {
		// TODO Auto-generated method stub
		dynamicAttributes.put(localName, value);
	}
	
	
}
