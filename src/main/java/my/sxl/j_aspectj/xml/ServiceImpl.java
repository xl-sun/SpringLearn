package my.sxl.j_aspectj.xml;

import my.sxl.j_aspectj.Service;

public class ServiceImpl implements Service  {
    @Override
    public boolean add(String s){
        System.out.println("ServiceImpl.add("+ s +")");
        //if(s==null) throw new Exception("arguments value is empty exception");
        //int i = 1/0;
        s.getClass(); //用于触发异常,当参数值为null
        return false;
    }

    @Override
    public boolean delete(String s) {
        System.out.println("ServiceImpl.delete("+ s +")");
        return false;
    }

    @Override
    public void query(String s) {
        System.out.println("ServiceImpl.query("+ s +")");
    }

    @Override
    public String query(String s, int n) {
        System.out.println("ServiceImpl.query("+ s +","+ n +")");
        System.out.println("ServiceImpl.query --> n/n-1="+ (n/(n-1)));//搞个Exception
        String result = String.format("%s/%s-1=%s",n,n,n/(n-1));
        return result;
    }
}
