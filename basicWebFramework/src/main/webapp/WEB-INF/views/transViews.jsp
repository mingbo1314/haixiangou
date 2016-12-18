<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
%>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title>DataPortal & 商户交易查询</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" media="screen" href="<%=basePath %>/public/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" type="text/css" media="screen" href="<%=basePath %>/public/css/bootstrap.min.css">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
        }
      .sidebar-nav {
        padding: 9px 0;
      }

      @media (max-width: 980px) {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right {
          float: none;
          padding-left: 5px;
          padding-right: 5px;
        }
      }
    </style>
    <link href="<%=basePath %>/public/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    
    <script type="text/javascript" src="<%=basePath %>/public/js/jquery-1.8.3.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="<%=basePath %>/public/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>/public/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>/public/js/api/pos.js"></script>
    <!-- Fav and touch icons -->
    <link rel="shortcut icon" href="<%=basePath %>/public/img/favicon.ico">
    <link rel="apple-touch-icon" href="<%=basePath %>/public/img/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="<%=basePath %>/public/img/apple-touch-icon-precomposed.png">
    <link rel="apple-touch-icon" sizes="114x114" href="<%=basePath %>/public/img/apple-touch-icon-114x114-precomposed.png">
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container-fluid">
      <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="brand" href="#">Data Portal</a>
      <div class="nav-collapse collapse">
        <p class="navbar-text pull-right">
                当前用户：杨明 <a href="/dataportal/logout.action" class="navbar-link">退出</a>
        </p>
        <ul class="nav">
          <li class="active"><a href="/dataportal/dp/notice.action">首页</a></li>
          <li><a href="/dataportal/dp/notice.action">更新动态</a></li>
          <li><a href="/dataportal/test/test.action">测试</a></li>
          <li><a href="#contact">Contact</a></li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </div>
</div>
    <script type="text/javascript">
        //检查查询的必输项
        /* alert(123);
        alert('${group[0]}'); */
        function searchForm(type){
        	
            var startTime=$("#startTime").val();
            var endTime=$("#endTime").val();
            var summeryWeek = $("#summeryWeek").val();
            var group = $("#group").val();
            if(startTime==''||endTime==''){
                alert("请输入统计开始时间和结束时间");
                return false;
            }
            //检查统计开始时间和统计结束时间大小
            if(startTime>endTime){
                alert("统计开始时间必须小于或者等于统计结束时间");
                return false;
            }
            
            $.ajax({
            	url:'queryTransView',
            	cache:false,
            	dataType:'json',
            	data:{startTime:'2015',
            		endTime:''
            	},
            	success:function(response){
            		//alert(res);
            		var tabletitle = response[0];
                    //加载表格
                    var htmlcontent = '<table class="table table-hover table-responsive table-condensed table-bordered" style=" table-layout:fixed;">';
                    htmlcontent +='<thead><tr>';
                    //以下为单表头
                    for(var titlecell in tabletitle){
                        htmlcontent += '<th style="width:120px;">'+tabletitle[titlecell]+'</th>';
                    	//htmlcontent += '<th style="width:120px;">'+titlecell+'</th>';
                    }
                    htmlcontent += '</tr></thead><tbody>';
                    for(var i=1;i<response.length;i++){
                        var rowdata = response[i];
                        var html = '<tr>';
                        for(var key in rowdata){
                            // for(var j = 0;j<columnsArray.length;j++){
                                //html += '<td style="word-wrap:break-word;">'+key.toUpperCase(),rowdata[key]+'</td>';
                                html += '<td style="word-wrap:break-word;">'+rowdata[key]+'</td>';
                            //   }
                        }
                        html +='</tr>';
                        htmlcontent += html;
                    }
                    //单表头逻辑结束
                    htmlcontent += '</tbody><table>';
                    $("#columnsTable").html(htmlcontent);
                    $(".seletecdcolumnsstyle hgroup h4 span").toggleClass("icon-arrow-down");
            	}
            });
           /*  $.get('t2',{
	            "startTime":$("#startTime").val(),
	            "endTime":$("#endTime").val(),
	            "summeryWeek":$("#summeryWeek").val(),
	            "group":$("#group").val()
	        },function(response){
	        	
	        }); */
            //更改表单提交的url
            /* $('#submitForm').attr('action', 'transViews');
            $("#submitForm").submit(); */
        }
        function gotoPage(pageNo) {
            $("#pageNo").val(pageNo || 1);
            //更改表单提交的url
            $('#submitForm').attr('action', 'doQueryOfTrans.action');
            $("#submitForm").submit();
        }
       
    </script>
    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span2">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header"><a id="id" href="">商户交易查询</a></li>
                    <li class="nav-header"><a href="">商户交易查询</a></li>
                    <li class="nav-header"><a href="">商户交易查询</a></li>
                    <li class="nav-header"><a href="">商户交易查询</a></li>
                    <li class="nav-header"><a href="">商户交易查询</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span10">
	        <form class="form-horizontal" id="submitForm" name="submitForm" action="doQueryTrans.action">
	        		<fieldset>
						 <legend>商户交易查询</legend>
					</fieldset>
				  <div class="control-group" style="float:left;height:10px;">
				    <label class="control-label" for="summeryWeek">统计周期：</label>
				    <div class="controls">
				      <select id="summeryWeek" name="summeryWeek">
						  <option value="day" selected>日</option>
						</select>
				    </div>
				  </div>
				  <div class="control-group">
				    <label class="control-label" for="group">汇总维度：</label>
				    <div class="controls">
				      <select id="group" name="group">
						  <option value="suborg">分公司/行业线</option>
						  <option value="province">商户所属省</option>
						  <option value="city">商户所属市</option>
						</select>
				    </div>
				  </div>
				  <div class="control-group" style="float:left;height:10px;">
				    <label class="control-label">统计开始时间：</label>
				    <div class="controls input-append date" id="datetimepickerStart" style="margin-top:-30px;">
				      <input type="text" id="startTime" name="startTime" placeholder="" onblur="checkTime($('#summeryWeek').val(),'start')" value="" readonly="true">
				      <span class="add-on"><i class="icon-th"></i></span>
				    </div>
				  </div>
				  <div class="control-group">
				    <label class="control-label">统计结束时间：</label>
				    <div class=" input-append date" id="datetimepickerEnd">
				      <input type="text" id="endTime" name="endTime" placeholder="" onblur="checkTime($('#summeryWeek').val(),'end')" value="" readonly="true">
				      <span class="add-on"><i class="icon-th"></i></span>
				    </div>
				  </div>
				  <div class="control-group">
				    <div class="controls" style="padding-left:180px;">
                        <button type="button" class="btn" onclick="searchForm('trans_stat_report')">查询</button>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn" onclick="commonCheck('xlsx')">下载EXCEL</button>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn" onclick="commonCheck('csv')">下载CSV</button>
				    </div>
				  </div>
				  
				</form>
				<table class="table table-hover">
				<thead>
					<tr>
                        <th>
                                分公司/行业线
                            </th>
						<th>
							交易笔数
						</th>
						<th>
							封顶交易笔数
						</th>
						<th>
							非封顶交易笔数
						</th>
						<th>
							总交易金额
						</th>
						<th>
							封顶交易金额
						</th>
						<th>
							非封顶交易金额
						</th>
						<th>
							收入
						</th>
						<th>
							成本
						</th>
                        <th>
                            毛利
                        </th>
					</tr>
				</thead>
				<tbody>
			              <tr>
                             <td>${group[0]}</td>

			                <td>18</td>
			                <td>18</td>
			                <td>18</td>
			                <td>18</td>
			                <td>18</td>
			                <td>18</td>
			                <td>18</td>
			                <td>18</td>
                            <td>18</td>
			              </tr>
	             	 	
				</tbody>
			</table>
            <article class="span12" id="columnsTable" style="margin-left: -0.87%;margin-top: 10px;overflow-x:scroll;">
            </article>
        </div><!--/span-->
      </div><!--/row-->

      <hr>
      <footer>
    <div class="container">
        <p class="muted credit">www.dataportal.com  www.yeepay.com &nbsp;&nbsp;&nbsp;&nbsp;<a href="mailto:dp@yeepay.com">联系我们</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://www.yeepay.com">提意见</a>.</p>
     </div>
</footer>

</div><!--/.fluid-container-->
     <script type="text/javascript" src="<%=basePath %>/public/js/jquery-1.8.3.min.js">
    </script> 
    <script type="text/javascript" src="<%=basePath %>/public/js/bootstrap.min.js">
    </script>
    <script type="text/javascript" src="<%=basePath %>/public/js/bootstrap-datetimepicker.min.js">
    </script>
    <script type="text/javascript">
      $('#datetimepickerStart').datetimepicker({
        format: 'yyyy-MM-dd',
        language: 'en',
        pickDate: true,
        pickTime: true,
        hourStep: 1,
        minuteStep: 15,
        secondStep: 30,
        inputMask: true
      });
      $('#datetimepickerEnd').datetimepicker({
        format: 'yyyy-MM-dd',
        language: 'en',
        pickDate: true,
        pickTime: true,
        hourStep: 1,
        minuteStep: 15,
        secondStep: 30,
        inputMask: true
      });
    </script>
    
    
    <!-- Le javascript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=basePath %>/public/js/twitter-dev/bootstrap-transition.js"></script>
    <script src="<%=basePath %>/public/js/twitter-dev/bootstrap-alert.js"></script>
    <script src="<%=basePath %>/public/js/twitter-dev/bootstrap-modal.js"></script>
    <script src="<%=basePath %>/public/js/twitter-dev/bootstrap-dropdown.js"></script>
    <script src="<%=basePath %>/public/js/twitter-dev/bootstrap-scrollspy.js"></script>
    <script src="<%=basePath %>/public/js/twitter-dev/bootstrap-tab.js"></script>
    <script src="<%=basePath %>/public/js/twitter-dev/bootstrap-tooltip.js"></script>
    <script src="<%=basePath %>/public/js/twitter-dev/bootstrap-popover.js"></script>
    <script src="<%=basePath %>/public/js/twitter-dev/bootstrap-button.js"></script>
    <script src="<%=basePath %>/public/js/twitter-dev/bootstrap-collapse.js"></script>
    <script src="<%=basePath %>/public/js/twitter-dev/bootstrap-carousel.js"></script>
    <script src="<%=basePath %>/public/js/twitter-dev/bootstrap-typeahead.js"></script>
</body>
</html>