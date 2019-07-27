package my.sxl.c_inject;

public class InstanceFactory {
    public Service getService(){
        System.out.println("InstanceFactory.getService()");
        DAO dao = new DAOImpl();
        dao.insert("c_inject from StaticFactory.getService");
        ServiceImpl serviceI = new ServiceImpl();
        serviceI.setDao(dao);
        //Service service = serviceI; 可以直接return实现类 这边commit git时提示redundant
        return serviceI;
    }
}
