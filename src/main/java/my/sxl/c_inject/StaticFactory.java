package my.sxl.c_inject;

public class StaticFactory {
    public static Service getService(){
        DAO dao = new DAOImpl();
        dao.insert("c_inject from StaticFactory.getService");
        ServiceImpl serviceI = new ServiceImpl();
        serviceI.setDao(dao);
        //Service service = serviceI;
        return serviceI;
    }
}
