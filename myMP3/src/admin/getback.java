package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class getback
 */
@WebServlet("/getback")
public class getback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getback() {
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
		String a = request.getParameter("s1");
		String b = request.getParameter("s2");
		String username=request.getParameter("username");
		String mailurl = null;
		String yanzheng=request.getParameter("mail");
		//页面输出配置
		   response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control","no-cache");
			response.setDateHeader("Expires", 0);
		session.setAttribute("username", username);
		a=a+"check";
		b=b+"check";
		System.out.print(a);
		System.out.print(b);
		if(!a.equals(null)&&b.equals("nullcheck")){
			//生成随机验证码
			System.out.print(a);
			Random random=new Random();
			session.setAttribute("flag", "2");
			char[] codeSequence ={'0','1', '2', '3', '4', '5', '6', '7', '8', '9' };
			StringBuffer randomCode = new StringBuffer();
			for (int i = 0; i < 4; i++) {
				String strRand = String.valueOf(codeSequence[random.nextInt(10)]); 
				randomCode.append(strRand); 
				} 
			session.setAttribute("randomcode", randomCode.toString()); 
			System.out.print(randomCode.toString());
			
			dbconnection conn = new dbconnection();
			
			
			try {
				ResultSet rs = conn.executeQuery("select mail from user_data where username = '"+username+ "'");
				if(rs.next()){
				mailurl=rs.getString("mail");
				}
				
				String from = "2985574992@qq.com";
				String host = "smtp.qq.com";
				String port="587";
				Properties properties = System.getProperties();
				properties.setProperty("mail.smtp.host", host);
				properties.setProperty("mail.smtp.port",port);
				properties.put("mail.user", "2985574992@qq.com");
				properties.put("mail.password", "kaqygoemlfundebf");
				properties.setProperty("mail.smtp.auth", "true");
				 Authenticator authenticator = new Authenticator() {

			            protected PasswordAuthentication getPasswordAuthentication() {
			                // 用户名、密码
			                String userName = properties.getProperty("mail.user");
			                String password = properties.getProperty("mail.password");
			                return new PasswordAuthentication(userName, password);
			            }
			        };
				Session session2 = Session.getInstance(properties,authenticator);
				try{
				MimeMessage message = new MimeMessage(session2);
		         //
		         message.setFrom(new InternetAddress(from));
		         
		         message.addRecipient(Message.RecipientType.TO,new InternetAddress(mailurl));
		         message.setSubject("这是验证信息!");
		         // 现在设置实际消息
		         message.setText(randomCode.toString());
		         
		         
		         // 发送消息
		         Transport.send(message);

		         
		         //request.getRequestDispatcher("getback.jsp");
		         out.println("<script>alert('验证码已发送');window.history.back()</script>");
				}catch (MessagingException mex) {
			         mex.printStackTrace();
			      }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		else{

			String code=(String)session.getAttribute("randomcode");		
			if(yanzheng.equals(code)){
				dbconnection conn = new dbconnection();
				System.out.print(code);
				ResultSet rs = conn.executeQuery("select password from user_data where username = '"+session.getAttribute("username").toString()+ "'");
				try {
					if(rs.next()){
					out.println(function.PlutoJump("你的密码是:"+rs.getString("password"), "getback.jsp"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}

}
