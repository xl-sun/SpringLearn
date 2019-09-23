package my.sxl.j_aspectj.annotation;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@org.aspectj.lang.annotation.Aspect //("aspect")
public class Aspect {

    @Pointcut("execution(* my.sxl.j_aspectj.annotation.*.*(..))")
    private void pointCutId(){}

    @Before(value = "pointCutId()")
    public void before(JoinPoint joinPoint){
        System.out.print("-------Aspect.before:"+joinPoint.getSignature().getName()+"(");
        Object[] args=joinPoint.getArgs();
        for(int i=0;i<args.length;i++){
            if(i!=0) System.out.print(",");
            System.out.print(args[i]);
        }
        System.out.println(")------");
    }

    @AfterReturning(value = "pointCutId()",returning = "ret")
    public void afterReturning(JoinPoint joinPoint,Object ret){
        String returnType = ret!=null?ret.getClass().getSimpleName():"void";
        System.out.println("Aspect.afterReturning(): ("+returnType+")"+ret+" "+joinPoint.getSignature().getName());
        System.out.println();
    }

    @AfterThrowing(value = "pointCutId()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Throwable e){
        System.out.println("Aspect.afterThrowing()-->"+e.getClass().getSimpleName()+":"+e.getMessage());
    }

    @Around(value = "pointCutId()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("---Aspect.around(前)---");
        Object obj = pjp.proceed();
        System.out.println("---Aspect.around(后)---");
        return obj;
    }

    @After(value = "pointCutId()")
    public void after(JoinPoint joinPoint) throws Throwable {
        System.out.println("Aspect.after() "+joinPoint.getSignature());
    }
}
