/**
 * New node file
 */
//下载日志查询时，必输项检查
function gotoOperateLogPage(pageNo) {
   var starttime=$("#starttime").val();
   var endtime=$("#endtime").val();
   if(starttime==''||endtime==''){
   		alert("请输入开始时间和结束时间");
   		return false;
   }
  $("#pageNo").val(pageNo || 1);
  $("#operatelogForm").submit();
}
function download(filename,filepath){
	$("#fileinfo").value=filepath+filename;
}

/*根据传入的时间参数，判断日期是否为周一
 * return : 参数日期为星期一，则返回true
 * 			    否则返回false
 */
function checkMonday(t1){
	var d = new Date(t1);
	if(d.getDay()==1){
		return true;
	}else{
		return false;
	}
}

function checkTime(summeryType,fieldType){
	if(summeryType=="day")//统计周期为日时，不检查
		return true;
	if(summeryType=="week"){//统计周期为周时，检查
		if(fieldType=="start"){
			if($("#startTime").val()!=null&&!checkMonday($("#startTime").val())){
				alert("统计周期选择周时，统计开始时间必须选择周一");
				return false;
			}else{
				return true;
			}
		}else if(fieldType=="end"){
			if($("#endTime").val()!=null&&!checkMonday($("#endTime").val())){
				alert("统计周期选择周时，统计结束时间必须选择周一");
				return false;
			}else{
				return true;
			}
		}
	}else if(summeryType=="month"){//统计周期为月时，检查
		if(fieldType=="start"){
			if($("#startTime").val().substr(7)!="-01"){
				alert("统计周期选择月时，统计开始时间必须为当月的1号");
				return false;
			}else{
				return true;
			}
		}else if(fieldType=="end"){
			if($("#endTime").val().substr(7)!="-01"){
				alert("统计周期选择月时，统计结束时间必须为当月的1号");
				return false;
			}else{
				return true;
			}
		}
	}
}

//商户统计查询时，必输项检查
function commonCheck(type){
	var startTime=$("#startTime").val();
	var endTime=$("#endTime").val();
	var summeryWeek=$("#summeryWeek").val();
	if(startTime==''||endTime==''){
		alert("请输入开始时间和结束时间");
   		return false;
	}
	
	var checkStartFlag = checkTime($("#summeryWeek").val(),"start");
	if(!checkStartFlag){
		return false;
	}
	
	var checkEndFlag = checkTime($("#summeryWeek").val(),"end");
	if(!checkEndFlag){
		return false;
	}
	
	//检查统计开始时间和统计结束时间大小
	if(startTime>endTime){
		alert("统计开始时间必须小于或者等于统计结束时间");
   		return false;
	}
	
	$("#downType").val(type);
	$("#submitForm").submit();
}

//商户统计查询时，必输项检查
function unionCheck(type){
	var startTime=$("#startTime").val();
	var endTime=$("#endTime").val();
	var customer=$("#customers").val();
	if(!customer || customer==null){
		alert("商户号不能为空");
		return false;
	}
	if(startTime==''||endTime==''){
		alert("请输入开始时间和结束时间");
   		return false;
	}
	
	//检查统计开始时间和统计结束时间大小
	if(startTime>endTime){
		alert("统计开始时间必须小于或者等于统计结束时间");
   		return false;
	}
	
	$("#downType").val(type);
	$("#submitForm").submit();
}