package my.sxl.h_proxy.jdk.impl;


import my.sxl.h_proxy.jdk.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@org.springframework.stereotype.Service("jdkService")
public class ServiceImpl implements Service {



    @PostConstruct
    private void init(){
        System.out.println("JDKService.init()-->"+this.hashCode());
    }


    @PreDestroy
    private void destroy(){
        System.out.println("JDKService.destroy()-->"+this.hashCode());
    }

    @Override
    public void add(String s) {
        System.out.println("JDKService.add("+ s +")");
    }

    @Override
    public void delete(String s) {
        System.out.println("JDKService.delete("+ s +")");
    }

    @Override
    public void query(String s) {
        System.out.println("JDKService.query("+ s +")");
    }

}
