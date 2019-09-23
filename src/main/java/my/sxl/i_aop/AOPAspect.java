package my.sxl.i_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component("aopAspect")
public class AOPAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("Before");
        Object object = methodInvocation.proceed();
        System.out.println("After\n---");
        return object;
    }
}
