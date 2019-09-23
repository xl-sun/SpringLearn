package my.sxl.h_proxy.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component("aopAspect")
public class AOPAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("AOPAspact->Before");
        Object object = methodInvocation.proceed();
        System.out.println("AOPAspact->After\n---");
        return object;
    }
}
