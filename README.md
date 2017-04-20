# swagger-bootstarp-ui演示项目

# 说明

因为swagger-bootstrap-ui的jar包没有上传的中央仓库,需要[下载](https://git.oschina.net/xiaoym/swagger-bootstrap-ui/releases)swagger-bootstrap-ui的jar包,然后使用maven install 命令 到本地仓库

```java
mvn install:install-file  -Dfile=swagger-bootstrap-ui-1.0.jar  -DgroupId=com.drore.cloud  -DartifactId=swagger-bootstrap-ui -Dversion=1.0 -Dpackaging=jar
```

不然maven中的以下配置会报错

```java
<dependency>
    <groupId>com.drore.cloud</groupId>
    <artifactId>swagger-bootstrap-ui</artifactId>
    <version>1.0</version>
</dependency>

```

1、该项目是Spring boot项目,直接main方法运行`SwaggerBootstrapUiDemoApplication`即可

2、端口是`application.properties`中配置的8999
```java
server.port=8999
```

3、访问http://localhost:8999/doc.html