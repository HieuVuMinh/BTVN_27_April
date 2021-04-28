import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String address;
    private String className;
    private double score;

    public Student(){}

    public Student(int id, String name, String address, String className, double score) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.className = className;
        this.score = score;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student " +
                "id: " + id +
                ", name: '" + name + '\'' +
                ", address: '" + address + '\'' +
                ", score: " + score ;
    }
}
