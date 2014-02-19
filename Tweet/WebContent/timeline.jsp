<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@ page import="com.mike.stores.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<LINK href="Style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="MainDiv" style="text-align:center; width:800px; background-color:lightcyan;margin-left:100px;margin-right:100px">
        <div id="TitleDiv" style="text-align:center; background-color:gray;margin-left:50px;margin-right:50px;">
            <img src="images/logo.png" alt="MrBlabby" height="100" width="600"> 
        </div>
        <div style="background-color:firebrick;margin-left:20px;margin-right:20px;margin-top:20px;">
		
			<table align="Center">
			<% /* Display welcome message to user */
		String message = (String)request.getAttribute("LoginMessage");
		if(message != null)
		if(message.equals("null"))
		{
			//do nothing
		}else{ //do only if there is a content
			%>
			<tr>
			<td align="center"><FONT COLOR="FF05600"><%=message%></FONT></td>
			<%
		}
		%>
		</tr>

			</table>
		
        </div>
       
</div>
</body>
</html>