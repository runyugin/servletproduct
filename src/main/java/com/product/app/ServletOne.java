package com.product.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletOne", urlPatterns = "/pr")
public class ServletOne extends HttpServlet {

    protected static Logger logger = LoggerFactory.getLogger(ServletOne.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().printf("<html><body>");

        for (int i = 0; i < 10; i++) {
            resp.getWriter().printf((new Product(i, "name-" + i, 100+i)).toString());
        }

        resp.getWriter().printf("</html></body>");
    }

    ServletConfig config=null;

    public void init(ServletConfig config){
        this.config=config;
        System.out.println("servlet is initialized");
    }
}
