package com.cources.finalProject.controller.filters;

import com.cources.finalProject.model.entities.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AuthFilter implements Filter {
    private static Map<String, Role> authPaths = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        authPaths.put("customer", Role.CUSTOMER);
        authPaths.put("master", Role.MASTER);
        authPaths.put("manager", Role.MANAGER);
        authPaths.put("admin", Role.ADMIN);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String reqPath = req.getRequestURI().replace("/app/", "");
        Role sessionRole = (Role)req.getSession().getAttribute("role");
        Optional<Map.Entry<String, Role>> op = authPaths.entrySet().stream()
                .filter(pair -> reqPath.startsWith(pair.getKey())).findAny();
        //System.out.println(op.);

        if (op.isPresent() && sessionRole.compareTo(op.get().getValue()) < 0) {
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        chain.doFilter(request, response);
    }
}
