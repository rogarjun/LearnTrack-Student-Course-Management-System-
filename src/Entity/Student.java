package Entity;

public class Student extends Person{
    //Fields: id, firstName, lastName, email, batch, active (boolean)
    public String batch;
    public boolean active;

    public Student(int id, String firstName, String lastName, String email, String batch, boolean active) {
        super.id = id;
        super.firstName = firstName;
        super.lastName = lastName;
        super.email = email;
        this.batch = batch;
        this.active = active;
    }

    public Student(int id, String firstName, String lastName, String batch, boolean active) {
        super.id = id;
        super.firstName = firstName;
        super.lastName = lastName;
        this.batch = batch;
        this.active = active;
    }

    @Override
    public void getDisplayName() {
        System.out.println("Student Name: " + firstName + " " + lastName);
    }

    public void displayStudentDetails() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Batch: " + batch);
        System.out.println("Active: " + active);
        System.out.println("-------------------------");
    }
}
