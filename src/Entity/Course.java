package Entity;

public class Course {
    //Fields: id, courseName, description, durationInWeeks, active

    public int id;
    public String courseName;
    public String description;
    public int durationInWeeks;
    public boolean active;

    public Course(int id, String courseName, String description, int durationInWeeks, boolean active) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
    }

    // Overloaded constructor
    public Course(int id, String courseName, int durationInWeeks, boolean active) {
        this.id = id;
        this.courseName = courseName;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
    }

    public Course(){
        //this is default constructor.
    }

    public void displayCourseDetails() {
        System.out.println("Course Id: " + id);
        System.out.println("Course Name: " + courseName);
        System.out.println("Description: " + description);
        System.out.println("Duration In Weeks: " + durationInWeeks);
        System.out.println("Active: " + active);
        System.out.println("--------------------------");
    }
}

