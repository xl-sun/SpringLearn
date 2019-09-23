package my.sxl.f_spel;

public class Job {
    public static final String[] JOBS={"ERROR","护士","教师","工程师","服务员","会计师","临时工"};
    private short id;
    private String jobTitle;

    public void init(){
        System.out.println("Job.init()\t->\t"+this);
    }

    public void destroy(){
        System.out.println("Job.destroy()\t->\t"+this);
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        System.out.println("Job.setId:"+ id);
        this.id = id<=JOBS.length?id:0;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        System.out.println("Job.setJobTitle");
        this.jobTitle = jobTitle;
    }
}
