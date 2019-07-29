package com.lixijie.springdemo.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/*@ControllerAdvice
public class GlobalException {
    *//**
 * 方法需要返回一个ModelAndView  可以封装异常信息以及指定视图
 *
 * @param e   将异常注入到方法中
 * @return
 *//*
    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView arExceptionHandle(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("error",e.toString());
        mv.setViewName("error1");
        return mv;
    }

    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView arExceptionHandles(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("error",e.toString());
        mv.setViewName("error1");
        return mv;
    }
}*/

/**
 * 配置类
 * 通过 SimpleMappingExceptionResolver 异常全局处理
 * 无法传递异常对象
 */
/*@Configuration
public class GlobalException {

    public SimpleMappingExceptionResolver arExceptionHandle(){
        SimpleMappingExceptionResolver sme = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        *//*参数一  异常的类型 异常类型的全名
          参数二   视图名称
        * *//*
        mappings.put("java.lang.ArithmeticException","error");
        mappings.put("java.lang.NullPointerException","error1");
        return sme;
    }*/

@Configuration
public class GlobalException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView mv = new ModelAndView();
        //判断不同异常类型，做不同视图跳转
        if(ex instanceof NullPointerException){
            mv.setViewName("error");
        }

        if(ex instanceof ArithmeticException){
            mv.setViewName("error1");
        }
        mv.addObject("error",ex.toString());
        return mv;
    }
}