# spring legacy project training
 spring legacy + mybatis + mysql training codes


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

## 练习
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
1. Spring配置文件构成的理解
2. 如何升级组件
3. JSP的开发
4. View的数据如何传到Controller
5. 调试技巧 - 使用Logger来调试程序

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
4. 测试Mysql和Mybatis

### Day3 
### Day3 回顾-知识点
