1.项目功能
	名称：员工管理系统
	功能：查询所有  按照编号查询  添加员工  更新员工  删除员工
2.项目技能
	1.使用JDBC访问数据库
	2.分层开发：
	前台：调用后台并输出结果
	后台：使用JDBC访问数据库并返回结果
	3.提前工具类DBUtil，复用代码
	4.使用Properties类读取属性文件
	5.使用log4j记录日志
	6.扩展：提取查询方法（使用反射）
3.搭建项目框架
	1.创建项目 empmgr
	2.添加jar包
	3.创建包
		com.bjsxt.empmgr.dao   后台：存放访问数据库的接口  EmployeeDao
		com.bjsxt.empmgr.dao.impl 后台： 存放访问数据库的实现类 EmployeeDaoImpl
		com.bjsxt.empmgr.entity 后台：存放实体类 Employee
		com.bjsxt.empmgr.test   前台
		com.bjsxt.empmgr.util   工具类，提取数据库常用操作便于重复调用，避免代码重复
	4.创建实体类Employee
	5.创建后台的接口EmployeeDao和实现类EmployeeDaoImpl
		public List<Employee> findAll();
		public Employee findById(int empno);
		public int save(Employee emp);	
		public int update(Employee emp);	
		public void delete(int empno); 
	
4.实现具体功能
	1.查询所有员工
		1.后台
		2.前台
	2.查询指定编号的员工
		1.后台
		2.前台
	3.提供工具类DBUtil
		好处：复用代码  便于修改维护
		1.获取数据库连接：getConnection()
		2.关闭数据库资源 closeAll(rs,stmt,conn)
	4.添加员工
		1.后台
			日期的处理
			pstmt.setDate(5, new java.sql.Date(emp.getHireDate().getTime()));
			pstmt.setTimestamp(5, new java.sql.Timestamp(emp.getHireDate().getTime()));
		2.前台
	5.更新员工
		1.后台
		2.前台
	6.删除员工
		1.后台
		2.前台
	7.提供工具类DBUtil	
		1.提前DML操作的方法
		2.后台DAO中调用工具类的方法
	8.通过主菜单将各个功能整合到一起
	9.提取业务层
		之前前台负责主菜单和各个具体的交互功能
		现在：前台只负责主菜单
		提取业务层服务各个具体的交互功能
		前台调用业务层，业务层调用DAO层
		两层变成三层
		之前：前台---后台
		现在：前台---业务层----后台（DAO层）
		
	10.将四个连接参数放入属性文件，便于修改和维护
		Properties是一种特殊的Map，key和value都是String类型，一般用来读写属性文件
		Properties prop = new Properties();
		InputStream is = DBUtil.class.getResourceAsStream("/conn.properties");
		prop.load(is);
		driver = prop.getProperty("driver");
		
		
	11.使用log4j记录日志
		1.日志log
			异常信息  登录成功失败的信息  其他重要操作的信息
			方式1：System.out.println(.....)    e.printStackTrace();
			缺点：不是保存到文件，不能长久存储
			
			方式2：IO流 将System.out.println(.....)    e.printStackTrace();写入文件
			缺点：日志没有等级，日志的格式不能很好的定制
			
			方式3：使用现成的日志框架，比如log4j
			优点：长久保存   有等级   格式可以很好的定制  代码编写简单
			
		2.log4j作用
			1.记录日志（长久保存   有等级   格式可以很好的定制）
			2.为后续对日志进行分析统计，查找问题准备好内容
			
		3.log4j日志的级别
			FATAL：指出现了非常严重的错误事件，这些错误可能会导致应用程序异常中止
			ERROR：指虽有错误，但仍允许应用程序继续运行
			WARN：指运行环境潜藏着危害
			INFO：指报告信息，这些信息在粗粒度级别上突出显示应用程序的进程
			DEBUG：指细粒度信息事件，细粒度信息事件对于应用程序的调试是最有用的
			
			
		4.使用log4j记录日志
			1.加入jar包   log4j-1.2.8.jar
			2.加入属性文件 src 下 log4j.properties
			3.通过属性文件理解log4j的主要API
				Appender 日志目的地 :ConsoleAppender   FileAppender 
				Layout 日志格式化器 ：SimpleLayout  PatternLayout
			4.代码中记录日志
				private static Logger logger = Logger.getLogger(DBUtil.class.getName());
				logger.info("已经正确的读取了conn.properties：");
				logger.error("dml操作异常："+e);
				
		5.理解日志格式化字符的含义 %d{yyyy-MM-dd HH:mm:ss} %l %F %p %m%n	
		
			
	12.如果把数据库换成MySQL,需要多大的修改
		1.jar包
		2.修改四个属性值
		3.需要有数据库表（借助PowerDesigner的逆向工程将Oracle sql转换成MySQL SQL）
		4.delete 需要使用from
		5.insert 可能会使用序列，但是MySQL不需要

	13.使用反射提取select方法（模拟Hiberante）