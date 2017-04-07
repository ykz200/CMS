# CMS
简易spring+springmvc+mybatis框架 数据库采用mysql

项目采用java开发 运行环境必须安装jdk1.7 及以上版本
 
项目采用maven的构架方式，运行环境必须安装maven 

文本编辑器 采用Uedito富文本编辑器
 
如以上运行环境没有问题、请按照以下几步操作启动项目

1、请将根目录的cms.sql导入到mysql数据库中 

2、将项目以maven项目导入的方式导入到开发工具中例如 eclipse 、idea 支持maven开发的工具

3、数据库配置文件resource/jdbc.properties 根据数据库用户和密码不同适当的调整修改

4、开发工具部署启动运行方式
    
   tomcat 7.x以上版本 启动成功后访问 127.0.0.1:tomcat启动端口/CMS  tomcat默认端口8080 
   #如果不通过开发工具部署到tomcat，请将项目打成war包的方式，将war包放在tomcat/webapp下进行启动  
   
   jetty 启动端口可在pom文件进行个人需要进行修改 127.0.0.1:jetty启动端口/CMS  jetty默认配置8080
   其他启动服务 自行尝试
  
如有其他问题可邮箱骚扰~ yuankz888@gmail.com  
