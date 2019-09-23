package my.sxl.h_proxy.jdk;

import org.springframework.stereotype.Component;

@Component("aspect")
public class Aspect {
    public void myBefore(){
        System.out.println("Aspect.myBefore");
    }

    public void myAfter(){
        System.out.println("Aspect.myAfter\n---");
    }
}
