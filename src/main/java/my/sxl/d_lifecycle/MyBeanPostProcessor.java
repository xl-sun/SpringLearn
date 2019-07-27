package my.sxl.d_lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization beanName:"+ beanName);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor.postProcessAfterInitialization beanName:"+ beanName);


        //要求接口有的方法?
        Proxy.newProxyInstance(MyBeanPostProcessor.class.getClassLoader(),
                bean.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("MyBeanPostProcessor.postProcessAfterInitialization->InvocationHandler");
                        //这里要执行目标对象 否则被拦截了就不执行了
                        Object obj = method.invoke(bean,args);
                        return obj;
                    }
                });

        return null;
    }
}
