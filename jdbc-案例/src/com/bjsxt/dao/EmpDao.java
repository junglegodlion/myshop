package com.bjsxt.dao;

import java.util.ArrayList;
import java.util.Date;

import com.bjsxt.pojo.Emp;

public interface EmpDao {
	//查询所有员工信息
		public ArrayList<Emp> selAllEmpInfo();
	//根据编号查询员工信息
		public Emp selEmpInfoByEmpno(int empno);
	//添加员工信息
		public int insEmpInfo(int empno,String ename,String job,int mgr,Date hiredate,double sal,double comm,int deptno);
	//修改员工姓名
		public int upEmp(String newName,int empno);
	//删除员工信息	
		public int delEmp(int empno);
	
}
