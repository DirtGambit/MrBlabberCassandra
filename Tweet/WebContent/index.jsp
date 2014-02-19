<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mr Blabby</title>
<LINK href="Style.css" rel="stylesheet" type="text/css">

</head>
<body>
<div id="MainDiv" style="text-align:center; width:800px; background-color:lightcyan;margin-left:100px;margin-right:100px">
        <div id="TitleDiv" style="text-align:center; background-color:gray;margin-left:50px;margin-right:50px;">
            <img src="images/logo.png" alt="MrBlabby" height="100" width="600"> 
        </div>
        <div style="background-color:firebrick;margin-left:20px;margin-right:20px;margin-top:20px;">
			<form action="Login" method="post" name="LogInNow">
			<table align="Center">
				<% /* Display welcome message to user */
		String message = (String)request.getAttribute("warningMessage");
		if(message != null)
		if(message.equals("null"))
		{
			//do nothing
		}else{ //do only if there is a content
			%>
			<tr>
			<td align="center" colspan="2"><FONT COLOR="FF0000"><%=request.getAttribute("warningMessage")%></FONT></td>
			<%
		}
		%>
		</tr>
				<tr>
					<td>Username</td><td><input name="USERNAMEBOX" type="text" /></td>
				</tr>
				<tr>
					<td>Password</td><td><input name="PASSWORDBOX" type="text"/></td>
				</tr>
				<tr>
					<td align="right" colspan="2"><a href="register.jsp">Register</a><input type="submit" name="LOGINBUTTON" value="LOGIN" /></td>
				</tr>
			</table>
			</form>
			
			
        </div>
       
</div>
</body>
</html>

<%-- <asp:Table runat="server" HorizontalAlign="Center">
            <asp:TableRow>
                <asp:TableCell ColumnSpan="2" HorizontalAlign="Center">Mr Blabby</asp:TableCell>
            </asp:TableRow>
            <asp:TableRow>
                <asp:TableCell Width="300px">Welcome to Mr Blabby</asp:TableCell>
                 <asp:TableCell>4</asp:TableCell>
                <asp:TableCell>5</asp:TableCell>
            </asp:TableRow>
        </asp:Table>--%>