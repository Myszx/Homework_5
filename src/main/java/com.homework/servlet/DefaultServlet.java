package com.homework.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Enumeration;

@WebServlet("/infoShareAcademy")
public class DefaultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime actualTime = LocalDateTime.now();
        resp.getWriter().println("<center> Maciej Myszkowski</br>");
        resp.getWriter().println("jjdd6-wilki</br>");
        resp.getWriter().println(actualTime + "</center>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Enumeration<String> paramNames = req.getParameterNames();
       resp.getWriter().println("<center>");
       while(paramNames.hasMoreElements()){
           String paramName = paramNames.nextElement();
           resp.getWriter().println(paramName + "=");
           String[] paramValues = req.getParameterValues(paramName);
           for (String s: paramValues) {
               resp.getWriter().println("{" + s + "}");
           }
           resp.getWriter().println("</br>");
       }
       resp.getWriter().println("</center>");
    }
}
