package com.dayton.doji.practice.designpattern.delegate.v2;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Martin Deng
 * @since 2020-08-19 22:25
 */
public class DispatcherServlet extends HttpServlet{

	private void doDispatch(HttpServletRequest request, HttpServletResponse
			response) throws IOException {
		String uri = request.getRequestURI();
		String mid = request.getParameter("mid");
		if ("getMemberById".equals(uri)){
			new MemberController().getMemberById(mid);
		}else if ("getOrderById".equals(uri)){
			new OrderController().getOrderById(mid);
		}else if ("logout".equals(uri)){
			new SystemController().logout();
		}else {
			response.getWriter().write("404 Not Found!!!");
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			doDispatch(req, resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
