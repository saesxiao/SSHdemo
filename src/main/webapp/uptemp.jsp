<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.text.*,com.ssh.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-UTF-8">
<title>员工管理</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader">
					<p>
						<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) %>
					</p>
				</div>
				<div id="topheader">
					<h1 id="title"><a href="#">main</a></h1>
				</div>
				<div id="navigation"></div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<h1>修改员工</h1>
				<form action="upt" method="post">
					<table class="table">
					<tr class="table_header">
						<td>ID</td><td>姓名</td><td>薪水</td><td>年龄</td>
					</tr>
					<tr class="row1">
						<%
							Emp e = (Emp)session.getAttribute("uemp");
						 %>
						<td><input name="id" style="border: 0; width: 100%; background-color: white;" value="<%=e.getId()%>" disabled="disabled"></td>
						<td><input name="ename" style="border: 0; width: 100%" value="<%=e.getEname()%>"></td>
						<td><input name="salary"  style="border: 0; width: 100%" value="<%=e.getSalary()%>"></td>
						<td><input name="age"  style="border: 0; width: 100%" value="<%=e.getAge()%>"></td>
						<input type="hidden" name="id" value="<%=e.getId()%>">
					</tr>
				</table>
				<p>
					<input type="submit" class="button" value="确认修改"/><a class="abutton" href="list">返&nbsp;&nbsp;回</a>
				</p>
				</form>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">Copy Gavin</div>
		</div>
	</div>
</body>
</html>