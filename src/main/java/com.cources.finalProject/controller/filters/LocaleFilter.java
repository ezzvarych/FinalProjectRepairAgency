package com.cources.finalProject.controller.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LocaleFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        if (request.getParameter("locale") != null) {
            httpServletRequest.getSession().setAttribute("lang",
                    request.getParameter("locale"));
        }
        chain.doFilter(request, response);
    }
}
