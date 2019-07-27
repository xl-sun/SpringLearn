package my.sxl.e_p;

public class Job {
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
        System.out.println("Job.setId");
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
