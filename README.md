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