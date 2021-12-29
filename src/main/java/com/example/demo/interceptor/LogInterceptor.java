package com.example.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Component
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        long executionStartTime = System.currentTimeMillis();
        request.setAttribute("start-time", executionStartTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) {
        long executionStartTime = (Long)request.getAttribute("start-time");
        long renderingStartTime = System.currentTimeMillis();
        request.setAttribute("rendering-start-time", renderingStartTime);
        long executionDuration = renderingStartTime - executionStartTime;
        String user = "myuser"; /* GET USER INFORMATION FROM SESSION */
        System.out.println("User : "+user+ " took total time of : "+ TimeUnit.MILLISECONDS.toSeconds(executionDuration)+
                "(s) to execute the action -> "+request.getServletPath());
    }


}
