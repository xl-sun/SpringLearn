package my.sxl.b_di;

public class DAOImpl implements DAO{


    String string ;
    @Override
    public void insert(String string){
        System.out.println("DAO.insert()");
        setString(string);
    }

    @Override
    public void delete() {
        System.out.println("DAO.delete():string="+string);
    }

    public void setString(String string) {
        this.string = string;
        System.out.println("DAO.setString():"+this.string);

    }


}
