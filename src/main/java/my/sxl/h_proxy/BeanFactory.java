package my.sxl.h_proxy;


import my.sxl.h_proxy.aop.AOPService;
import my.sxl.h_proxy.cglib.CglibService;
import my.sxl.h_proxy.jdk.Aspect;
import my.sxl.h_proxy.jdk.Service;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class BeanFactory {

    private static BeanFactory beanFactory;

    @Autowired
    @Qualifier("jdkService")
    private Service jdkService;

    @Autowired
    private CglibService cglibService;

    @Autowired
    @Qualifier("proxyService")
    ProxyFactoryBean proxyService;

    @Autowired
    private Aspect aspect;

    /*
    @Autowired
    @Qualifier("aopService")
    private AOPService aopService;
    @Autowired
    private AOPAspact aopAspact;*/


    public static Service createJDKService(){
        //Service service = new ServiceImpl();
        Service proxyService = (Service) Proxy.newProxyInstance(
                BeanFactory.class.getClassLoader(),
                beanFactory.jdkService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        beanFactory.aspect.myBefore();
                        Object object = method.invoke(beanFactory.jdkService,args);
                        beanFactory.aspect.myAfter();
                        return object;
                    }
                }
        );
        return proxyService;
    }

    public static CglibService createCglibService(){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                beanFactory.aspect.myBefore();
                Object object = method.invoke(beanFactory.cglibService,objects);
                beanFactory.aspect.myAfter();
                return object;
            }
        });
//        CglibService proxyService =
        return (CglibService) enhancer.create();
    }

    public static AOPService createAOPService(){
        return (AOPService) beanFactory.proxyService.getObject();
    }

    @PostConstruct
    public void init(){
        beanFactory=this;
    }

    @PreDestroy
    public void des(){
        System.out.println("des:"+jdkService);

    }
}
