package UI;

import Exception.EntityNotFoundException;
import Service.CourseService;
import Service.EnrollmentService;
import Service.StudentService;
import Util.ExceptionHandler;
import Util.InputValidator;

import java.util.Date;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    StudentService studentService = new StudentService();
    CourseService courseService = new CourseService();
    EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);

    while (true) {
      try {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Add Student");
        System.out.println("2. List Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Add Course");
        System.out.println("6. List Courses");
        System.out.println("7. Update Course");
        System.out.println("8. Delete Course");
        System.out.println("9. Enroll Student");
        System.out.println("10. View Student Enrollments");
        System.out.println("11. Mark Enrollment Completed");
        System.out.println("12. Mark Enrollment Cancelled");
        System.out.println("13. Exit");
        System.out.print("Enter choice: ");

        int choice = Integer.parseInt(sc.nextLine());

        if (!InputValidator.isValidMenuChoice(choice, 1, 13)) {
          System.out.println("Invalid option. Try again.");
          continue;
        }

        switch (choice) {

          // ================= STUDENT =================

          case 1:
            System.out.print("Enter first name: ");
            String firstName = sc.nextLine();

            System.out.print("Enter last name: ");
            String lastName = sc.nextLine();

            System.out.print("Enter email: ");
            String email = sc.nextLine();

            System.out.print("Enter batch: ");
            String batch = sc.nextLine();

            System.out.print("Enter active status (true/false): ");
            boolean sactive = Boolean.parseBoolean(sc.nextLine());

            studentService.addStudent(firstName, lastName, email, batch, sactive);
            break;

          case 2:
            studentService.listStudents();
            break;

          case 3:
            System.out.println("\n--- Students ---");
            studentService.listStudents();

            System.out.print("Enter student id to update: ");
            int updateStudentId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter new first name: ");
            String newFirstName = sc.nextLine();

            System.out.print("Enter new last name: ");
            String newLastName = sc.nextLine();

            System.out.print("Enter new email: ");
            String newEmail = sc.nextLine();

            System.out.print("Enter new batch: ");
            String newBatch = sc.nextLine();

            System.out.print("Enter active status (true/false): ");
            boolean newActive = Boolean.parseBoolean(sc.nextLine());

            studentService.updateStudent(updateStudentId, newFirstName, newLastName, newEmail, newBatch, newActive);
            break;

          case 4:
            System.out.println("\n--- Students ---");
            studentService.listStudents();

            System.out.print("Enter student id to delete: ");
            int deleteStudentId = Integer.parseInt(sc.nextLine());

            studentService.removeStudent(deleteStudentId);
            break;

          // ================= COURSE =================

          case 5:
            System.out.print("Enter course name: ");
            String courseName = sc.nextLine();

            System.out.print("Enter description: ");
            String description = sc.nextLine();

            System.out.print("Enter duration in weeks: ");
            int duration = Integer.parseInt(sc.nextLine());

            System.out.print("Enter active status (true/false): ");
            boolean cactive = Boolean.parseBoolean(sc.nextLine());

            courseService.addCourse(courseName, description, duration, cactive);
            break;

          case 6:
            courseService.listCourses();
            break;

          case 7:
            System.out.println("\n--- Courses ---");
            courseService.listCourses();

            System.out.print("Enter course id to update: ");
            int updateCourseId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter new course name: ");
            String newCourseName = sc.nextLine();

            System.out.print("Enter new description: ");
            String newDescription = sc.nextLine();

            System.out.print("Enter duration in weeks: ");
            int newDuration = Integer.parseInt(sc.nextLine());

            System.out.print("Enter active status (true/false): ");
            boolean newCourseActive = Boolean.parseBoolean(sc.nextLine());

            courseService.updateCourse(updateCourseId, newCourseName, newDescription, newDuration, newCourseActive);
            break;

          case 8:
            System.out.println("\n--- Courses ---");
            courseService.listCourses();

            System.out.print("Enter course id to delete: ");
            int deleteCourseId = Integer.parseInt(sc.nextLine());

            courseService.removeCourse(deleteCourseId);
            break;

          // ================= ENROLLMENT =================

          case 9:
            System.out.println("\n--- Students ---");
            studentService.listStudents();

            System.out.print("Enter student id: ");
            int studentId = Integer.parseInt(sc.nextLine());

            System.out.println("\n--- Courses ---");
            courseService.listCourses();

            System.out.print("Enter course id: ");
            int courseId = Integer.parseInt(sc.nextLine());

            enrollmentService.enrollStudent(studentId, courseId, new Date());
            break;

          case 10:
            System.out.println("\n--- Students ---");
            studentService.listStudents();

            System.out.print("Enter student id: ");
            int searchStudentId = Integer.parseInt(sc.nextLine());

            enrollmentService.viewEnrollmentsByStudent(searchStudentId);
            break;

          case 11:
            System.out.println("\n--- Enrollments ---");
            enrollmentService.listEnrollments();

            System.out.print("Enter enrollment id: ");
            int completeId = Integer.parseInt(sc.nextLine());

            enrollmentService.markEnrollmentCompleted(completeId);
            break;

          case 12:
            System.out.println("\n--- Enrollments ---");
            enrollmentService.listEnrollments();

            System.out.print("Enter enrollment id: ");
            int cancelId = Integer.parseInt(sc.nextLine());

            enrollmentService.markEnrollmentCancelled(cancelId);
            break;

          case 13:
            System.out.println("Exiting program...");
            sc.close();
            return;
        }

      } catch (NumberFormatException e) {
        ExceptionHandler.showMessage("Invalid number input.");
      } catch (EntityNotFoundException e) {
        ExceptionHandler.handleException(e);
      } catch (Exception e) {
        ExceptionHandler.showMessage("Something went wrong.");
      }
    }
  }
}