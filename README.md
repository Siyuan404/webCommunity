## 我的社区

## 资料
https://spring.io/guides  
https://square.github.io/okhttp/  
https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support  
https://projectlombok.org/  
https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values

#### 运行我的第一个Springboot程序hello.html
https://spring.io/guides/gs/serving-web-content/

## 工具

#### 使用github托管代码
https://git-scm.com/download  
https://github.com/Siyuan404/webCommunity

#### 利用bootstrap框架搭建前端代码
https://v3.bootcss.com/getting-started/  
* 这里直接下载bootstrap，并导入项目文件(src -> resources -> static)  
* 注意引入css的路径，路径错误会导致css显示错误

#### 利用github进行注册登录
https://developer.github.com/apps/building-oauth-apps/  
https://github.com/settings/applications/1215253

#### 连接数据库
* 无论是用H2数据库还是MySQL，property中的用户名和密码都是在安装时自己设置的，不能在IDEA中设置，要填写已有的用户名和密码
* 尚未解决H2数据库的用户名密码问题，故直接使用MySQL

## 脚本
```sql
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `token` char(36) DEFAULT NULL,
  `gmt_create` BIGINT(20) DEFAULT NULL,
  `gmt_modify` BIGINT(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```

```bash
   mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
``` 
