<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>青鸟租房 - 首页</title>
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<script type="text/javascript" src="scripts/function.js"></script>
	<script type="text/javascript">
		function toUrl(url){
			window.location.href = url;
			return;
		}
		
		function doSearch(){
			var f = document.getElementById('sform');
			f.submit();
		}
	</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="search">
		<label class="ui-green"><input onclick="toUrl('page/add.jsp');" type="button" name="search" value="发布房屋信息" /></label>
		<label class="ui-green"><input type="button" name="search" value="退       出" onclick='document.location="index.jsp"'/></label>
	</div>
</div>
<div id="navbar" class="wrap">

	<dl class="search clearfix">
		<form method="post" action="showListHouse.action" id='sform'>
			<dt>
				<ul>
					<li class="bold">房屋信息</li>
					<li>
						标题：<input type="text" class="text"  value='<s:property value="house.title"/>' name="house.title" />
						<label class="ui-blue"><input type="button" onclick='doSearch()' name="search" value="搜索房屋" /></label>
					</li>
				</ul>
			</dt>
			<dd>
				<ul>
					<li class="first">
						价格
					</li>
					<li>
						<select name='house.price'>
							<option value='0'>不限</option>
                            <option <s:if test="house.price==1">selected="selected"</s:if> value='1'>100元以下</option>
							<option <s:if test="house.price==2">selected="selected"</s:if> value='2'>100元—200元</option>
							<option <s:if test="house.price==3">selected="selected"</s:if> value='3'>200元以上</option>
						</select>
					</li>
				</ul>
			</dd>
			<dd>
				<ul>
					<li class="first">房屋位置</li>
					<li>
							<select name='house.streetId' id='street'>
								<option value='0'>不限</option>
								<option <s:if test="house.streetId==1">selected="selected"</s:if> value='1'>桂花路</option>
								<option <s:if test="house.streetId==2">selected="selected"</s:if> value='2'>深南路1</option>
								<option <s:if test="house.streetId==3">selected="selected"</s:if> value='3'>深南路2</option>
								<option <s:if test="house.streetId==4">selected="selected"</s:if> value='4'>东湖街道</option>
							</select>
					</li>
				</ul>
			</dd>
			<dd>
				<ul>
					<li class="first">房型</li>
					<li>
							<select name='house.typeId'>
								<option value='0'>不限</option>
								<option <s:if test="house.typeId==1000">selected="selected"</s:if> value='1000'>一室一厅</option>
								<option <s:if test="house.typeId==1001">selected="selected"</s:if> value='1001'>一室两厅</option>
								<option <s:if test="house.typeId==1002">selected="selected"</s:if> value='1002'>两室一厅</option>
								<option <s:if test="house.typeId==1003">selected="selected"</s:if> value='1003'>两室两厅</option>
							</select>
					</li>
				</ul>
			</dd>
			<dd>
				<ul>
					<li class="first">
						面积
					</li>
					<li>
							<select name='house.floorage'>
								<option value='0'>不限</option>
								<option <s:if test="house.floorage==1">selected="selected"</s:if> value='1'>40以下</option>
								<option <s:if test="house.floorage==2">selected="selected"</s:if> value='2'>40-500</option>
								<option <s:if test="house.floorage==3">selected="selected"</s:if> value='3'>500以上</option>
							</select>
					</li>
				</ul>
			</dd>
		</form>
	</dl>
</div>
<div class="main wrap">
	<table class="house-list">
	<s:if test="pager.datas!=null">
	<s:iterator value="pager.datas" status="status" >
		<tr>
			<td class="house-thumb"><span>
				<s:url value="show.action" id="show">
					<s:param name="id" value="id"></s:param>
				</s:url>
				<s:a href="%{show}"><img src="images/<s:property value="houseImg"/>" width="100" height="75"/></s:a>
			</span>	</td>
			<td>
				<dl>
					<dt><s:property value="title"/></dt>
					<dd>
						<s:property value="street.district.name"/>区
						<s:property value="street.name"/>，
						<s:property value="floorage"/>平米<br/>
						联系方式<s:property value="contact"/>
					</dd>
				</dl>
			</td>
			<td class="house-type"><s:property value="type.name"/></td>
			<td class="house-price"><span><s:property value="price"/></span>元/月</td>
		</tr>
	</s:iterator>
	</s:if>   

	</table>
	<div class="pager">
		<ul>
			<li class="current">
			<s:url id="first" value="showListHouse.action">
				<s:param name="number" value="1"></s:param>
			</s:url>
			<s:a href="%{first}">首页</s:a>
			<!-- <a href="/HouseRent/index.action?number=1">首页</a> --></li>
			<li>
			<s:url id="pre" value="showListHouse.action">
				<s:param name="number" value="pager.pageNo-1 < 1 ? 1: pager.pageNo-1 "></s:param>
			</s:url>
			<s:a href="%{pre}">上一页</s:a>
			<%-- <a href='/HouseRent/index.action?number=<s:property value="prev"/>'>上一页</a> --%></li>
			<li>
			<s:url id="nex" value="showListHouse.action">
				<s:param name="number" value="pager.pageNo+1 > pager.totalPage ? pager.totalPage : pager.pageNo+1 "></s:param>
			</s:url>
			<s:a href="%{nex}">下一页</s:a>
			<%-- <a href='/HouseRent/index.action?number=<s:property value="next"/>'>下一页</a> --%></li>
			<li>
			<s:url id="last" value="showListHouse.action">
				<s:param name="number" value="pager.totalPage"></s:param>
			</s:url>
			<s:a href="%{last}">末页</s:a>
			<%-- <a href='/HouseRent/index.action?number=<s:property value="total"/>'>末页</a> --%></li>
		</ul>
		<span class="total">${pager.pageNo}/<s:property value="pager.totalPage"/>页</span>
	</div>
</div>
<div id="footer" class="wrap">
	<dl>
    	<dt>青鸟租房 &copy; 2010 北大青鸟 京ICP证1000001号</dt>
        <dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
    </dl>
</div>
</body>
</html>