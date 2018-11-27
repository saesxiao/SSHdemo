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
					<h1 id="title"><a>员工管理</a></h1>
				</div>
				<div id="navigation"></div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<h1>员工列表</h1>
				<table class="table">
					<tr class="table_header">
						<td>ID</td><td>姓名</td><td>薪水</td><td>年龄</td><td>操作</td>
					</tr>
					<% 
						List<Emp> emps = (List<Emp>)session.getAttribute("empList");
						for(int i=0;i<emps.size();i++){
							Emp e = emps.get(i);
					%>
						<tr class="row<%=i%2+1 %>">
							<td><%=e.getId() %></td>
							<td><%=e.getEname() %></td>
							<td><%=e.getSalary() %></td>
							<td><%=e.getAge() %></td>
							<td>
								<a href="del?id=<%=e.getId()%>">删除</a>
								<a href="uptPage?id=<%=e.getId()%>">修改</a>
							</td>
						</tr>					
					<% 	
						}
					%>
				</table>
				<p>
					<input type="button" class="button" value="添加员工"
					onclick="location='addPage'"/>
				</p>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">Copy Gavin</div>
		</div>
	</div>
</body>
</html>