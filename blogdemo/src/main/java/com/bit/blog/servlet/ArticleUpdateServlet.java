package com.bit.blog.servlet;

import com.bit.blog.util.DButil;
import com.bit.blog.entity.Article;
import com.bit.blog.entity.Article;
import com.bit.blog.exception.BusinessException;
import com.bit.blog.util.JsonUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Article> articleList = new ArrayList<>();
        //处理前端请求数据
        //application/json数据，需要使用流来获取
//        String userAccount=req.getParameter("userAccount");
//        String title=req.getParameter("title");
//        String content=req.getParameter("content");
        //获取JSON类型的请求数据
        Article article=JsonUtil.get(req,Article.class);

        //处理业务及数据库操作
        try {
            System.out.println(req.getParameter("id"));
            connection = DButil.getConnection();
            String sql = "update article set title=?,content=? where id=?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,article.getTitle());
            preparedStatement.setString(2,article.getContent());
            preparedStatement.setInt(3,article.getId());
            int r=preparedStatement.executeUpdate();
            if (r>0){
                return r;
            }else {
                throw  new BusinessException("没有该用户"+article.getUserId());
            }
        } finally {
           DButil.close(connection,preparedStatement, rs);
        }
    }
}