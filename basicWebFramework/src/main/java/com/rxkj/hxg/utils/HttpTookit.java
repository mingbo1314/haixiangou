package com.rxkj.hxg.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 

/** 
* HTTP工具箱 
* 
* @author leizhimin 2009-6-19 16:36:18 
*/ 
public final class HttpTookit { 
        private static Log log = LogFactory.getLog(HttpTookit.class); 

        /** 
         * 执行一个HTTP GET请求，返回请求响应的HTML 
         * 
         * @param url                 请求的URL地址 
         * @param queryString 请求的查询参数,可以为null 
         * @param charset         字符集 
         * @param pretty            是否美化 
         * @return 返回请求响应的HTML 
         */ 
        public static String doGet(String url, String queryString, String charset, boolean pretty) { 
                StringBuffer response = new StringBuffer(); 
                HttpClient client = new HttpClient(); 
                HttpMethod method = new GetMethod(url); 
                try { 
//                        if (StringUtils.isNotBlank(queryString)) 
//                                //对get请求参数做了http请求默认编码，好像没有任何问题，汉字编码后，就成为%式样的字符串 
//                                method.setQueryString(URIUtil.encodeQuery(queryString)); 
                        client.executeMethod(method); 
                        if (method.getStatusCode() == HttpStatus.SC_OK) { 
                                BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset)); 
                                String line; 
                                while ((line = reader.readLine()) != null) { 
                                        if (pretty) 
                                                response.append(line).append(System.getProperty("line.separator")); 
                                        else 
                                                response.append(line); 
                                } 
                                reader.close(); 
                        } 
                } catch (URIException e) { 
                        log.error("执行HTTP Get请求时，编码查询字符串“" + queryString + "”发生异常！", e); 
                } catch (IOException e) { 
                        log.error("执行HTTP Get请求" + url + "时，发生异常！", e); 
                } finally { 
                        method.releaseConnection(); 
                } 
                return response.toString(); 
        } 

        /** 
         * 执行一个HTTP POST请求，返回请求响应的HTML 
         * 
         * @param url         请求的URL地址 
         * @param params    请求的查询参数,可以为null 
         * @param charset 字符集 
         * @param pretty    是否美化 
         * @return 返回请求响应的HTML 
         */ 
        public static String doPost(String url, Map<String, String> params, String charset, boolean pretty) { 
                StringBuffer response = new StringBuffer(); 
                HttpClient client = new HttpClient(); 
                HttpMethod method = new PostMethod(url); 
                //设置Http Post数据 
                if (params != null) { 
                        HttpMethodParams p = new HttpMethodParams(); 
                        for (Map.Entry<String, String> entry : params.entrySet()) { 
                                p.setParameter(entry.getKey(), entry.getValue()); 
                        } 
                        method.setParams(p); 
                } 
                try { 
                        client.executeMethod(method); 
                        if (method.getStatusCode() == HttpStatus.SC_OK) { 
                                BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset)); 
                                String line; 
                                while ((line = reader.readLine()) != null) { 
                                        if (pretty) 
                                                response.append(line).append(System.getProperty("line.separator")); 
                                        else 
                                                response.append(line); 
                                } 
                                reader.close(); 
                        } 
                } catch (IOException e) { 
                        log.error("执行HTTP Post请求" + url + "时，发生异常！", e); 
                } finally { 
                        method.releaseConnection(); 
                } 
                return response.toString(); 
        } 

        public static String getDate() {
			// TODO Auto-generated method stub
        	String result = "[{\"report_node_type\":\"report_title\",\"report_stat_timespan\":\"日期: 2015-10-01 至 2015-10-24\",\"report_name\":\"交易日统计\",\"chartTypes\":[],\"report_conditions\":[\"日期: 从2015-10-01 到2015-10-24\",\"所属分公司/行业线: \"],\"report_title\":[{\"text\":\"交易日期\",\"field\":\"trx_date\",\"presentType\":\"date\",\"presentFormat\":\"yyyy-MM-dd\",\"order\":true},{\"text\":\"分公司/行业线\",\"field\":\"suborg\",\"presentType\":\"string\",\"presentFormat\":\"\",\"order\":false},{\"text\":\"交易笔数\",\"field\":\"transNum\",\"presentType\":\"number\",\"presentFormat\":\"'0'\",\"order\":false},{\"text\":\"封顶交易笔数\",\"field\":\"fengdingTransNum\",\"presentType\":\"number\",\"presentFormat\":\"'0'\",\"order\":false},{\"text\":\"非封顶交易笔数\",\"field\":\"feifengdingTransNum\",\"presentType\":\"number\",\"presentFormat\":\"'0'\",\"order\":false},{\"text\":\"总交易金额\",\"field\":\"transAmount\",\"presentType\":\"number\",\"presentFormat\":\"'0.00'\",\"order\":false},{\"text\":\"封顶交易金额\",\"field\":\"fengdingTransAmount\",\"presentType\":\"number\",\"presentFormat\":\"'0.00'\",\"order\":false},{\"text\":\"非封顶交易金额\",\"field\":\"feifengdingTransAmount\",\"presentType\":\"number\",\"presentFormat\":\"'0.00'\",\"order\":false},{\"text\":\"收入\",\"field\":\"income\",\"presentType\":\"number\",\"presentFormat\":\"'0.00'\",\"order\":false},{\"text\":\"成本\",\"field\":\"cost\",\"presentType\":\"number\",\"presentFormat\":\"'0.00'\",\"order\":false},{\"text\":\"毛利\",\"field\":\"grossProfit\",\"presentType\":\"number\",\"presentFormat\":\"'0.00'\",\"order\":false}]},{\"report_node_type\":\"report_data\",\"suborg\":\"银行合作部\",\"transAmount\":1.7246318343E8,\"grossProfit\":-716587.73,\"income\":19584.49,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":5071,\"transNum\":22582,\"feifengdingTransAmount\":6.908587589E7,\"feifengdingTransNum\":17511,\"fengdingTransAmount\":1.0337730754E8,\"cost\":736172.22},{\"report_node_type\":\"report_data\",\"suborg\":\"北京分公司\",\"transAmount\":4.40097677E7,\"grossProfit\":29804.76,\"income\":137226.11,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":1791,\"transNum\":10900,\"feifengdingTransAmount\":2.091111667E7,\"feifengdingTransNum\":9109,\"fengdingTransAmount\":2.309865103E7,\"cost\":107421.35},{\"report_node_type\":\"report_data\",\"suborg\":\"四川分公司\",\"transAmount\":2.4511015369E8,\"grossProfit\":284441.21,\"income\":1094942.37,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":14990,\"transNum\":81288,\"feifengdingTransAmount\":1.4410699308E8,\"feifengdingTransNum\":66298,\"fengdingTransAmount\":1.0100316061E8,\"cost\":810501.16},{\"report_node_type\":\"report_data\",\"suborg\":\"全国\",\"transAmount\":3305006.17,\"grossProfit\":1729.65,\"income\":6609.89,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":2,\"transNum\":661,\"feifengdingTransAmount\":3132338.17,\"feifengdingTransNum\":659,\"fengdingTransAmount\":172668.0,\"cost\":4880.24},{\"report_node_type\":\"report_data\",\"suborg\":\"哆啦宝\",\"transAmount\":32513.0,\"grossProfit\":67.28,\"income\":406.49,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":0,\"transNum\":81,\"feifengdingTransAmount\":32513.0,\"feifengdingTransNum\":81,\"fengdingTransAmount\":0.0,\"cost\":339.21},{\"report_node_type\":\"report_data\",\"suborg\":\"教育事业部\",\"transAmount\":6.273204308E7,\"grossProfit\":82343.54,\"income\":321000.46,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":117,\"transNum\":14098,\"feifengdingTransAmount\":6.086360307E7,\"feifengdingTransNum\":13981,\"fengdingTransAmount\":1868440.01,\"cost\":238656.92},{\"report_node_type\":\"report_data\",\"suborg\":\"福建分公司\",\"transAmount\":5.9498137704E8,\"grossProfit\":491150.95,\"income\":1591647.26,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":11815,\"transNum\":105865,\"feifengdingTransAmount\":3.369525541E8,\"feifengdingTransNum\":94050,\"fengdingTransAmount\":2.5802882294E8,\"cost\":1100496.31},{\"report_node_type\":\"report_data\",\"suborg\":\"广东分公司\",\"transAmount\":1.4811368786E8,\"grossProfit\":105580.85,\"income\":723238.28,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":6339,\"transNum\":34021,\"feifengdingTransAmount\":1.0214776226E8,\"feifengdingTransNum\":27682,\"fengdingTransAmount\":4.59659256E7,\"cost\":617657.43},{\"report_node_type\":\"report_data\",\"suborg\":\"航旅事业部\",\"transAmount\":1.7591639561E8,\"grossProfit\":41421.8,\"income\":609705.05,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":0,\"transNum\":71427,\"feifengdingTransAmount\":1.7591639561E8,\"feifengdingTransNum\":71427,\"fengdingTransAmount\":0.0,\"cost\":568283.25},{\"report_node_type\":\"report_data\",\"suborg\":\"浙江分公司\",\"transAmount\":1.0523815064E8,\"grossProfit\":55691.8,\"income\":183691.01,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":2600,\"transNum\":23124,\"feifengdingTransAmount\":4.861405833E7,\"feifengdingTransNum\":20524,\"fengdingTransAmount\":5.662409231E7,\"cost\":127999.21},{\"report_node_type\":\"report_data\",\"suborg\":\"保险事业部\",\"transAmount\":9.7700628034E8,\"grossProfit\":-3001202.92,\"income\":42251.6,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":0,\"transNum\":299846,\"feifengdingTransAmount\":9.7700628034E8,\"feifengdingTransNum\":299846,\"fengdingTransAmount\":0.0,\"cost\":3043454.52},{\"report_node_type\":\"report_data\",\"suborg\":\"山东分公司\",\"transAmount\":4.320519933E7,\"grossProfit\":35862.96,\"income\":159508.8,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":297,\"transNum\":15316,\"feifengdingTransAmount\":3.980376106E7,\"feifengdingTransNum\":15019,\"fengdingTransAmount\":3401438.27,\"cost\":123645.84},{\"report_node_type\":\"report_data\",\"suborg\":\"江苏分公司\",\"transAmount\":2.2531214095E8,\"grossProfit\":109992.91,\"income\":419033.84,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":4617,\"transNum\":33601,\"feifengdingTransAmount\":1.7806063395E8,\"feifengdingTransNum\":28984,\"fengdingTransAmount\":4.7251507E7,\"cost\":309040.93},{\"report_node_type\":\"report_data\",\"suborg\":\"内蒙古分公司\",\"transAmount\":2.315301759E7,\"grossProfit\":28184.12,\"income\":82537.84,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":1752,\"transNum\":8385,\"feifengdingTransAmount\":1.066494726E7,\"feifengdingTransNum\":6633,\"fengdingTransAmount\":1.248807033E7,\"cost\":54353.72},{\"report_node_type\":\"report_data\",\"suborg\":\"线下收单业务部\",\"transAmount\":31980.0,\"grossProfit\":20.37,\"income\":121.52,\"trx_date\":\"2015-10-09\",\"fengdingTransNum\":0,\"transNum\":31,\"feifengdingTransAmount\":31980.0,\"feifengdingTransNum\":31,\"fengdingTransAmount\":0.0,\"cost\":101.15}]";
        	//JSONObject obj = JSONObject.fromObject(result);
        	System.out.println(result);
        	JSONArray obj=new JSONArray(result);
        	System.out.println(obj);
        	//得到标题
        	JSONArray title = obj.getJSONObject(0).getJSONArray("report_title");
        	System.out.println(title.toString());
        	Map titleMap = new HashMap();
        	List fields = new ArrayList();
        	List allData = new ArrayList();
        	for(int i=0; i<title.length(); i++) {
        		Object field = title.getJSONObject(i).get("field");
        		fields.add(field);
        		Object text = title.getJSONObject(i).get("text");
        		titleMap.put(field, text);
        	}
        	allData.add(titleMap);
        	//得到表体
        	for(int i=1; i<obj.length(); i++) {
        		Map bodyMap = new HashMap();
        		for(int j=0; j<fields.size(); j++) {
        			Object field = fields.get(j);
        			Object value = obj.getJSONObject(i).get(field.toString());
        			bodyMap.put(field, value);
        		}
        		allData.add(bodyMap);
        	}
        	System.out.println(allData.toString());
        	JSONArray abc=new JSONArray(allData);
        	
        	return abc.toString();
		}
        public static void main(String[] args) { 
                //String y = doGet("http://220.181.105.17:8999/doggie-engine/bigdata/v1/online/DO_ACCOUNT?account_id=616976&timespan=2014-04-01,2014-04-01&filter=biz_type,EQUAL,RECEIVE", null, "UTF-8", true);
        	//String result = doGet("http://220.181.105.17:8999/doggie-engine/bigdata/pos/report?report_type=trans_stat_report&timespan=2015-10-01,2015-10-02&summeryWeek=day&group=suborg&branchname=ACTUALGOODS,BANKCOOP,BJ,CD,CQ,DUOLABAO,EDU,FUND,FZ,GD,GX,GZ,GZZC,HK,HN,HOTELO2O,HZ,INNOVATION,INSURANCE,JN,KUAJING,KXLS,MARKET,MONEY,NJ,NMG,POSDEPARTMENT,SH,SHPRODUCT,SX,SY,SZ,SZYL,TELECOM,TJ,TJINSURANCE,WH,XA,YHJ,YN,YPFINANCE,YTRX,ZZ,CHN&pageno=1&pagesize=15", null, "UTF-8", true);
        	String result = "[{\"report_node_type\":\"report_title\",\"report_stat_timespan\":\"日期: 2015-10-01 至 2015-10-24\",\"report_name\":\"交易日统计\",\"chartTypes\":[],\"report_conditions\":[\"日期: 从2015-10-01 到2015-10-24\",\"所属分公司/行业线: \"],\"report_title\":[{\"text\":\"交易日期\",\"field\":\"trx_date\",\"presentType\":\"date\",\"presentFormat\":\"yyyy-MM-dd\",\"order\":true},{\"text\":\"分公司/行业线\",\"field\":\"suborg\",\"presentType\":\"string\",\"presentFormat\":\"\",\"order\":false},{\"text\":\"交易笔数\",\"field\":\"transNum\",\"presentType\":\"number\",\"presentFormat\":\"'0'\",\"order\":false},{\"text\":\"封顶交易笔数\",\"field\":\"fengdingTransNum\",\"presentType\":\"number\",\"presentFormat\":\"'0'\",\"order\":false},{\"text\":\"非封顶交易笔数\",\"field\":\"feifengdingTransNum\",\"presentType\":\"number\",\"presentFormat\":\"'0'\",\"order\":false},{\"text\":\"总交易金额\",\"field\":\"transAmount\",\"presentType\":\"number\",\"presentFormat\":\"'0.00'\",\"order\":false},{\"text\":\"封顶交易金额\",\"field\":\"fengdingTransAmount\",\"presentType\":\"number\",\"presentFormat\":\"'0.00'\",\"order\":false},{\"text\":\"非封顶交易金额\",\"field\":\"feifengdingTransAmount\",\"presentType\":\"number\",\"presentFormat\":\"'0.00'\",\"order\":false},{\"text\":\"收入\",\"field\":\"income\",\"presentType\":\"number\",\"presentFormat\":\"'0.00'\",\"order\":false},{\"text\":\"成本\",\"field\":\"cost\",\"presentType\":\"number\",\"presentFormat\":\"'0.00'\",\"order\":false},{\"text\":\"毛利\",\"field\":\"grossProfit\",\"presentType\":\"number\",\"presentFormat\":\"'0.00'\",\"order\":false}]},{\"report_node_type\":\"report_data\",\"suborg\":\"银行合作部\",\"transAmount\":1.7246318343E8,\"grossProfit\":-716587.73,\"income\":19584.49,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":5071,\"transNum\":22582,\"feifengdingTransAmount\":6.908587589E7,\"feifengdingTransNum\":17511,\"fengdingTransAmount\":1.0337730754E8,\"cost\":736172.22},{\"report_node_type\":\"report_data\",\"suborg\":\"北京分公司\",\"transAmount\":4.40097677E7,\"grossProfit\":29804.76,\"income\":137226.11,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":1791,\"transNum\":10900,\"feifengdingTransAmount\":2.091111667E7,\"feifengdingTransNum\":9109,\"fengdingTransAmount\":2.309865103E7,\"cost\":107421.35},{\"report_node_type\":\"report_data\",\"suborg\":\"四川分公司\",\"transAmount\":2.4511015369E8,\"grossProfit\":284441.21,\"income\":1094942.37,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":14990,\"transNum\":81288,\"feifengdingTransAmount\":1.4410699308E8,\"feifengdingTransNum\":66298,\"fengdingTransAmount\":1.0100316061E8,\"cost\":810501.16},{\"report_node_type\":\"report_data\",\"suborg\":\"全国\",\"transAmount\":3305006.17,\"grossProfit\":1729.65,\"income\":6609.89,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":2,\"transNum\":661,\"feifengdingTransAmount\":3132338.17,\"feifengdingTransNum\":659,\"fengdingTransAmount\":172668.0,\"cost\":4880.24},{\"report_node_type\":\"report_data\",\"suborg\":\"哆啦宝\",\"transAmount\":32513.0,\"grossProfit\":67.28,\"income\":406.49,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":0,\"transNum\":81,\"feifengdingTransAmount\":32513.0,\"feifengdingTransNum\":81,\"fengdingTransAmount\":0.0,\"cost\":339.21},{\"report_node_type\":\"report_data\",\"suborg\":\"教育事业部\",\"transAmount\":6.273204308E7,\"grossProfit\":82343.54,\"income\":321000.46,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":117,\"transNum\":14098,\"feifengdingTransAmount\":6.086360307E7,\"feifengdingTransNum\":13981,\"fengdingTransAmount\":1868440.01,\"cost\":238656.92},{\"report_node_type\":\"report_data\",\"suborg\":\"福建分公司\",\"transAmount\":5.9498137704E8,\"grossProfit\":491150.95,\"income\":1591647.26,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":11815,\"transNum\":105865,\"feifengdingTransAmount\":3.369525541E8,\"feifengdingTransNum\":94050,\"fengdingTransAmount\":2.5802882294E8,\"cost\":1100496.31},{\"report_node_type\":\"report_data\",\"suborg\":\"广东分公司\",\"transAmount\":1.4811368786E8,\"grossProfit\":105580.85,\"income\":723238.28,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":6339,\"transNum\":34021,\"feifengdingTransAmount\":1.0214776226E8,\"feifengdingTransNum\":27682,\"fengdingTransAmount\":4.59659256E7,\"cost\":617657.43},{\"report_node_type\":\"report_data\",\"suborg\":\"航旅事业部\",\"transAmount\":1.7591639561E8,\"grossProfit\":41421.8,\"income\":609705.05,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":0,\"transNum\":71427,\"feifengdingTransAmount\":1.7591639561E8,\"feifengdingTransNum\":71427,\"fengdingTransAmount\":0.0,\"cost\":568283.25},{\"report_node_type\":\"report_data\",\"suborg\":\"浙江分公司\",\"transAmount\":1.0523815064E8,\"grossProfit\":55691.8,\"income\":183691.01,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":2600,\"transNum\":23124,\"feifengdingTransAmount\":4.861405833E7,\"feifengdingTransNum\":20524,\"fengdingTransAmount\":5.662409231E7,\"cost\":127999.21},{\"report_node_type\":\"report_data\",\"suborg\":\"保险事业部\",\"transAmount\":9.7700628034E8,\"grossProfit\":-3001202.92,\"income\":42251.6,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":0,\"transNum\":299846,\"feifengdingTransAmount\":9.7700628034E8,\"feifengdingTransNum\":299846,\"fengdingTransAmount\":0.0,\"cost\":3043454.52},{\"report_node_type\":\"report_data\",\"suborg\":\"山东分公司\",\"transAmount\":4.320519933E7,\"grossProfit\":35862.96,\"income\":159508.8,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":297,\"transNum\":15316,\"feifengdingTransAmount\":3.980376106E7,\"feifengdingTransNum\":15019,\"fengdingTransAmount\":3401438.27,\"cost\":123645.84},{\"report_node_type\":\"report_data\",\"suborg\":\"江苏分公司\",\"transAmount\":2.2531214095E8,\"grossProfit\":109992.91,\"income\":419033.84,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":4617,\"transNum\":33601,\"feifengdingTransAmount\":1.7806063395E8,\"feifengdingTransNum\":28984,\"fengdingTransAmount\":4.7251507E7,\"cost\":309040.93},{\"report_node_type\":\"report_data\",\"suborg\":\"内蒙古分公司\",\"transAmount\":2.315301759E7,\"grossProfit\":28184.12,\"income\":82537.84,\"trx_date\":\"2015-10-01\",\"fengdingTransNum\":1752,\"transNum\":8385,\"feifengdingTransAmount\":1.066494726E7,\"feifengdingTransNum\":6633,\"fengdingTransAmount\":1.248807033E7,\"cost\":54353.72},{\"report_node_type\":\"report_data\",\"suborg\":\"线下收单业务部\",\"transAmount\":31980.0,\"grossProfit\":20.37,\"income\":121.52,\"trx_date\":\"2015-10-09\",\"fengdingTransNum\":0,\"transNum\":31,\"feifengdingTransAmount\":31980.0,\"feifengdingTransNum\":31,\"fengdingTransAmount\":0.0,\"cost\":101.15}]";
        	//JSONObject obj = JSONObject.fromObject(result);
        	System.out.println(result);
        	JSONArray obj=new JSONArray(result);
        	System.out.println(obj);
        	//得到标题
        	JSONArray title = obj.getJSONObject(0).getJSONArray("report_title");
        	System.out.println(title.toString());
        	Map titleMap = new HashMap();
        	List fields = new ArrayList();
        	List allData = new ArrayList();
        	for(int i=0; i<title.length(); i++) {
        		Object field = title.getJSONObject(i).get("field");
        		fields.add(field);
        		Object text = title.getJSONObject(i).get("text");
        		titleMap.put(field, text);
        	}
        	allData.add(titleMap);
        	//得到表体
        	for(int i=1; i<obj.length(); i++) {
        		Map bodyMap = new HashMap();
        		for(int j=0; j<fields.size(); j++) {
        			Object field = fields.get(j);
        			Object value = obj.getJSONObject(i).get(field.toString());
        			bodyMap.put(field, value);
        		}
        		allData.add(bodyMap);
        	}
        	
        	System.out.println(allData.toString());
        	JSONArray abc=new JSONArray(allData);
        	System.out.println("abc="+abc);
        	System.out.println(allData.size());
        	
//        	String str = HttpTookit.getDate();
//        	System.out.println("str----"+str);
        	
        } 
}
