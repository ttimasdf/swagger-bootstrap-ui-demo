# swagger-bootstarp-ui演示项目

# 说明

swagger-bootstrap-ui的jar包已经上传到maven中央仓库,可以直接使用

[中央仓库地址](https://search.maven.org/search?q=g:com.github.xiaoymin%20AND%20a:swagger-bootstrap-ui&core=gav)

maven配置

```java
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>swagger-bootstrap-ui</artifactId>
    <version>${lastVersion}</version>
</dependency>
```

1、该项目是Spring boot项目,直接main方法运行`SwaggerBootstrapUiDemoApplication`即可

2、端口是`application.properties`中配置的8999
```java
server.port=8999
```

3、访问http://localhost:8999/doc.html