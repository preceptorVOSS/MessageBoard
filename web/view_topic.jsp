<%@ page import="com.example.messageboard.JspHelper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Topic</title>
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
<div class="messages">
    <table>
        <tr class="titles">
            <td><span><%=title%></span></td>
            <td><form name="addMessage" method="get" action="add_message.jsp">
                <%=JspHelper.generateHiddenForm(title)%>
                <input type="submit" value="Add Message">
            </form></td>
        </tr>
        <!-- Generate more rows -->
        <%=JspHelper.generateTopicRows(title)%>
    </table>
</div>

</body>
</html>
