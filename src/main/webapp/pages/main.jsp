<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/pages/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大猪美导航</title>
<link rel="icon" href="${ctxStatic}/static/imgs/favicon.ico" type="image/x-icon">
<link href="${ctxStatic}/static/css/reset-common927.css" rel="stylesheet" />
<link href="${ctxStatic}/static/css/common-baidu_search0927.css?v=1109" rel="stylesheet" />
<link href="${ctxStatic}/static/css/sug.css" rel="stylesheet" />
<link href="${ctxStatic}/static/css/text_common-content_mouseoverout0927.css" rel="stylesheet" />
<link href="${ctxStatic}/static/css/extra.css" rel="stylesheet" />
<script src="${ctxStatic}/static/js/jquery-3.2.1.min.js"></script>
<script src="${ctxStatic}/static/js/jquery-3.2.1.js"></script>
<script src="${ctxStatic}/static/js/angular.js"></script>
<script src="${ctxStatic}/static/js/angular.min.js"></script>
<style>
.ng-cloak{ 
display: none!important; 
} 
</style>

</head>
	<body class="ng-cloak" ng-app="myApp" ng-controller="myCtrl" background="${ctxStatic}/static/imgs/body_log.gif">
		<div id="hd" style="width: 100%; height: 230px;text-align: center;">
			<div id="hd-up" style="width: 1200px; height: 113px;margin: 0 auto;">
				<div style="width:176px;height: 64px;float:left;margin-left:300px;margin-top:23px;">
					<a href="http://www.baidu.com/" style="text-decoration: none;">
						<img src="${ctxStatic}/static/imgs/gaitubao_com_15148652873857.png" alt="DaZhuMei" align="bottom" border="0">
					</a>
				</div>
				<div style="width: 500px;height: 100px; text-align: center;margin: 6px 440px;">
					<iframe allowtransparency="true" frameborder="0" width="410" height="98" scrolling="no" src="//tianqi.2345.com/plugin/widget/index.htm?s=1&z=1&t=1&v=0&d=2&bd=0&k=000000&f=&ltf=009944&htf=cc0000&q=1&e=1&a=1&c=54511&w=410&h=98&align=center"></iframe>
				</div>
			</div>
			<div id="hd-ft" style="width: 1200px; height: 113px;margin: 0 auto;overflow: hidden;">
				<form action="http://www.baidu.com/baidu" target="_blank">
					<table>
						<tr>
							<td>
								<div style="height: 45px;width: 1196px;">
									<a style="text-decoration: none;font-size: 20px;color: blueviolet;margin: 0px auto;" target="_blank" href="http://www.baidu.com/">百度</a>&nbsp;
									<a style="text-decoration: none;font-size: 20px;color: blueviolet;margin: 0px auto;" target="_blank" href="http://video.baidu.com/">视频</a>&nbsp;
									<a style="text-decoration: none;font-size: 20px;color: blueviolet;margin: 0px auto;" target="_blank" href="http://mp3.baidu.com/">音乐</a>&nbsp;
									<a style="text-decoration: none;font-size: 20px;color: blueviolet;margin: 0px auto;" target="_blank" href="http://image.baidu.com/">图片</a>&nbsp;
									<a style="text-decoration: none;font-size: 20px;color: blueviolet;margin: 0px auto;" target="_blank" href="http://tieba.baidu.com/">贴吧</a>&nbsp;
									<a style="text-decoration: none;font-size: 20px;color: blueviolet;margin: 0px auto;" target="_blank" href="https://www.toutiao.com/">头条</a>&nbsp;
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div style="height: 50px;margin: 1px auto;width: 760px;">
									<input name="tn" type="hidden" value="=divencheng_pg&word=">
									<div style="height: 48px; width: 150px;float:left;">
										<div style="height: 48px; width: 150px;margin-top: 8px;">
											<a href="http://www.baidu.com/">
												<img src="//123p2.sogoucdn.com/u/dhqq/v2/img/searchimages/baidu.web.png?v=4" alt="Baidu" align="bottom" border="0">
											</a>
										</div>
									</div>
									<div style="height: 48px; width: 500px;float: left;">
										<input type="text" name="word" size="30" baiduSug="1" style="font-size:large;height: 30px;width: 500px;margin-top: 7px;">
									</div>
									<div style="height: 48px; width: 100px;float: left;">
										<input type="submit" value="百度搜索" style="height: 35px;width: 90px;margin-top: 7px;">
									</div>
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>

		<div id="bd">
			<div class="mod-content clearfix">
				<div class="content-con "  ng-repeat="t in tlist">
					<h2 class="content-title">
						{{t.title}}<span class="content-title-des"></span>
					</h2>
					<ul class="content-link">
						<li ng-if="t.labelId==u.pid"  ng-repeat="u in ulist">
							<h3 class="last-row">
								<div>
									<a href="{{u.url}}" target="_blank" class="text-con">{{u.title}}</a>
								</div>
							</h3>
						</li>
					</ul>
				</div>
			</div>
		</div>
			
			
		
		<div id="ft">
			
		
		</div>
		
		<script charset="gbk" src="http://www.baidu.com/js/opensug.js"></script>

	<script>
	var app = angular.module("myApp", []);
	app.controller("myCtrl", function($scope,$http) {
		 $http.get("${ctxStatic}/label/selectAllLabelByUserId?userId="+1).success( function(data) {
			 $scope.tlist = data.tlist;
			 $scope.ulist = data.ulist;
          });
	});
	</script>
</body>
</html>