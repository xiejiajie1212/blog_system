package com.bit.blog.servlet;


import com.bit.blog.util.MyActionEnter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ueditor")
public class UeditorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path=    UeditorServlet.class.getClassLoader()
                .getResource("config.json").getPath();
        MyActionEnter myActionEnter=new MyActionEnter(req,path);
        String exec=    myActionEnter.exec();
        resp.getWriter().write(exec);
    }
}
