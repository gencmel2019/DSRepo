package com.sravani;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	private String initCount;

	@Override
	public void init(ServletConfig config) {
		context = config.getServletContext();
		initCount = context.getInitParameter("initialCount");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String countValue = null;

		if (context.getAttribute("count") != null) {
			countValue = context.getAttribute("count").toString();
		} else {
			countValue = initCount;
		}
		int count = Integer.parseInt(countValue);
		count++;
		context.setAttribute("count", count);
	}

}
