package com.mike.servlets;

import java.io.IOException;
import java.util.LinkedList;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.datastax.driver.core.Cluster;


//import uk.ac.dundee.computing.aec.lib.*;
//import uk.ac.dundee.computing.aec.models.*;
//import uk.ac.dundee.computing.aec.stores.*;

import com.mike.lib.*;
import com.mike.models.*;
import com.mike.stores.*;

/**
 * Servlet implementation class LoginRegister
 */
@WebServlet({ "/LoginRegister", "/LoginRegister/*" })
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Cluster cluster;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginRegister() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		cluster = CassandraHosts.getCluster();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberModel member = new MemberModel();
		String warningMessage = ""; 
		member.setCluster(cluster);
		boolean success = false;
		if(request.getParameter("EMAILBOX").length() > 5)
		{			
			success = member.AddUser(request.getParameter("NAMEBOX"), request.getParameter("SNAMEBOX"), request.getParameter("HANDLEBOX"), request.getParameter("EMAILBOX"), request.getParameter("PASSWORDBOX"));
			if(success == true)
			{
				warningMessage = "New User Created, Now Login!";
				request.setAttribute("warningMessage", warningMessage);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp"); 
				rd.forward(request, response);
			}
		}
		else
		{
			warningMessage = "Check your DOX";
			request.setAttribute("warningMessage", warningMessage);
			RequestDispatcher rd = request.getRequestDispatcher("/register.jsp"); 
			rd.forward(request, response);
		}
		

		
	}

}
