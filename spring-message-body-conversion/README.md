### spring-message-body-conversion项目

理解Spring HTTPMessageConverter项目

- 配置：`MyWebConfig#configureContentNegotiation()`
- 访问：`http://localhost:8080/spring-message-body-conversion/resources/result`
    - 返回数据：默认格式(xml)
- 访问：`http://localhost:8080/spring-message-body-conversion/resources/result.xml`
    - 返回数据：根据后缀判断，返回xml数据
- 访问：`http://localhost:8080/spring-message-body-conversion/resources/result.json`
    - 返回数据：根据后缀判断，返回json数据
- 自定义`ReportConverter`
    - 访问单元测试
    - 配置：`MyWebConfig#extendMessageConverters()`

POM文件中增加的`HttpMessageConverter`：

```
<!-- Gsno for HttpMessageConverter -->
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.8.5</version>
</dependency>

<!-- Jackson for HttpMessageConverter -->
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-annotations</artifactId>
  <version>2.4.6</version>
</dependency>
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-core</artifactId>
  <version>2.4.6</version>
</dependency>
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.4.6</version>
</dependency>
```

---
