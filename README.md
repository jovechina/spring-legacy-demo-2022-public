# spring-legacy-demo-2022-public
spring mvc + mybatis + mysql  demo code for legacy spring project

## 开发工具
[JDK 11](https://developer.ibm.com/languages/java/semeru-runtimes/downloads)

[Spring Tools Suite 3](https://github.com/spring-projects/toolsuite-distribution/wiki/Spring-Tool-Suite-3)

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