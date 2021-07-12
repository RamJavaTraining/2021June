package com.june.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.june.servlets.modal.User;
import com.june.servlets.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		//String fName= request.getParameter("firstName");
		//String lName= request.getParameter("lastName");
		

		int userId= Integer.parseInt(request.getParameter("userID"));
		ServletContext context= request.getServletContext();
		
		HttpSession session= request.getSession();
	/*	if(fName!=null && lName!=null) {
		session.setAttribute("fName", fName);
		session.setAttribute("lName", lName);
		context.setAttribute("fName", fName);
		context.setAttribute("lName", lName);
		}
		
		
		
		
		PrintWriter writer=  response.getWriter();
		writer.println("<html><body><h1>");
		writer.println("Hello From Session"+session.getAttribute("fName")+" "+session.getAttribute("lName") +"<br>");
		writer.println("Hello From Context"+context.getAttribute("fName")+" "+context.getAttribute("lName") +"<br>");

		writer.println("Hello "+fName+" "+lName +"</h1><body/></html>");
		
		*/
		UserService userService= new UserService();
		
		 boolean isUserExists = userService.isUserExists(userId);
		 
		 if(isUserExists) {
			 
			 User user = userService.getUser(userId);
			 request.setAttribute("user", user);
			 session.setAttribute("user", user);
			 context.setAttribute("user", user);
			 
			 request.getRequestDispatcher("Success.jsp").forward(request, response);
			 
		 }
		 else {
			 
			 response.sendRedirect("Login.html");
		 }
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String fName= request.getParameter("firstName");
		String lName= request.getParameter("lastName");
		PrintWriter writer=  response.getWriter();
		writer.println("<html><body>From Post<h1>");
		writer.println("Hello "+fName+" "+lName +"</h1><body/></html>");
		
	}

}
