package com.rxkj.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rxkj.utils.HttpTookit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("transViews")
public class TransViewsController {
	
	@RequestMapping(value="/go",method=RequestMethod.GET)
	public ModelAndView queryTransViews(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException {
		ModelAndView mav=new ModelAndView("transViews");
		Map<String,String[]> map = req.getParameterMap();
		for(String key:map.keySet()){
			System.out.println(key+"---------"+map.get(key)[0]);
			mav.addObject(key, req.getParameterMap().get(key));
		}
		System.out.println(new ObjectMapper().writeValueAsString(map));
		return mav;
	}
	
	@RequestMapping("queryTransView")
	@ResponseBody
	public String queryTransViews2(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException {
		
		String str2 = "[{\"trx_date\":\"2015-10-01\",\"suborg\":\"银行合作部\",\"transNum\":22582,\"fengdingTransNum\":5071,\"feifengdingTransNum\":17511,\"transAmount\":172463183.43,\"fengdingTransAmount\":103377307.54,\"feifengdingTransAmount\":69085875.89,\"income\":19584.49,\"cost\":736172.22,\"grossProfit\":-716587.73},{\"trx_date\":\"2015-10-01\",\"suborg\":\"北京分公司\",\"transNum\":10900,\"fengdingTransNum\":1791,\"feifengdingTransNum\":9109,\"transAmount\":44009767.7,\"fengdingTransAmount\":23098651.03,\"feifengdingTransAmount\":20911116.67,\"income\":137226.11,\"cost\":107421.35,\"grossProfit\":29804.76},{\"trx_date\":\"2015-10-01\",\"suborg\":\"四川分公司\",\"transNum\":81288,\"fengdingTransNum\":14990,\"feifengdingTransNum\":66298,\"transAmount\":245110153.69,\"fengdingTransAmount\":101003160.61,\"feifengdingTransAmount\":144106993.08,\"income\":1094942.37,\"cost\":810501.16,\"grossProfit\":284441.21},{\"trx_date\":\"2015-10-01\",\"suborg\":\"全国\",\"transNum\":661,\"fengdingTransNum\":2,\"feifengdingTransNum\":659,\"transAmount\":3305006.17,\"fengdingTransAmount\":172668,\"feifengdingTransAmount\":3132338.17,\"income\":6609.89,\"cost\":4880.24,\"grossProfit\":1729.65},{\"trx_date\":\"2015-10-01\",\"suborg\":\"哆啦宝\",\"transNum\":81,\"fengdingTransNum\":0,\"feifengdingTransNum\":81,\"transAmount\":32513,\"fengdingTransAmount\":0,\"feifengdingTransAmount\":32513,\"income\":406.49,\"cost\":339.21,\"grossProfit\":67.28},{\"trx_date\":\"2015-10-01\",\"suborg\":\"教育事业部\",\"transNum\":14098,\"fengdingTransNum\":117,\"feifengdingTransNum\":13981,\"transAmount\":62732043.08,\"fengdingTransAmount\":1868440.01,\"feifengdingTransAmount\":60863603.07,\"income\":321000.46,\"cost\":238656.92,\"grossProfit\":82343.54},{\"trx_date\":\"2015-10-01\",\"suborg\":\"福建分公司\",\"transNum\":105865,\"fengdingTransNum\":11815,\"feifengdingTransNum\":94050,\"transAmount\":594981377.04,\"fengdingTransAmount\":258028822.94,\"feifengdingTransAmount\":336952554.1,\"income\":1591647.26,\"cost\":1100496.31,\"grossProfit\":491150.95},{\"trx_date\":\"2015-10-01\",\"suborg\":\"广东分公司\",\"transNum\":34021,\"fengdingTransNum\":6339,\"feifengdingTransNum\":27682,\"transAmount\":148113687.86,\"fengdingTransAmount\":45965925.6,\"feifengdingTransAmount\":102147762.26,\"income\":723238.28,\"cost\":617657.43,\"grossProfit\":105580.85},{\"trx_date\":\"2015-10-01\",\"suborg\":\"航旅事业部\",\"transNum\":71427,\"fengdingTransNum\":0,\"feifengdingTransNum\":71427,\"transAmount\":175916395.61,\"fengdingTransAmount\":0,\"feifengdingTransAmount\":175916395.61,\"income\":609705.05,\"cost\":568283.25,\"grossProfit\":41421.8},{\"trx_date\":\"2015-10-01\",\"suborg\":\"浙江分公司\",\"transNum\":23124,\"fengdingTransNum\":2600,\"feifengdingTransNum\":20524,\"transAmount\":105238150.64,\"fengdingTransAmount\":56624092.31,\"feifengdingTransAmount\":48614058.33,\"income\":183691.01,\"cost\":127999.21,\"grossProfit\":55691.8},{\"trx_date\":\"2015-10-01\",\"suborg\":\"保险事业部\",\"transNum\":299846,\"fengdingTransNum\":0,\"feifengdingTransNum\":299846,\"transAmount\":977006280.34,\"fengdingTransAmount\":0,\"feifengdingTransAmount\":977006280.34,\"income\":42251.6,\"cost\":3043454.52,\"grossProfit\":-3001202.92},{\"trx_date\":\"2015-10-01\",\"suborg\":\"山东分公司\",\"transNum\":15316,\"fengdingTransNum\":297,\"feifengdingTransNum\":15019,\"transAmount\":43205199.33,\"fengdingTransAmount\":3401438.27,\"feifengdingTransAmount\":39803761.06,\"income\":159508.8,\"cost\":123645.84,\"grossProfit\":35862.96},{\"trx_date\":\"2015-10-01\",\"suborg\":\"江苏分公司\",\"transNum\":33601,\"fengdingTransNum\":4617,\"feifengdingTransNum\":28984,\"transAmount\":225312140.95,\"fengdingTransAmount\":47251507,\"feifengdingTransAmount\":178060633.95,\"income\":419033.84,\"cost\":309040.93,\"grossProfit\":109992.91},{\"trx_date\":\"2015-10-01\",\"suborg\":\"内蒙古分公司\",\"transNum\":8385,\"fengdingTransNum\":1752,\"feifengdingTransNum\":6633,\"transAmount\":23153017.59,\"fengdingTransAmount\":12488070.33,\"feifengdingTransAmount\":10664947.26,\"income\":82537.84,\"cost\":54353.72,\"grossProfit\":28184.12},{\"trx_date\":\"2015-10-09\",\"suborg\":\"线下收单业务部\",\"transNum\":31,\"fengdingTransNum\":0,\"feifengdingTransNum\":31,\"transAmount\":31980,\"fengdingTransAmount\":0,\"feifengdingTransAmount\":31980,\"income\":121.52,\"cost\":101.15,\"grossProfit\":20.37}]";
		System.out.println("function 2");
		String str = HttpTookit.getDate();
		System.out.println("strstrstrstrstrstr"+str);
		System.out.println("str2"+str2);
		return str;
//		MyModel m=new MyModel();
//		m.setStartTime("111111111");
//		JSONObject obj=new JSONObject();
//		obj.put("startTime", "2015-01-01");
//		obj.put("endTime", "uuuuuuu");
		
//		return new ObjectMapper().writeValueAsString(m);
//		return obj.toString();
	}

}
