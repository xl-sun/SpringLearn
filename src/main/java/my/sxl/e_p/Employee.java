package my.sxl.e_p;

public class Employee {
    //属性:编号\姓名\电话\职务吧
    private String id;
    private String name;
    private String tel;
    private Job job;


    public void init(){
        System.out.println("Employee.init()\t->\t"+this);
    }

    public void destroy(){
        System.out.println("Employee.destroy()\t->\t"+this);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", job=" + job +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        System.out.println("Employee.setId");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

}
