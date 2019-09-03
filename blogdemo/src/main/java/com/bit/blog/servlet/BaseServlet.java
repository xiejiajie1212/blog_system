package com.bit.blog.servlet;

import com.bit.blog.entity.Json;
import com.bit.blog.exception.ParameterException;
import com.bit.blog.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        Json result = new Json();
        try {
            Object data = process(req, resp);
            result.setSuccess(true);
            result.setCode("200");
            result.setMessage("操作成功");
            result.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof ParameterException) {
                result.setCode(((ParameterException) e).getCode());
                result.setMessage(((ParameterException) e).getMessage());

            }else if(e instanceof ParameterException){
                result.setCode(((ParameterException)e).getCode());
                result.setMessage(((ParameterException)e).getMessage());
            }
            else {
                result.setCode("500");
                result.setMessage("服务器错误");
            }
        }

            resp.getWriter().write(JsonUtil.format(result));
        }
        public abstract Object process (HttpServletRequest req, HttpServletResponse resp) throws Exception;
    }


