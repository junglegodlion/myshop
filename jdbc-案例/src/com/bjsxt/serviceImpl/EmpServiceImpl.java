package com.bjsxt.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.bjsxt.dao.EmpDao;

import com.bjsxt.pojo.Emp;
import com.bjsxt.service.EmpService;
import com.bjxst.daoImpl.EmpDaoImpl;

public class EmpServiceImpl implements EmpService{
	//声明数据库层对象
	EmpDao ed=new EmpDaoImpl();
	//查询全部员工信息
		public void selAllEmpInfo(){
			
			//操作数据库
			ArrayList<Emp> list=ed.selAllEmpInfo();
			System.out.println("用户编号\t\t用户名\t\t工作岗位\t\t领导编号\t\t入职日期\t\t基本薪资\t\t提成\t\t部门编号");
			//遍历
			for(int i=0;i<list.size();i++){
				Emp p=list.get(i);
				System.out.print(p.getEmpno());
				System.out.print("\t\t");
				System.out.print(p.getEname());
				System.out.print("\t\t");
				System.out.print(p.getJob());
				System.out.print("\t\t");
				System.out.print(p.getMgr());
				System.out.print("\t\t");
				System.out.print(p.getDate());
				System.out.print("\t\t");
				System.out.print(p.getSal());
				System.out.print("\t\t");
				System.out.print(p.getComm());
				System.out.print("\t\t");
				System.out.print(p.getDeptno());
				System.out.println();
			}
		}
		//根据用户编号查询用户信息
		public void selEmpInfoByEmpno(){
			//获取用户数据
				Scanner sc=new Scanner(System.in);
				System.out.println("请输入要查找的员工编号:");
				int empno=sc.nextInt();
				//操作数据库
				Emp p=ed.selEmpInfoByEmpno(empno);
				if(p!=null){
					System.out.println("用户编号\t用户名\t工作岗位\t领导编号\t入职日期\t\t基本薪资\t提成\t部门编号");
					System.out.print(p.getEmpno());
					System.out.print("\t");
					System.out.print(p.getEname());
					System.out.print("\t");
					System.out.print(p.getJob());
					System.out.print("\t");
					System.out.print(p.getMgr());
					System.out.print("\t");
					System.out.print(p.getDate());
					System.out.print("\t");
					System.out.print(p.getSal());
					System.out.print("\t");
					System.out.print(p.getComm());
					System.out.print("\t");
					System.out.print(p.getDeptno());
				}else{
					System.out.println("查无此人");
				}
				
		}
		//删除员工信息
		public void delEmpInfo(){
			//获取用户数据
			Scanner sc=new Scanner(System.in);
			System.out.println("请输入要删除的员工编号:");
			int empno=sc.nextInt();
				//操作数据库
				int i=ed.delEmp(empno);
			//判断结果
				if(i>0){
					System.out.println("删除成功");
				}else{
					System.out.println("删除失败");
				}
		}
		//新增员工信息
		public void insEmpInfo(){
			//获取用户数据
			Scanner sc=new Scanner(System.in);
			System.out.println("请输入新增用户编号:");
			int empno=sc.nextInt();
			System.out.println("请输入新增用户名:");
			String ename=sc.next();
			System.out.println("请输入新增用户工作:");
			String job=sc.next();
			System.out.println("请输入新增用户领导编号:");
			int mgr=sc.nextInt();
			System.out.println("请输入入职日期(YYYY-MM-DD):");
			String date=sc.next();
			System.out.println("请输入新增用户工基本资:");
			double sal=sc.nextDouble();
			System.out.println("请输入新增用户的提成:");
			double comm=sc.nextDouble();
			System.out.println("请输入新增用户的部门编号");
			int deptno =sc.nextInt();
			//将字符串类型的日期转换为Date类型
			Date hiredate=null;
			try {
				hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i=ed.insEmpInfo(empno, ename, job, mgr, hiredate, sal, comm, deptno);
			//判断结果
				if(i>0){
					System.out.println("增加成功");
				}else{
					System.out.println("增加失败");
				}
			
		}
		//更新用户信息
			public void upEmpInfo(){
				//获取用户数据
				Scanner sc=new Scanner(System.in);
				System.out.println("请输入用户编号:");
				int empno=sc.nextInt();
				System.out.println("请输入新的用户名:");
				String newName=sc.next();
			//调用数据库层操作数据库
				int i=ed.upEmp(newName, empno);
			//提示用户更新结果
				if(i>0){
					System.out.println("更新成功");
				}else{
					System.out.println("更新失败");
				}
			}
}


































