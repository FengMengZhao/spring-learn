import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class MyWebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup (ServletContext servletContext) throws ServletException {
        // java based configuration
        //AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        // register our config class
        //ctx.register(MyWebConfig.class);
        // xml based configuration
        XmlWebApplicationContext ctx = new XmlWebApplicationContext();
        // set springmvc configuration location
        //ctx.setConfigLocations("/WEB-INF/springmvc.xml");
        ctx.setConfigLocations("classpath:/springmvc.xml");

        ctx.setServletContext(servletContext);

        //using servlet 3 api to dynamically create
        //spring dispatcher servlet
        ServletRegistration.Dynamic servlet =
                servletContext.addServlet("springDispatcherServlet",
                        new DispatcherServlet(ctx));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }

}
