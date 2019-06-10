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

---

### 7. spring-source-code-learn项目

> 在debug框架的源代码的时候，最好能够让框架输出级别低的日志，这样有利于调试代码。

- 在spring4框架中使用sl4j日志(spring5使用新的sl4j2)

  - spring java项目

    - ```java
      public class App {
          public static void main( String[] args ) {
              ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
              TestBean testBean = (TestBean) context.getBean("testBean");
              testBean.doSomething();
          }
      }
      ```

    - ```java
      public class TestBean {

          private static final Logger logger = Logger.getLogger(TestBean.class);

          public void doSomething() {
              logger.debug("I am the testBean print log... DEBUG");
              logger.info("I am the testBean print log... INFO");
          }
      }
      ```

  - spring web项目

    - ```xml
      <web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xmlns="http://java.sun.com/xml/ns/javaee"
               xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
                                   http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" version="3.0">

          <!-- Servlet Context Name -->
          <display-name>spring-source-code-learn</display-name>

          <welcome-file-list>
              <welcome-file>login.jsp</welcome-file>
              <welcome-file>login.html</welcome-file>
          </welcome-file-list>

          <context-param>
              <param-name>contextConfigLocation</param-name>
              <param-value>classpath:beans.xml</param-value>
          </context-param>

          <listener>
              <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
          </listener>

          <context-param>
              <param-name>log4jConfigLocation</param-name>
              <param-value>classpath:log4j.properties</param-value>
          </context-param>

          <listener>
              <listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
          </listener>

      </web-app>
      ```

  - bean配置

    - ```xml
      <?xml version = "1.0" encoding = "UTF-8"?>

      <beans xmlns = "http://www.springframework.org/schema/beans"
             xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation = "http://www.springframework.org/schema/beans
         http://www.springframework.org/schema/beans/spring-beans-4.0.xsd">

          <bean id="testBean" class="com.fmz.service.TestBean" />
      </beans>
      ```

  - sl4j日志配置

    - ```properties
      # Global logging configuration
      log4j.rootLogger=DEBUG, stdout
      #log4j.logger.org.springframework=INFO
      #log4j.logger.com.fmz=ERROR
      # Console output...
      log4j.appender.stdout=org.apache.log4j.ConsoleAppender
      log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
      log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n
      ```

> spring Java项目直接Java启动，web项目使用Tomcat启动
>
> spring版本选定5以下（不包括5），spring5支持新的升级版的sl4j2

---

