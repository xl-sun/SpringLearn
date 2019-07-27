package my.sxl.c_inject;

public class ServiceImpl implements Service {

    private DAO dao;
    @Override
    public void add(String string) {
        System.out.println("Service.add()");
        dao.insert(string);
    }

    @Override
    public void delete() {
        dao.delete();
    }

    public void setDao(DAO dao) {
        this.dao = dao;
        System.out.println("Service.setDao()");
    }

}
