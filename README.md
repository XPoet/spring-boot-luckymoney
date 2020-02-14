# Spring Boot 简单练手项目


## 修改 Maven 默认的下载地址
修改 ~/.m2/ 文件下面的 settings.xml 文件，将其替换成 settings.ali.xml 里面的内容，即使用阿里镜像。  

**目录说明：assets文件夹是跟项目代码无关的文件夹，存放一些静态资源**  

## 使用 Maven 启动 Spring Boot 的方法
进入到 Spring Boot 项目目录下，使用命令：`mvn spring-boot:run`

## 使用 Maven 打包项目
命令：`mvn clean package`，打包成功后，会在当前项目目录下，生成新的文件夹target,
使用Java命令：`java -jar xxxx.jar`，即可启动该项目。

## 在已打包好的项目使用不同的配置文件
- 使用 prod 配置文件
`$ java -jar -Dspring.profiles.active=prod xxxxx.jar`

- 使用 dev 配置文件
`$ java -jar -Dspring.profiles.active=dev xxxxx.jar`

## 在Maven安装依赖spring-boot-starter-thymeleaf，即可在Controller返回模板内容
第一步：Maven安装 spring-boot-starter-thymeleaf 
第二步：在 templates 文件夹下新建HTML文件
第三步：HelloController 使用 @Controller 注解
第四步：接口返回HTML文件`return "index""`

## 连接和操作MySQL数据库
Maven安装 mysql-connector-java 和 spring-boot-starter-data-jpa 依赖
配置文件里添加
```yaml
spring:
  jpa:
    show-sql: true
    hibernate:
      ddl-auto: update
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/luckymoney
    username: root
    password: 123456
    driver-class-name: com.mysql.cj.jdbc.Driver
```


