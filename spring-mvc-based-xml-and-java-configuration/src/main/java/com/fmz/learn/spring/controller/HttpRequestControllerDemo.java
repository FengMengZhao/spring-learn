package com.fmz.learn.spring.controller;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpRequestControllerDemo implements HttpRequestHandler{

    @Override
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        httpServletRequest.setAttribute("user", "HttpRequestControllerDemo");
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/welcomePage2.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
