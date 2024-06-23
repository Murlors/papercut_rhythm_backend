package com.example.papercut_rhythm_backend.interceptor;

import com.example.papercut_rhythm_backend.annotation.LoginRequire;
import com.example.papercut_rhythm_backend.bean.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static com.example.papercut_rhythm_backend.bean.CodeEnum.NEED_LOGIN;

public class LoginAuthInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //这里实际是从redis中获取到session信息
        if (hasPermission(handler, request)) {
            return true;
        } else {
            authFailOutput(response, "您未登陆,请先登陆");
            return false;
        }
    }

    /**
     * json输出
     *
     * @param response
     * @throws IOException
     */
    private void authFailOutput(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        out.write(objectMapper.writeValueAsString(R.error(NEED_LOGIN, msg)));
        out.flush();
    }

    public boolean hasPermission(Object handler, HttpServletRequest request) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 获取方法上的注解
            LoginRequire loginRequire = handlerMethod.getMethod().getAnnotation(LoginRequire.class);

            if (loginRequire == null) {
                return true;
            } else {
                HttpSession session = request.getSession();
                String userId = (String) session.getAttribute("userId");
                return userId != null;
            }
        }
        return true;
    }
}