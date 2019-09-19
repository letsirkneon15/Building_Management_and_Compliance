package com.bmc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.bmc.model.BuildingHeaderMgr;
import com.bmc.pojo.BuildingHeader;

/**
 * Servlet implementation class BuildingController
 */
@WebServlet("/BuildingController")
public class BuildingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Context initContext;
	private Context envContext;
	private DataSource dataSource;
	private Connection conn;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		try{
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/Project");
			conn = dataSource.getConnection();
			System.out.println("Connection: " + conn);
		}catch (NamingException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding( "UTF-8" );
		String newPage = "/MainPage.jsp";
		int buildingID = 0;
		String buildingName = "";
		
		/* Retrieve session values from BuildingHeader */
		HttpSession session=request.getSession();
		
		ArrayList<BuildingHeader> bHeaderArr = new ArrayList<>();
		bHeaderArr = new BuildingHeaderMgr().getBuildingHeader(conn, buildingID, buildingName);
		
		session.setAttribute("bHeaderArr", bHeaderArr);
		
		/* do redirection */ 
		ServletContext sContext = getServletContext();
		RequestDispatcher rDispatcher = sContext.getRequestDispatcher(newPage);
		rDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding( "UTF-8" ); 
		doGet(request, response);
	}

}
