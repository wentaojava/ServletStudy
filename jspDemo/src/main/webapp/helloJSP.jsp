<%@page pageEncoding="utf-8"%>   
<!doctype html>
<html>
	<head>
		<meta charaset="utf-8">
		<title>JSPDemo</title>
	</head>
	<body>
	<!--jsp声明  -->
	<%! 
		public double demo(double n){
	       return n*100;
	}
	%>
	<ul>
	<!--演示Jsp脚本  -->
		<% for(int i=0;i<10;i++){
		%>
		<!--jsp表达式  -->
		<li><%=demo(Math.random()) %></li>
		<%
		}
		%>
	</ul>
	<%@include file="time.jsp" %>
	</body>
</html>