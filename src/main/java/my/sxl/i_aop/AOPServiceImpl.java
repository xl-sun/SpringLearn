package my.sxl.i_aop;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@org.springframework.stereotype.Service("aopService")
public class AOPServiceImpl implements AOPService {



    @PostConstruct
    private void init(){
        System.out.println("AOPService.init()-->"+this.hashCode());
    }


    @PreDestroy
    private void destroy(){
        System.out.println("AOPService.destroy()-->"+this.hashCode());
    }

    @Override
    public void add(String s) {
        System.out.println("AOPService.add("+ s +")");
    }

    @Override
    public void delete(String s) {
        System.out.println("AOPService.delete("+ s +")");
    }

    @Override
    public void query(String s) {
        System.out.println("AOPService.query("+ s +")");
    }

}
