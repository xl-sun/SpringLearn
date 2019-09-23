package my.sxl.j_aspectj.annotation;

import my.sxl.j_aspectj.Service;

@org.springframework.stereotype.Service("annotationService")
public class ServiceImpl implements Service {
    @Override
    public boolean add(String s) {
        System.out.println("ServiceImpl.add("+ s +")");
        return s!=null;
    }

    @Override
    public boolean delete(String s) {
        System.out.println("ServiceImpl.delete("+ s +")");
        return s!=null;
    }

    @Override
    public void query(String s) {
        System.out.println("ServiceImpl.query("+ s +")");
        s.getClass();
    }

    @Override
    public String query(String s, int n) {
        System.out.println("ServiceImpl.query("+ s +","+ n +")");
        String result = String.format("String s=\"%s\"",s);
        return result;
    }
}
