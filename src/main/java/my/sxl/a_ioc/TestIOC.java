package my.sxl.a_ioc;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
    @Test
    public void demo(){
        String xmlPath = "META-INF/applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);

        Service service = (Service) applicationContext.getBean("service");
        service.add();
    }
}
