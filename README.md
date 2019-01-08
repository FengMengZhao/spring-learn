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
