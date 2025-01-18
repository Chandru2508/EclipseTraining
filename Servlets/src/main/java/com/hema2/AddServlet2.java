package com.hema2;

import java.io.IOException;
import java.io.PrintWriter;
// Imports necessary classes for handling I/O exceptions and writing output.

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
// Imports the HttpServlet class from the Jakarta Servlet API.

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
// Imports the HttpServletRequest and HttpServletResponse classes from the Jakarta Servlet API.

@WebServlet("/add")
public class AddServlet2 extends HttpServlet {
	// Defines the AddServlet class, which extends HttpServlet to handle HTTP
	// requests.

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// Overrides the service method to handle HTTP requests and responses.

		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		// Retrieves the parameters "num1" and "num2" from the request and converts them
		// to integers.

		int k = i + j;

//Method 3 Cookies
		
		// Create a new cookie with the name "k" and the value of `k` converted to a String.
		Cookie cookie = new Cookie("k", k + "");

		// Add the cookie to the HTTP response, sending it to the client.
		res.addCookie(cookie);

		// Redirect the response to the "sq" servlet or page.
		res.sendRedirect("sq");

		
//   ============================================================================
//		Method 2 Session:		
		
//		HttpSession session = req.getSession();
//		session.setAttribute("k", k);
//		res.sendRedirect("sq");
		
//  By creating a session for the value , it is available for every sessions or servlets of another webpage of the the application 
		// one method of passing value
		
//   ================================================================================================================
//Method 1 URL Redirecting:
		// ---> using send redirect method of response to call other servlet from
		// servlet and says redirecting to other servlet

//      res.sendRedirect("sq?k=" + k); // URL ReWritting to pass value 

//   ================================================================================================================   

		System.out.println("Result is " + k);
		// Prints the result to the console.

		PrintWriter out = res.getWriter();
		// Obtains a PrintWriter object to send character text to the client.

		out.println("Result is " + k);
		// Writes the result to the HTTP response.
	}
}