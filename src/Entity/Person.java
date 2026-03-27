package Entity;

public class Person {
    public int id;
    public String firstName;
    public String lastName;
    public String email;

    public void getDisplayName()
    {
        System.out.println("Name: " + firstName + " " + lastName);
    }
}
