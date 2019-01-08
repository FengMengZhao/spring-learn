### springmvc-mywebinitializer项目

Spring MVC项目使用编程的方式而非`web.xml`的方式作为web整合Spring MVC的入口。

- `MyWebInitializer`Java类注册`DispatcherServlet`
    - `XmlWebApplicationContext` --> `#setConfigLocations()`(XML BASED 配置)
    - `AnnotationConfigWebApplicationContext` --> `#register()`(Java BASED 配置)
- 访问：`http://localhost:8080/springmvc-mywebinitializer`

---
