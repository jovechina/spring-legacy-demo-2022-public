# spring-legacy-demo-2022-public
spring mvc + mybatis + mysql  demo code for legacy spring project

## 开发工具
[JDK 11](https://developer.ibm.com/languages/java/semeru-runtimes/downloads)

[Spring Tools Suite 4](https://spring.io/tools)

[Mysql Community](https://dev.mysql.com/downloads/installer/)

## 开发步骤
1. 配置spring，mybatis，mysql的集成
2. 功能1
	* View - JSP	
	* Model - 数据Bean
	* Controller - API/Path
	* persistence - 持久层数据操作
	* Service - 服务层，需要的时候
3. 功能2
	...

## 讲解重点
### Day1
1. 项目创建
	```
	Spring Legacy Project/Spring MVC Project
	```
2. pom.xml（option 依赖组件更新到最新版本）
3. View开发
4. Model开发
5. Controller开发
6. 测试，联动
7. 观察日志


### Day1 回顾-知识点
1. 理解Spring配置文件
2. 理解依赖包的设置
3. 理解依赖包的版本升级
4. 熟悉JSP的构成
5. 理解View的数据如何传给Controller（Request Level）
6. 理解Controller的数据如何传给View（Request Level）
7. Log4j, 使用日志来调试

### Day2
1. 添加Mybatis支持
	*	root-context.xml
	*	mybatis.xml
2. 添加Mysql的配置
	*	root-context.xml (dataSource)
3. 添加DB访问功能
	*	xxxMapper.xml	
	*	xxxMapper.java
	*	调用mapper程序(xxxServiceImpl.java)
4. 测试DB访问

### Day2 回顾-知识点
1. 理解Mybatis的配置
2. 理解Mysql的配置
3. 理解Mybatis的开发过程
	*	Entity/Model类
	*	xxxMapper类，或/和xxxMapper.xml
	*	service类
	*	Controller类

### Day3 
1. 实现下拉选择框
	*	Model
	*	DB访问
	*	Service
	*	Controller
	*	JSP
2. 实现Radio Button
	*	Model
	*	DB访问
	*	Service
	*	Controller
	*	JSP
3. 实现login功能
	*	密码使用加密方式
4. 数据传递（Session Scope）
### Day3 回顾-知识点
1. 理解Mybatis上的Select的实现
2. MVC各模块负责的功能
3. 理解Spring MVC Form
4. 数据加密
5. 理解跨页面访问数据（Session）

### Day4
1. 表单输入数据的验证
2. 错误信息的显示
3. 后台验证
4. 错误信息的修改
### Day4 回顾-知识点
1. javax validation
2. hibernate validation
3. jsp form error

### Day5
1. 装修估算画面
	* 根据数据动态显示估算画面
2. mybatis多表级联查询
### Day5 回顾-知识点
1. Mybatis的多表级联查询

### Day6
1. 装修估算画面 （确认画面）
2. 画面迁移(前后移动)
	* 前后移动时数据的保持(Session)
### Day6 回顾-知识点
1. 画面项目的Disable
2. Session数据 保存和使用（复习）
3. Req数据 保存和使用（复习）
4. JSP中的modelAttribute
5. JSP中的普通数据

### Day7
1. 装修估算画面 
	* 画面数据的保存
3. 历史估算的查询
	* 查询和查询结果画面
	* 修改，删除，详细按钮
4. 修改画面 (新规画面 的复用)
5. 详细画面 (确认画面 的复用)
6. 删除操作
### Day7 回顾-知识点
1. 画面的增，删，改，查
2. 画面状态
3. JSP隐含变量
4. Session变量
5. 画面复用
