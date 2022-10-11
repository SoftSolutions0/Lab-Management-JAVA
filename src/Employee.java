public class Employee {
    private final String designation;
    private String name;
    private Integer age;


    public Employee(String name, Integer age, String designation) {
        this.name = name;
        this.age = age;
        this.designation = designation;

    }

    public Employee(Employee e) { //Copy constructor
        this.name = e.name;
        this.age = e.age;
        this.designation = e.designation;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Object clone() {
        return new Employee(this);
    }
}
