package my.sxl;


import my.sxl.b_di.Service;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {
    @Test
    public void demo(){
        String xmlPath = "META-INF/b_di.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);

        Service service = (Service) applicationContext.getBean("service");
        service.add("Hiahiahia");
        service.delete();
    }
    /*
        执行效果：
        DAO.setString():Hihihi
        Service.setDao()
        Service.add()
        DAO.insert()
        DAO.setString():Hiahiahia
        DAO.delete():string=Hiahiahia
    */
}
