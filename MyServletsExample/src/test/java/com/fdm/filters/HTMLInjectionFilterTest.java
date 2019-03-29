package com.fdm.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.IOException;

public class HTMLInjectionFilterTest {

	private HTMLInjectionFilter filter = new HTMLInjectionFilter();
	
	@Test
	public void when_username_has_html_in_it_redirects_request_to_blocked_page() throws IOException, ServletException {
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse res = mock(HttpServletResponse.class);
		FilterChain chain = mock(FilterChain.class);
		when(req.getParameter("username")).thenReturn("<body>");
		
		filter.doFilter(req, res, chain);
		
		verify(res).sendRedirect("/blocked");
	}
	
	@Test
	public void when_username_is_valid_sends_request_to_next_in_chain() throws IOException, ServletException {
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse res = mock(HttpServletResponse.class);
		FilterChain chain = mock(FilterChain.class);
		when(req.getParameter("username")).thenReturn("harold");
		
		filter.doFilter(req, res, chain);
		
		verify(chain).doFilter(req, res);
	}
}
