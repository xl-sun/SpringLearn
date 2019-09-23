package my.sxl.g_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Scope("prototype")
@Controller("action")
public class Action implements IAction {
    @Autowired
    private Service service;
    @Override
    public void execute(){
        //System.out.println("Action.execute");
        service.add("hahaha");
        service.delete("heiheihei");
    }

    @PostConstruct
    private void init(){
        System.out.println("Action.init()-->"+this.hashCode()+"-->service HASH:"+service.hashCode());
    }

    @PreDestroy
    private void destroy(){
        System.out.println("Action.destroy()-->"+this.hashCode()+"-->service HASH:"+service.hashCode());
    }
}
