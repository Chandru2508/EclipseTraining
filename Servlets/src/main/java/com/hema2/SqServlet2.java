package com.hema2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SqServlet2 extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
//Method 3 Cookies
		
		// Retrieve all cookies from the HTTP request and store them in an array.
		Cookie cookies[] = req.getCookies();

		// Initialize a variable `k` to store the value of the cookie named "k".
		int k = 0;

		// Iterate through the array of cookies to find the one with the name "k".
		for (Cookie c : cookies) {
		    // Check if the current cookie's name is "k".
		    if (c.getName().equals("k")) {
		        // Parse the value of the cookie (which is a String) into an integer and assign it to `k`.
		        k = Integer.parseInt(c.getValue());
		    }
		}


//	===========================================================	
//	Method 2 Session
		
//		HttpSession session = req.getSession();
//		int k =(int) session.getAttribute("k");
//	===========================================================	
		
//	===========================================================	
// Method 1 URL Redirecting
		// Retrieve the "k" attribute from the request object and cast it to an integer.
		// Ensures the value stored in the request scope is accessed as an int for further processing.
		
//		int k = Integer.parseInt(req.getParameter("k"));
		
		//getting value of previous servlet from url
//	===========================================================	

		k = k*k;
		
		PrintWriter out = res.getWriter();
		out.println("Square of k is " + k);
		
		ServletContext cont = getServletContext();
		String context = cont.getInitParameter("name");
		
		ServletConfig conf = getServletConfig();
		String config = conf.getInitParameter("name");
		
		out.println("Hi " + config + context);
	}
}