package com.seventh.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class UEditorFilter extends StrutsPrepareAndExecuteFilter{
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {    
        HttpServletRequest request = (HttpServletRequest) req;    
        String url = request.getRequestURI();    
        System.out.println(url);
        try{    
            if (url.contains("controller.jsp")) {    
                chain.doFilter(req, res);    
            } else {    
                super.doFilter(req, res, chain);    
            }    
        }catch(Exception e){    
            e.printStackTrace();    
        }    
    }  
}
