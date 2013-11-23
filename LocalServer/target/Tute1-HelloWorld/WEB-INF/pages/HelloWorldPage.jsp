<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*, java.io.*, org.apache.commons.io.IOUtils" %>
<html>
<head>
<title>HTTP TEST APP - POST Request</title>
</head>
<body>
<br>Server name: <%= request.getServerName() %>
<br>Server port: <%= request.getServerPort() %>
<br>Request URI: <%= request.getRequestURI() %>
<%
  Enumeration<String> parameterList = request.getParameterNames();

  if (parameterList.hasMoreElements()) {
%>
<br><br><b>Request Parameters</b>
<%
	while( parameterList.hasMoreElements()) {
    String paramName = parameterList.nextElement().toString();

%>  <br><%=paramName%> : <%=request.getParameter(paramName)%>
<%
    }//end while

  }//end if



  InputStream input = request.getInputStream();
  String requestBody = IOUtils.toString(input);

  if (requestBody != null && requestBody.trim().length() > 0) {
%>
<br><br><b>Request Body</b>

<%=requestBody%>
<%
  }//end if
%>
<br><br><b>Request Headers</b>
<%
  Enumeration<String> headerList = request.getHeaderNames();
  while(headerList.hasMoreElements()) {
    String headerName = headerList.nextElement().toString();
%>    <br><%=headerName%> : <%=request.getHeader(headerName)%>
<%
  }//end while
%>
</body>
</html>
