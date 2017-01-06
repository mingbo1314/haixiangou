/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.rxkj.hxg.tag;

import com.yeepay.g3.utils.common.log.Logger;
import com.yeepay.g3.utils.common.log.LoggerFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.DynamicAttributes;

import org.mvel2.templates.CompiledTemplate;
import org.mvel2.templates.TemplateCompiler;
import org.mvel2.templates.TemplateRuntime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: 查询表格标签</p>
 * <p>Description: 描述</p>
 * <p>Copyright: Copyright (c)2011</p>
 * <p>Company: 易宝支付(YeePay)</p>
 *
 * @author baitao.ji
 * @version 0.1, 14-5-15 10:12
 */
public class QueryTableTag extends BodyTagSupport implements DynamicAttributes{

	protected static final Logger LOGGER = LoggerFactory.getLogger(QueryTableTag.class);

	public static final String QUERY_TABLA = "_query_table_";
	public static final String PAGING_POSITION_TOP = "top";
	public static final String PAGING_POSITION_BOTH = "both";

	private String formId;
	private String queryUrl;
	private String queryForm;
	private String paging;
	private String pagingPosition;
	private String queryKey;
	private String queryService;
	private String pageSize;
	private String doSum;
	private String autoTrim;
	private String baseCssClass;
	private String template;
	private String pagingTemplate;
	private String titleHiding;
	private static List<String> titles = null;
	private static List<Map<String,Object>> data = null;
	private static Map<String,Object> content = null;
	
	static {
		titles = new ArrayList<String>();
		data = new ArrayList<Map<String,Object>>();
		content = new HashMap<String, Object>();
		titles.add("用户名");
		titles.add("密码");
		titles.add("年龄");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("username", "zhangsan");
		map.put("password", "aa");
		map.put("age", "11");
		data.add(map);
		Map<String,Object> map2 = new HashMap<String, Object>();
		map2.put("username", "lisi");
		map2.put("password", "bb");
		map2.put("age", "22");
		data.add(map2);
		Map<String,Object> map3 = new HashMap<String, Object>();
		map3.put("username", "wangwu");
		map3.put("password", "cc");
		map3.put("age", "33");
		data.add(map3);
		
		
		content.put("titles", titles);
		content.put("data", data);
	}

	/**
	 * 第一次请求
	 *
	 * @return
	 */
	private boolean isFirstQueryInPage() {
		return null == pageContext.getAttribute(QUERY_TABLA);
	}

	private void setQueryInPage() {
		pageContext.setAttribute(QUERY_TABLA, new Object());
	}

	/**
	 * doStartTag()方法是遇到标签开始时会呼叫的方法，
	 * 其合法的返回值是EVAL_BODY_INCLUDE与SKIP_BODY,
	 * 前者表示将显示标签间的文字，
	 * 后者表示不显示标签间的文字
	 *
	 * @return
	 * @throws JspException
	 */
	@Override
	public int doStartTag() throws JspException {
		return EVAL_BODY_BUFFERED;
	}

	/**
	 * doAfterBody(),这个方法是在显示完标签间文字之后呼叫的，
	 * 其返回值有EVAL_BODY_AGAIN与SKIP_BODY，
	 * 前者会再显示一次标签间的文字，
	 * 后者则继续执行标签处理的下一步。
	 *
	 * @return
	 * @throws JspException
	 */
	@Override
	public int doAfterBody() throws JspException {
		return SKIP_BODY;
	}

	/**
	 * doEndTag()方法是在遇到标签结束时呼叫的方法，
	 * 其合法的返回值是EVAL_PAGE与SKIP_PAGE，
	 * 前者表示处理完标签后继续执行以下的JSP网页，
	 * 后者是表示不处理接下来的JSP网页
	 *
	 * @return
	 * @throws JspException
	 */
	@Override
	public int doEndTag() throws JspException {
		try {
			InputStream e = Thread.currentThread().getContextClassLoader().getResourceAsStream("querytable.mvel");
			String templateContent = new String(toByte(e), "UTF-8");
			CompiledTemplate compiledTemplate = TemplateCompiler.compileTemplate(templateContent);
			String table_out = TemplateRuntime.execute(compiledTemplate, null, content).toString();
			this.getPreviousOut().write(table_out);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return EVAL_PAGE;
	}
	
	private byte[] toByte(InputStream is) throws IOException {
        ByteArrayOutputStream bytestream = new ByteArrayOutputStream();

        int ch;
        while((ch = is.read()) != -1) {
            bytestream.write(ch);
        }

        byte[] data = bytestream.toByteArray();
        bytestream.close();
        return data;
    }


	public void setQueryKey(String queryKey) {
		this.queryKey = queryKey;
	}

	public void setQueryService(String queryService) {
		this.queryService = queryService;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public void setQueryForm(String queryForm) {
		this.queryForm = queryForm;
	}

	public void setPaging(String paging) {
		this.paging = paging;
	}

	public void setPagingPosition(String pagingPosition) {
		this.pagingPosition = pagingPosition;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public void setPagingTemplate(String pagingTemplate) {
		this.pagingTemplate = pagingTemplate;
	}

	public void setBaseCssClass(String baseCssClass) {
		this.baseCssClass = baseCssClass;
	}

	public void setTitleHiding(String titleHiding) {
		this.titleHiding = titleHiding;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public void setDoSum(String doSum) {
		this.doSum = doSum;
	}

	public void setAutoTrim(String autoTrim) {
		this.autoTrim = autoTrim;
	}

	public void setQueryUrl(String queryUrl) {
		this.queryUrl = queryUrl;
	}

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value)
			throws JspException {
		// TODO Auto-generated method stub
		
	}
	
	
}
