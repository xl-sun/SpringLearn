package my.sxl;

import static org.junit.Assert.assertTrue;

import my.sxl.b_di.Service;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testIOC()
    {
        String xmlPath = "a-ioc/applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        my.sxl.a_ioc.Service service = (my.sxl.a_ioc.Service) applicationContext.getBean("service");
        service.add();
    }

    @Test
    public void testDI()
    {
        String xmlPath = "b-di/b_di.xml"; //目录不可以用下划线哦
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        Service service = (Service) applicationContext.getBean("service");
        service.delete();
        service.add("嚯哈嘿");
        service.delete();
    }
}
