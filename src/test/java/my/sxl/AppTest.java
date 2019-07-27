package my.sxl;

import static org.junit.Assert.assertTrue;

import my.sxl.b_di.Service;
import my.sxl.e_p.Job;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

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

    /*已省略实践:Scope*/

    @Test
    public void testInject()
    {

        String xmlPath = "META-INF/c_inject.xml";
        System.out.println("\tBefore applicationContext");//验证bean的创建时间
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        System.out.println("\tAfter applicationContext");//验证bean的创建时间
        //静态工厂
        my.sxl.c_inject.Service serviceStatic = (my.sxl.c_inject.Service) applicationContext.getBean("serviceStatic");
        serviceStatic.add("静态工厂\n--------------END----------------");
        //实例工厂
        my.sxl.c_inject.Service serviceInstance = (my.sxl.c_inject.Service) applicationContext.getBean("serviceInstance");
        serviceInstance.add("实例工厂\n--------------END----------------");


        /**
         * 执行效果：
         *  Before applicationContext
         * DAO.insert()
         * DAO.setString():c_inject from StaticFactory.getService
         * Service.setDao()
         * InstanceFactory.getService()
         * DAO.insert()
         * DAO.setString():c_inject from StaticFactory.getService
         * Service.setDao()
         * DAO.setString():c_inject.xml
         * 	After applicationContext
         * Service.add()
         * DAO.insert()
         * DAO.setString():静态工厂
         * --------------END----------------
         * Service.add()
         * DAO.insert()
         * DAO.setString():实例工厂
         * --------------END----------------
         */
    }

    @Test
    public void testLifeCycle()
    {
        String xmlPath = "META-INF/d_lifecycle.xml";
        //姿势一
        System.out.println("------------testLifeCycle.姿势一------------");
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        applicationContext.getBean("service");
        try {
            applicationContext.getClass().getMethod("close").invoke(applicationContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //姿势二
        System.out.println("------------testLifeCycle.姿势二------------");
        ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext(xmlPath);
        my.sxl.d_lifecycle.Service service = (my.sxl.d_lifecycle.Service)classPathXmlApplicationContext.getBean("service");
        classPathXmlApplicationContext.close();
        //测试BeanPostProcessor
        System.out.println("------------测试BeanPostProcessor------------");
        service.add("first");
        service.add("second");
        service.delete();
        /**
         * 执行效果：
         * ------------testLifeCycle.姿势一------------
         * MyBeanPostProcessor.postProcessBeforeInitialization beanName:service
         * Service.init()
         * MyBeanPostProcessor.postProcessAfterInitialization beanName:service
         * Service.destroy()
         * ------------testLifeCycle.姿势二------------
         * MyBeanPostProcessor.postProcessBeforeInitialization beanName:service
         * Service.init()
         * MyBeanPostProcessor.postProcessAfterInitialization beanName:service
         * Service.destroy()
         * ------------测试BeanPostProcessor------------
         * Service.add(first)
         * Service.add(second)
         * Service.delete()
         */
    }

    /*教学中的Setter一节省略*/

    @Test
    public void testP(){
        //p命名空间实践,
        String xmlPath = "META-INF/e_p.xml";
        ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext(xmlPath);
        classPathXmlApplicationContext.close();

        /**
         * 执行效果:
         * Job.setId
         * Job.init()	->	Job{id=1, jobTitle='扫描员'}
         * Employee.setId
         * Employee.init()	->	Employee{id='0011', name='sun', tel='666666', job=Job{id=1, jobTitle='扫描员'}}
         * Employee.destroy()	->	Employee{id='0011', name='sun', tel='666666', job=Job{id=1, jobTitle='扫描员'}}
         * Job.destroy()	->	Job{id=1, jobTitle='扫描员'}
         */
    }
}
