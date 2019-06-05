### 1. spring-mvc-based-xml-and-java-configuration项目

基本的Spring MVC Maven项目，基于xml配置和基于Java配置。

- 访问`http://localhost:8080/springmvc-based-xml-and-java-configuration/welcomePage`
    - `SimpleUrlHandlerMapping` --> `SimpleControllerDemo` --> `SimpleControllerHandlerAdapter`
- 访问`http://localhost:8080/springmvc-based-xml-and-java-configuration/welcomePage2`
    - `BeanNameUrlHandlerMapping` --> `HttpRequestControllerDemo` --> `HttpRequestHandlerAdapter`
- 访问`http://localhost:8080/springmvc-based-xml-and-java-configuration/welcomePage3`
    - `BeanNameUrlHandlerMapping` --> `SimpleServletController` --> `SimpleServletHandlerAdapter`
- 访问`http://localhost:8080/springmvc-based-xml-and-java-configuration/welcomePage4`
    - `RequestMappingHandlerMapping` --> `AnnotationController` --> `RequestMappingHandlerAdapter`

---

### 2. springmvc-mywebinitializer项目

Spring MVC项目使用编程的方式而非`web.xml`的方式作为web整合Spring MVC的入口。

- `MyWebInitializer`Java类注册`DispatcherServlet`
    - `XmlWebApplicationContext` --> `#setConfigLocations()`(XML BASED 配置)
    - `AnnotationConfigWebApplicationContext` --> `#register()`(Java BASED 配置)
- 访问：`http://localhost:8080/springmvc-mywebinitializer`

---

### 3. springmvc-mybatis-lightweight项目

Spring MVC项目和Mybatis框架的简单整合。

- 访问：`http://localhost:8080/springmvc-mybatis/mybatisDemo`
    - 返回数据：`{"id":"1","name":"hyxx"}`

---

### 4. spring-message-body-conversion项目

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

### 5. springmvc-freemarker-basic-demo项目

简单的Spring Freemarker项目

- 访问：`http://localhost:8080/freemarker-basic-demo`

---

### 6. springmvc-multi-datasource-jdbctemplate项目

多数据源连接项目

- 配置：

```xml
<!-- 配置数据源ds1 ，dbcp -->
<bean id="dataSource1" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
  <property name="driverClassName" value="${jdbc.driver}"/>
  <property name="url" value="${ds1.jdbc.url}"/>
  <property name="username" value="${ds1.jdbc.username}" />
  <property name="password" value="${ds1.jdbc.password}" />
  <property name="maxActive" value="30" />
  <property name="maxIdle" value="5" />
</bean>

<!-- 配置数据源ds2 ，dbcp -->
<bean id="dataSource2" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
  <property name="driverClassName" value="${jdbc.driver}"/>
  <property name="url" value="${ds2.jdbc.url}"/>
  <property name="username" value="${ds2.jdbc.username}" />
  <property name="password" value="${ds2.jdbc.password}" />
  <property name="maxActive" value="30" />
  <property name="maxIdle" value="5" />
</bean>

<!-- 配置jdbctemplate -->
<bean id="jdbcTemplate-ds1" class="org.springframework.jdbc.core.JdbcTemplate">
<property name="dataSource" ref="dataSource1"/>
</bean>

<!-- 配置jdbctemplate -->
<bean id="jdbcTemplate-ds2" class="org.springframework.jdbc.core.JdbcTemplate">
<property name="dataSource" ref="dataSource2"/>
</bean>
```

- 注入：

```java
@Autowired
@Qualifier("jdbcTemplate-ds1")
JdbcTemplate jdbcTemplateDs1;

@Autowired
@Qualifier("jdbcTemplate-ds2")
JdbcTemplate jdbcTemplateDs2;
```


- 访问：
  - `http://localhost:8080/springmvc_multi_datasource_jdbctemplate_war_exploded/ds1`
  - `http://localhost:8080/springmvc_multi_datasource_jdbctemplate_war_exploded/ds2`
