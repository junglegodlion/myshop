package com.bjsxt.service;

public interface EmpService {
	//查询全部员工信息
			public void selAllEmpInfo();
	//根据用户编号查询用户信息
			public void selEmpInfoByEmpno();
	//删除员工信息
			public void delEmpInfo();
	//新增员工信息
			public void insEmpInfo();
	//更新用户信息
			public void upEmpInfo();
}
