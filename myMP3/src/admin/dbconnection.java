package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbconnection {
	static private String strDriver = "com.mysql.jdbc.Driver";

	static private String strUrl = "jdbc:mysql://localhost:3306/mp3_demo";

	static private String strUser = "root";

	static private String strPwd = "baobei1181213";
	
	private Connection conn = null;

	private Statement stmt = null;

	private PreparedStatement pstmt = null;

	private ResultSet rs = null;

	static {
		try {
			Class.forName(strDriver);
		} catch (ClassNotFoundException ex) {
			System.out.println("Error load" + strDriver);
		}
	}

	public dbconnection() {
	}

	private Connection getConnection() {
		try {
			if (conn == null || conn.isClosed())
				conn = DriverManager.getConnection(strUrl, strUser, strPwd);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return conn;
	}


	public void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (Exception ex) {
			System.err.println("close error:" + ex.getMessage());
		}
	}


	public ResultSet executeQuery(String sql) {
		try {
			pstmt = getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException ex) {
			System.err.println("query error:" + ex.getMessage());
		}
		return rs;
	}


	public boolean execute(String sql) {
		try {
			pstmt = getConnection().prepareStatement(sql);
			if (pstmt.execute()) {
				return true;
			}
		} catch (SQLException ex) {
			System.err.println("query error:" + ex.getMessage());
			return false;
		}
		return true;
	}


	public int executeUpdate(String sql) {
		int resultNum = 0;
		try {
			pstmt = getConnection().prepareStatement(sql);
			resultNum = pstmt.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("update error:" + ex.getMessage());
		} finally {
		}
		return resultNum;
	}
}
