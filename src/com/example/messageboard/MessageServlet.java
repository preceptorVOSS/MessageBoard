package com.example.messageboard;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MessageServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String title = request.getParameter("title");
        String text = request.getParameter("text");
        DatabaseHelper.addMessage(title, userName, text);

        response.sendRedirect("index.jsp");
    }

}
