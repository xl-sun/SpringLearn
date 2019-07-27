package my.sxl.d_lifecycle;

public class ServiceImpl implements Service {

    public void init(){
        System.out.println("Service.init()");
    }

    public void destroy(){
        System.out.println("Service.destroy()");
    }


    @Override
    public void add(String string) {
        System.out.println("Service.add("+string+")");
    }

    @Override
    public void delete() {
        System.out.println("Service.delete()");
    }



}
