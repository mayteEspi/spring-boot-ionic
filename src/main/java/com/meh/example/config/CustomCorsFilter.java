package com.meh.example.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class CustomCorsFilter extends GenericFilterBean  {
    
	
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	HttpServletResponse res = (HttpServletResponse) response;
    	HttpServletRequest req = (HttpServletRequest) request;
          res.setHeader("Access-Control-Allow-Origin", "*");
          res.setHeader("Access-Control-Allow-Methods", "*");
          res.setHeader("Access-Control-Max-Age", "3600");
          res.setHeader("Access-Control-Allow-Headers", "*");
          if (req.getMethod()!="OPTIONS") {
              chain.doFilter(req, res);
          }
    }
    
    @Override
    public void destroy() {
    }

	
}