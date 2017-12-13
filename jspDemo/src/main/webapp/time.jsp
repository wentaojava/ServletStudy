<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<% Date date=new Date();
   SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
   String time=sdf.format(date);
%>
  <p>
    <%=time %>
  </p>
</body>
</html>