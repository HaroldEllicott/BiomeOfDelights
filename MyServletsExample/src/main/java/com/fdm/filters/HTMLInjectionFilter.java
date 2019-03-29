package com.fdm.filters;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HTMLInjectionFilter implements Filter{

	private final HashSet<String> bannedIps = new HashSet<>();
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		String username = req.getParameter("username");
		
		String ipAddress = req.getRemoteAddr();
		if(username.contains("<") || bannedIps.contains(ipAddress)) {
			bannedIps.add(ipAddress);
			HttpServletResponse response = (HttpServletResponse) res;
			response.sendRedirect("/blocked");
		} else {
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Filter init");
	}

}
