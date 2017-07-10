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

import admin.function;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
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
		String password2=request.getParameter("password2");
		String mail=request.getParameter("mail");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control",
				"no-cache");
		response.setDateHeader("Expires", 0);
		if (function.isInvalid(username) || function.isInvalid(password)||function.isInvalid(password2)) {
			out.println(function.PlutoJump("用户名或密码不能为空", "index.jsp"));
		} 
		if(!password.equals(password2)){
			out.println(function.PlutoJump("两次输入的密码不一致！", "index.jsp"));
		}
			dbconnection conn = new dbconnection();
			ResultSet rs = conn.executeQuery("select * from user_data where username = '"+username+"'");
			try {
				if (rs.next()) {
					out.println(function.PlutoJump("用户名已存在！", "index.jsp"));
				} else {
					boolean insert = conn.execute("insert into user_data(username,password,mail) values('"+username+"','"+password+"','"+mail+"')");
					if(insert){
						out.println(function.PlutoJump("注册成功，请登陆！", "index.jsp"));
					}else{
						out.println(function.PlutoJump("注册失败！", "index.jsp"));
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	
	}

}
