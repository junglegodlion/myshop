package com.bjsxt.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static{
		//创建properties对象获取属性文件的内容
		Properties p=new Properties();
		//获取属性文件的读取流对象
		InputStream is=JdbcUtil.class.getResourceAsStream("/db.properties");
		try {
			//加载属性配置文件
			p.load(is);
			//获取jdbc参数
			driver=p.getProperty("driver");
			url=p.getProperty("url");
			username=p.getProperty("username");
			password=p.getProperty("password");
			//加载驱动
			Class.forName(driver);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取Connection对象
	public static Connection getConnection(){
		Connection conn=null;
		try {
			 conn=DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	//封装获取PreparedStatement对象
	public static PreparedStatement getPreparedStatement(String sql,Connection conn){
		
		PreparedStatement ps=null;
		try {
			ps =conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
		
	}
	
	//封装获取Statement对象
	public static Statement getStatement(Connection conn){
		Statement stmt=null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
		
	}
	
	//关闭资源
	public static void closeAll(ResultSet rs,Statement stmt,Connection conn){
		try {
			rs.close();
		} catch (Exception e) {
			
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			
		}
		try {
			conn.close();
		} catch (SQLException e) {
			
		}
	}
	
	//封装DML
	public static int executeDML(String sql,Object...objs){
		//创建连接对象
		Connection conn=getConnection();
		//创建sql命令对象
		PreparedStatement ps=JdbcUtil.getPreparedStatement(sql, conn);
		//给占位符赋值
			try {
				conn.setAutoCommit(false);
				for(int i=0;i<objs.length;i++){
					ps.setObject(i+1, objs[i]);
				}
				int i=ps.executeUpdate();
				conn.commit();
				return i;
			} catch (Exception e) {
					try {
						conn.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}finally{
				//关闭资源
				JdbcUtil.closeAll(null, ps, conn);
			}
			//返回结果
			return -1;
	}
}
