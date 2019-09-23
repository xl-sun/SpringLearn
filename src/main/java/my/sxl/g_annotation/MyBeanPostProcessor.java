package my.sxl.g_annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization beanName:"+ beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        //System.out.println("MyBeanPostProcessor.postProcessAfterInitialization beanName:"+ beanName);

        return Proxy.newProxyInstance(MyBeanPostProcessor.class.getClassLoader(),
                bean.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.print("\tInvocationHandler:"+ bean.getClass().getSimpleName()+"."+method.getName()+"(");
                        Object obj = method.invoke(bean,args);
                        return obj;
                    }
                });


    }
}
