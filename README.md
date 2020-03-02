# Spring Boot 简单练手项目

## 使用IDEA快速搭建一个Spring Boot项目
查看图片 `assets/spring-boot-init.png`

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
## 事务
事务，特指数据库事务，要么都成功执行，要么都失败，只需加上 @Transactional注解
并且在数据库中将数据库引擎设置为 InnoDB

## 热部署，修改代码后可以自动重启Spring Boot
热启动需要在一开始就引入组件：spring-boot-devtools。
它是 Spring Boot 提供的一组开发工具包，其中就包含我们需要的热部署功能，在使用这个功能之前还需要再做一些配置。
添加依赖
在 pom.xml 文件中添加 spring-boot-devtools 组件。
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-Devtools</artifactId>
  <optional>true</optional>
</dependency>
```
在 plugin 中配置另外一个属性 fork，并且配置为 true。
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <fork>true</fork>
            </configuration>
        </plugin>
    </plugins>
</build>
```
配置 IDEA
1. 选择 File | Settings | Compiler 命令，然后勾选 Build project automatically 复选框。
2. 使用快捷键 Ctrl（command） + Shift + A，
在输入框中输入 Registry，勾选 compile.automake.allow.when.app.running 复选框。