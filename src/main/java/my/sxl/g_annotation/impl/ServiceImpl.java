package my.sxl.g_annotation.impl;


import my.sxl.g_annotation.DAO;
import my.sxl.g_annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    @Autowired
    @Qualifier("dao")
    private DAO dao;
    private DAO dao2;

    @PostConstruct
    private void init(){
        System.out.println("Service.init()-->"+this.hashCode());
    }


    @PreDestroy
    private void destroy(){
        System.out.println("Service.destroy()-->"+this.hashCode());
    }

    @Override
    public void add(String s) {
        //System.out.print("Service.add("+ s +")");
        //DAO dao =new DAO();
        dao2.update(s);
    }

    @Override
    public void delete(String s) {
        //System.out.print("Service.delete("+ s +")");
        dao.update(s);
    }

    @Override
    public void query(String s) {
        //System.out.print("Service.query("+ s +")");
        dao.query(s);
    }

    @Autowired
    @Qualifier("dao2")
    public void setDao2(DAO dao2) {
        this.dao2 = dao2;
    }
}
