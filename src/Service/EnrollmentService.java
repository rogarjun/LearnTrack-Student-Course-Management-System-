package Service;

import Entity.Enrollment;
import Exception.EntityNotFoundException;
import Util.IdGenerator;
import Util.InputValidator;

import java.util.ArrayList;
import java.util.Date;

public class EnrollmentService {

    private ArrayList<Enrollment> enrollments = new ArrayList<>();
    private StudentService studentService;
    private CourseService courseService;

    public EnrollmentService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public void enrollStudent(Enrollment enrollment) throws EntityNotFoundException {
        if (enrollment == null) {
            System.out.println("Invalid enrollment object.");
            return;
        }

        if (!InputValidator.isValidId(enrollment.id)
                || !InputValidator.isValidId(enrollment.studentId)
                || !InputValidator.isValidId(enrollment.courseId)
                || !InputValidator.isValidStatus(enrollment.status)) {
            System.out.println("Invalid enrollment details.");
            return;
        }

        studentService.getStudentById(enrollment.studentId);
        courseService.getCourseById(enrollment.courseId);

        enrollments.add(enrollment);
        System.out.println("Enrollment created successfully.");
    }

    public void enrollStudent(int studentId, int courseId, Date enrollmentDate) throws EntityNotFoundException {
        int id = IdGenerator.getNextEnrollmentId();

        if (!InputValidator.isValidId(studentId)
                || !InputValidator.isValidId(courseId)) {
            System.out.println("Invalid enrollment details.");
            return;
        }

        studentService.getStudentById(studentId);
        courseService.getCourseById(courseId);

        Enrollment enrollment = new Enrollment(id, studentId, courseId, enrollmentDate);
        enrollments.add(enrollment);
        System.out.println("Enrollment created successfully with ID: " + id);
    }

    public void viewEnrollmentsByStudent(int studentId) throws EntityNotFoundException {
        if (!InputValidator.isValidId(studentId)) {
            System.out.println("Invalid student ID.");
            return;
        }

        studentService.getStudentById(studentId);

        boolean found = false;
        for (Enrollment enrollment : enrollments) {
            if (enrollment.studentId == studentId) {
                enrollment.displayEnrollmentDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No enrollments found for student ID " + studentId);
        }
    }

    public void markEnrollmentCompleted(int enrollmentId) throws EntityNotFoundException {
        updateEnrollmentStatus(enrollmentId, "COMPLETED");
    }

    public void markEnrollmentCancelled(int enrollmentId) throws EntityNotFoundException {
        updateEnrollmentStatus(enrollmentId, "CANCELLED");
    }

    public void updateEnrollmentStatus(int enrollmentId, String status) throws EntityNotFoundException {
        if (!InputValidator.isValidId(enrollmentId) || !InputValidator.isValidStatus(status)) {
            System.out.println("Invalid enrollment update data.");
            return;
        }

        for (Enrollment enrollment : enrollments) {
            if (enrollment.id == enrollmentId) {
                enrollment.status = status.toUpperCase();
                System.out.println("Enrollment status updated successfully.");
                return;
            }
        }

        throw new EntityNotFoundException("Enrollment with ID " + enrollmentId + " not found.");
    }

    public Enrollment getEnrollmentById(int id) throws EntityNotFoundException {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.id == id) {
                return enrollment;
            }
        }
        throw new EntityNotFoundException("Enrollment with ID " + id + " not found.");
    }

    public void listEnrollments() {
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments available.");
            return;
        }

        for (Enrollment enrollment : enrollments) {
            enrollment.displayEnrollmentDetails();
        }
    }
}