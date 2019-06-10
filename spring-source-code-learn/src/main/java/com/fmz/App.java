package com.fmz;

import com.fmz.service.TestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        TestBean testBean = (TestBean) context.getBean("testBean");
        testBean.doSomething();
    }
}
