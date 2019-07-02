package my.sxl.a_ioc;

public class ServiceImpl implements Service {

    @Override
    public void add() {
        System.out.println("Service.add()");
        DAO dao =new DAO();
        dao.insert();
    }
}
