<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/pages/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>1111111</title>
	<link href="${ctxStatic}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
	<script src="${ctxStatic}/static/js/jquery-3.2.1.min.js"></script>
	<script src="${ctxStatic}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body >
	<table class="table">
	<caption>上下文表格布局</caption>
	<thead>
		<tr>
			<th>产品</th>
			<th>付款日期</th>
			<th>状态</th>
		</tr>
	</thead>
	<tbody>
		<tr class="active">
			<td>产品1</td>
			<td>23/11/2013</td>
			<td>待发货</td>
		</tr>
		<tr class="success">
			<td>产品2</td>
			<td>10/11/2013</td>
			<td>发货中</td>
		</tr>
		<tr  class="warning">
			<td>产品3</td>
			<td>20/10/2013</td>
			<td>待确认</td>
		</tr>
		<tr  class="danger">
			<td>产品4</td>
			<td>20/10/2013</td>
			<td>已退货</td>
		</tr>
	</tbody>
</table>
</body>
</html>
