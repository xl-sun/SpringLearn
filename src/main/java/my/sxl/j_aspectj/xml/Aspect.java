package my.sxl.j_aspectj.xml;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


public class Aspect{

    public void before(JoinPoint joinPoint){
        System.out.print("-------Aspect.before:"+joinPoint.getSignature().getName()+"(");
        Object[] args=joinPoint.getArgs();
        //String[] parameterNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
        for(int i=0;i<args.length;i++){
            if(i!=0) System.out.print(",");
            System.out.print(args[i]);
        }
        System.out.println(")------");
    }

    public void afterReturning(JoinPoint joinPoint,Object lalala){
        String returnType = lalala!=null?lalala.getClass().getSimpleName():"void";
        System.out.println("Aspect.afterReturning(): ("+returnType+")"+lalala+" "+joinPoint.getSignature().getName());
        System.out.println();
    }

    public void afterThrowing(JoinPoint joinPoint,Throwable ee){
        System.out.println("Aspect.afterThrowing()-->"+ee.getClass().getSimpleName()+":"+ee.getMessage());
    }

    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Aspect.around(前)");

        Object obj =null;
//        try{
            obj = pjp.proceed();
//        }catch (Exception e){}
        //Object
        System.out.println("Aspect.around(后)");
        return obj;
    }

    public void after(JoinPoint joinPoint) throws Throwable {
        System.out.println("Aspect.after() "+joinPoint.getSignature());
    }
}
