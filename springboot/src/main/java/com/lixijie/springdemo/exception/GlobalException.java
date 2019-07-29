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
 * ������Ҫ����һ��ModelAndView  ���Է�װ�쳣��Ϣ�Լ�ָ����ͼ
 *
 * @param e   ���쳣ע�뵽������
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
 * ������
 * ͨ�� SimpleMappingExceptionResolver �쳣ȫ�ִ���
 * �޷������쳣����
 */
/*@Configuration
public class GlobalException {

    public SimpleMappingExceptionResolver arExceptionHandle(){
        SimpleMappingExceptionResolver sme = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        *//*����һ  �쳣������ �쳣���͵�ȫ��
          ������   ��ͼ����
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
        //�жϲ�ͬ�쳣���ͣ�����ͬ��ͼ��ת
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