package Entity;

import java.util.Date;

public class Enrollment {

    public int id;
    public int studentId;
    public int courseId;
    public Date enrollmentDate;
    public String status;

    public Enrollment(int id, int studentId, int courseId, Date enrollmentDate, String status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    public Enrollment(int id, int studentId, int courseId, Date enrollmentDate) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = "ACTIVE";
    }

    public void displayEnrollmentDetails() {
        System.out.println("Enrollment Id: " + id);
        System.out.println("Student Id: " + studentId);
        System.out.println("Course Id: " + courseId);
        System.out.println("Enrollment Date: " + enrollmentDate);
        System.out.println("Status: " + status);
        System.out.println("----------------------------");
    }
}