package my.sxl.g_annotation.impl;

import my.sxl.g_annotation.DAO;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository("dao")
public class DAOImpl implements DAO {
    @PostConstruct
    private void init(){
        System.out.println("DAOImpl.init()-->"+this);
    }

    @Override
    public int update(String string) {
        System.out.println(string);
        return 0;
    }

    @Override
    public void query(String string) {
        System.out.println(string);

    }
}
