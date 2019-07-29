package com.lixijie.springdemo.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * <filter>
 * <filter-name></filter-name>
 * <filter-class></filter-class>
 * </filter>
 * <p>
 * <filter-mapping>
 * <filter-name></filter-name>
 * <url-pattern></url-pattern>
 * </filter-mapping>
 * @WebFilter(filterName ="firstFilter",urlPatterns = {"*.do","*.jsp"})
 *
 * @author lixijie
 */
@WebFilter(filterName = "firstFilter", urlPatterns = "/getMap")
public class FirstFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入Filter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("离开Filter");
    }

    @Override
    public void destroy() {

    }
}
