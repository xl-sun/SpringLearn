package my.sxl.h_proxy.cglib;


@org.springframework.stereotype.Service("cglibService")
public class CglibService {

    public void add(String s) {
        System.out.println("cglibService.add("+ s +")");
    }

    public void delete(String s) {
        System.out.println("cglibService.delete("+ s +")");
    }

    public void query(String s) {
        System.out.println("cglibService.query("+ s +")");
    }

}
