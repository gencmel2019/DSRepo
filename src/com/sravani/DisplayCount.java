package com.sravani;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayCountServlet")
public class DisplayCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String count = context.getAttribute("count").toString();
		out.print("<html><head>");
		out.print("<title> Display Count </title>");
		out.print("</head> <body>");
		out.print(" The site was visited " + count + "times");
		out.print("</body></html>");
		context.removeAttribute("count");
	}
}
