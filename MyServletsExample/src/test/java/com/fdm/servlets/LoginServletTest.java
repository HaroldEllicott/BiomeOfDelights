lpackage com.fdm.servlets;

import org.junit.Test;

import com.fdm.servlets.LoginServlet;

import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServletTest {

	@Test
	public void loads_login_page_on_get_request() throws ServletException, IOException {
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse res = mock(HttpServletResponse.class);
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		when(req.getRequestDispatcher("login.jsp")).thenReturn(dispatcher);
		
		LoginServlet servlet = new LoginServlet();
		
		servlet.doGet(req, res);
		
		verify(dispatcher).forward(req, res);
	}
	
	@Test
	public void loads_home_page_after_login() throws ServletException, IOException {
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse res = mock(HttpServletResponse.class);
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		when(req.getRequestDispatcher("home.jsp")).thenReturn(dispatcher);
		when(req.getParameter("username")).thenReturn("harry");
		when(req.getParameter("password")).thenReturn("pass");
		LoginServlet servlet = new LoginServlet();
		
		servlet.doPost(req, res);
		
		verify(dispatcher).forward(req, res);
		verify(req).setAttribute("user", "harry");
	}
}
