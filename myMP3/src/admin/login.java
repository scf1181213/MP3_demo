package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import admin.dbconnection;
import admin.function;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   String username=request.getParameter("username");
	   String password=request.getParameter("password");
	   response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control",
				"no-cache");
		response.setDateHeader("Expires", 0);
		if (function.isInvalid(username) || function.isInvalid(password)) {
			out.println(function.PlutoJump("�û��������벻��Ϊ��", "index.jsp"));
		} else {
			session.setAttribute("PlutoUser", username);
			
			dbconnection conn = new dbconnection();
			ResultSet rs = conn.executeQuery("select * from user_data where username = '"+ session.getAttribute("PlutoUser").toString()+ "' and password = '" + password + "'");
			try {
				if (rs.next()) {
					out
							.println("<script language='javascript'>location.href='index.jsp';</script>");
				} else {
					session.removeAttribute("PlutoUser");
					out.println(function.PlutoJump("�û����������", "index.jsp"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
}
}
