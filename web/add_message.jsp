<%@ page import="com.example.messageboard.JspHelper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Topic</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
<%
    String title = request.getParameter("title");
%>
<div class="top">
    <ul>
        <li><a href="index.jsp">Home</a></li>
    </ul>
</div>
<div class="form">
    <form action="/messageservlet" method="post">
        <h3>Add message for <%=title%></h3>
        <p>User Name:</p>
        <input type="text" name="userName" maxLength="20"><br>
        <p>Message:</p>
        <input type="text" name="text" size="100"><br>
        <%=JspHelper.generateHiddenForm(title)%>
        <input type="submit" name="Submit">
    </form>
</div>

</body>
</html>
