import java.util.UUID; //to generate a unique identifier

public class Employees implements Info {
    private String emp_id;
    private String emp_name;
    private String emp_position;
    private String email;
    private String phoneNumber;
    private int age;

    //Constructor: used to create instances of the employees class
    public Employees(String emp_name, String emp_position, String email, String phoneNumber, int age) {
        this.emp_id = String.valueOf(UUID.randomUUID());
        this.emp_name = emp_name;
        this.emp_position = emp_position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    @Override //overrides a method declared in the info interface
    public String getId() {
        return emp_id;
    }

    @Override
    public String getName() {
        return emp_name;
    }

    @Override
    public String getPosition() {
        return emp_position;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int getAge() {
        return age;
    }

    public String getDetails() {
        return "Employee ID: " + emp_id + ", Name: " + emp_name +
               ", Position: " + emp_position + ", Email: " + email +
               ", Phone Number: " + phoneNumber + ", Age: " + age;
    }
}