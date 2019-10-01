package com.bjsxt.test;

import java.util.Scanner;

import com.bjsxt.service.EmpService;
import com.bjsxt.serviceImpl.EmpServiceImpl;

public class Test {
	public static void main(String[] args) {
		//创建业务层对象
		EmpService es=new EmpServiceImpl();
		do{
			System.out.println("******欢迎访问员工管理系统:请选择服务****************");
			System.out.println("1.查询所有员工信息");
			System.out.println("2.根据编号查询员工信息");
			System.out.println("3.新增员工信息");
			System.out.println("4.修改员工姓名");
			System.out.println("5.删除员工信息");
			System.out.println("6.退出系统");
			System.out.println("*********************************************");
			Scanner sc=new Scanner(System.in);
			int ch=sc.nextInt();
			switch (ch) {
			case 1:
				es.selAllEmpInfo();
				break;
			case 2:
				es.selEmpInfoByEmpno();
				break;
			case 3:
				es.insEmpInfo();
				break;
			case 4:
				es.upEmpInfo();
				break;
			case 5:
				es.delEmpInfo();
				break;
			case 6:
				System.out.println("谢谢使用");
				return;
			default:
				System.out.println("输入有误,请重新选择");
				break;
			}
		}while(true);
	}
	
}
