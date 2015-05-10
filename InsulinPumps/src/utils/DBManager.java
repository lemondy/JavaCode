package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	private static final String DRIVER = "org.gjt.mm.mysql.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/mydb";
	private static final String USER = "root";
	private static final String PASS = "admin";
	private static Connection con = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	
	public static  Connection getConnection(){
		try{
			Class.forName(DRIVER);
			con =  DriverManager.getConnection(DBURL, USER, PASS);
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	
	public ResultSet queryInsulin(String sql){
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public void close(){
		try{
			if(rs != null){
				rs.close();
				rs = null;
			}
			if(pstmt != null){
				pstmt.close();
				pstmt = null;
			}
			if(con != null){
				con.close();
				con = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
