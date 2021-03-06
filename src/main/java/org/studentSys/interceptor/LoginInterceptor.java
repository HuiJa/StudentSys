package org.studentSys.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by HuiJa on 2018/5/17.
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    //server.servlet.context-path=/StudentSys
    static final String context_path="/StudentSys";
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("student") == null
                && session.getAttribute("teacher") == null
                && session.getAttribute("parent") == null) {
            httpServletResponse.sendRedirect(context_path+"/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
