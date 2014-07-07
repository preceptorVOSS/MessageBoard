<%@ page import="com.example.messageboard.DatabaseHelper" %>
<%@ page import="com.example.messageboard.JspHelper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Message Board</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
  </head>
  <body>
    <div class="top">
        <ul>
            <li><a href="index.jsp">Home</a></li>
        </ul>
    </div>
    <div class="board">
        <table>
            <tr class="titles">
                <td colspan="3"><h3>Simple Message Board</h3></td>
                <td colspan="2">
                <form name="addTopic" method="get" action="add_topic.jsp">
                    <input type="submit" value="Add Topic">
                </form>
                </td>
            </tr>
            <tr class="titles">
                <td><span>Title</span></td>
                <td><span>Created By</span></td>
                <td><span>Creation Date</span></td>
                <td colspan="2"><span>Latest Post</span></td>
            </tr>
            <!-- Generate more rows -->
            <%=JspHelper.generateMessageBoardRows()%>
        </table>
    </div>

  </body>
</html>
