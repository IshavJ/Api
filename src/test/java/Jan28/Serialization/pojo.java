package Jan28.Serialization;

public class pojo {
    private String name;
    private  String job;

    public pojo(String name,String job){
        this.name = name;
        this.job  = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "pojo{" +
                "name='" + this.name + '\'' +
                ", job='" + this.job + '\'' +
                '}';
    }
}
