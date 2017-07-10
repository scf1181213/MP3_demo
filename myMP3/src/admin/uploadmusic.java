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

/**
 * Servlet implementation class uploadmusic
 */
@WebServlet("/uploadmusic")
public class uploadmusic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadmusic() {
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
		request.setCharacterEncoding("utf-8");
		String musicname=request.getParameter("musicname");
		String singer=request.getParameter("singer");
		String id=request.getParameter("id");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control",
				"no-cache");
		response.setDateHeader("Expires", 0);
		if (function.isInvalid(musicname) || function.isInvalid(singer)||function.isInvalid(id)) {
			out.println(function.PlutoJump("不要输入空值", "index.jsp"));
		} 
			dbconnection conn = new dbconnection();
			ResultSet rs = conn.executeQuery("select * from my_music where id = '"+id+"'");
			try {
				if (rs.next()) {
					out.println(function.PlutoJump("歌曲已存在！", "index.jsp"));
				} else {
					boolean insert = conn.execute("insert into my_music(song,singer,id,clicks) values('"+musicname+"','"+singer+"','"+id+"',0)");
					if(insert){
						out.println(function.PlutoJump("上传歌曲信息成功！"+musicname, "index.jsp"));
					}else{
						out.println(function.PlutoJump("上传失败！", "index.jsp"));
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
