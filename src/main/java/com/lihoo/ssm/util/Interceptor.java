package com.lihoo.ssm.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * #Title: Interceptor
 * #ProjectName task5_index1
 * #Description: 自定义公共拦截器
 * #author lihoo
 * #date 2018/9/5-20:36
 */

@Component
public class Interceptor extends HandlerInterceptorAdapter {
    private static Logger logger = LogManager.getLogger(Interceptor.class);

    /**
     * 在请求之前拦截，返回true则进入请求Controller
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        logger.info("=============执行顺序: 1、preHandle=============");
        String requestUri = request.getRequestURI();
        String method = request.getMethod();
        String url = request.getContextPath();
        logger.info("requestUri : " + requestUri);
        logger.info("method : " + method);
        logger.info("url : " + url);
//       String username =  (String)request.getSession().getAttribute("user");
//        if(username == null) {
//            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
//            return false;
//        } else {
//            return true;
//        }
        return true;
    }

    /**
     * 在业务处理器处理请求执行完成后，在返回试图前拦截，
     * 可在modelAndView中加入数据，比如当前时间
     * @param response
     * @param request
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("==============执行顺序: 2、postHandle================");
        if (modelAndView != null) {
            modelAndView.addObject("serverTime", DateUtils.getCurrentDateTime());
        }
    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     * @param request
     * @param response
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        logger.info("==============执行顺序: 3、afterCompletion================");
    }


}
