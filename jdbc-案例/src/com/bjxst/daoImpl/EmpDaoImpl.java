package com.bjxst.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.bjsxt.dao.EmpDao;
import com.bjsxt.pojo.Emp;
import com.bjsxt.util.JdbcUtil;
public class EmpDaoImpl implements EmpDao{
	//查询所有员工信息
	public ArrayList<Emp> selAllEmpInfo(){
		//声明JDBC对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//声明集合对象
		ArrayList<Emp> list=null;
		try {
			//获取连接对象
				conn=JdbcUtil.getConnection();
		 	//创建sql命令
				String sql="select * from emp";
			//创建sql命令对象
				ps=JdbcUtil.getPreparedStatement(sql, conn);
			//执行sql
				rs=ps.executeQuery();
				list=new ArrayList<>();
			//遍历查询结果
			while(rs.next()){
				//创建Emp对象
				Emp p=new Emp();
				p.setEmpno(rs.getInt("empno"));
				p.setEname(rs.getString("ename"));
				p.setJob(rs.getString("job"));
				p.setMgr(rs.getInt("mgr"));
				p.setDate(rs.getDate("hiredate"));
				p.setSal(rs.getDouble("sal"));
				p.setComm(rs.getDouble("comm"));
				p.setDeptno(rs.getInt("deptno"));
				list.add(p);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//关闭资源
			JdbcUtil.closeAll(rs, ps, conn);
		}
		//返回结果	
		return list;
	}
	//根据编号查询员工信息
	public Emp selEmpInfoByEmpno(int empno){
		//声明jdbc变量
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//声明Emp对象
		Emp p=null;
		try {
			//获取连接对象
			conn=JdbcUtil.getConnection();
			//创建sql命令
			String sql="select * from emp where empno=?";
			//获取sql命令对象
			ps=JdbcUtil.getPreparedStatement(sql, conn);
			//给占位符赋值
			ps.setInt(1,empno);
			//执行符sql
			rs=ps.executeQuery();
			//遍历结果
			if(rs.next()){
				p=new Emp();
				p.setEmpno(rs.getInt("empno"));
				p.setEname(rs.getString("ename"));
				p.setJob(rs.getString("job"));
				p.setMgr(rs.getInt("mgr"));
				p.setDate(rs.getDate("hiredate"));
				p.setSal(rs.getDouble("sal"));
				p.setComm(rs.getDouble("comm"));
				p.setDeptno(rs.getInt("deptno"));
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}finally{//关闭资源
			JdbcUtil.closeAll(rs, ps, conn);
		}
		//返回结果
		return p;
	}
	//添加员工信息
	public int insEmpInfo(int empno,String ename,String job,int mgr,Date hiredate,double sal,double comm,int deptno){
		//创建sql语句
		String sql="insert into emp values(?,?,?,?,?,?,?,?)";
		//将日期转换为java.sql.date类型
		java.sql.Date d=new java.sql.Date(hiredate.getTime());
		int i=JdbcUtil.executeDML(sql,empno,ename,job,mgr,d,sal,comm,deptno);
		return i;
	}
	//修改员工姓名
	public int upEmp(String newName,int empno){
		return JdbcUtil.executeDML("update emp set ename=? where empno=?",newName,empno);
	}
	//删除员工信息	
	public int delEmp(int empno){
		return JdbcUtil.executeDML("delete from emp where empno=?",empno);
	
	}
}
