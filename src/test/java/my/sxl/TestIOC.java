package my.sxl;

import my.sxl.a_ioc.Service;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
    @Test
    public void demo(){
        //String xmlPath ="main\\java\\my\\sxl\\a_ioc\\applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");

        Service service = (Service) applicationContext.getBean("service");
        service.add();
    }
}
