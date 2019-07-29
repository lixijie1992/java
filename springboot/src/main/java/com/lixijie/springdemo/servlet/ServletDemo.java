package com.lixijie.springdemo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet
 * <servlet>
 *     <servlet-name>myswervlet</servlet-name>
 *     <servlet-class>com.lixijie.springdemo.servlet.ServletDemo</servlet-class>
 * </servlet>
 *
 * <servlet-mapping>
 *     <servlet-name>myswervlet</servlet-name>
 *     <url-patterns>/demo</url-patterns>
 * </servlet-mapping>
 * @author lixijie
 */
@WebServlet(name = "servlet" ,urlPatterns = "/demo")
public class ServletDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("78787777777777777777777");
    }

}
