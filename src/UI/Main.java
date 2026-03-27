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
        System.out.println("3. Add Course");
        System.out.println("4. List Courses");
        System.out.println("5. Enroll Student");
        System.out.println("6. View Student Enrollments");
        System.out.println("7. Mark Enrollment Completed");
        System.out.println("8. Mark Enrollment Cancelled");
        System.out.println("9. Exit");
        System.out.print("Enter choice: ");

        int choice = Integer.parseInt(sc.nextLine());

        if (!InputValidator.isValidMenuChoice(choice, 1, 9)) {
          System.out.println("Option not found. Please select a valid menu option.");
          continue;
        }

        switch (choice) {

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
            String studentActiveInput = sc.nextLine();

            if (!InputValidator.isValidBooleanInput(studentActiveInput)) {
              System.out.println("Invalid input. Please enter true or false.");
              break;
            }

            boolean sactive = Boolean.parseBoolean(studentActiveInput);

            studentService.addStudent(firstName, lastName, email, batch, sactive);
            break;

          case 2:
            studentService.listStudents();
            break;

          case 3:
            System.out.print("Enter course name: ");
            String courseName = sc.nextLine();

            System.out.print("Enter description: ");
            String description = sc.nextLine();

            System.out.print("Enter duration in weeks: ");
            int duration = Integer.parseInt(sc.nextLine());

            System.out.print("Enter active status (true/false): ");
            String courseActiveInput = sc.nextLine();

            if (!InputValidator.isValidBooleanInput(courseActiveInput)) {
              System.out.println("Invalid input. Please enter true or false.");
              break;
            }

            boolean cactive = Boolean.parseBoolean(courseActiveInput);

            courseService.addCourse(courseName, description, duration, cactive);
            break;

          case 4:
            courseService.listCourses();
            break;

          case 5:
            System.out.print("Enter student id: ");
            int studentId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter course id: ");
            int courseId = Integer.parseInt(sc.nextLine());

            enrollmentService.enrollStudent(studentId, courseId, new Date());
            break;

          case 6:
            System.out.print("Enter student id: ");
            int searchStudentId = Integer.parseInt(sc.nextLine());

            enrollmentService.viewEnrollmentsByStudent(searchStudentId);
            break;

          case 7:
            System.out.print("Enter enrollment id: ");
            int completeId = Integer.parseInt(sc.nextLine());

            enrollmentService.markEnrollmentCompleted(completeId);
            break;

          case 8:
            System.out.print("Enter enrollment id: ");
            int cancelId = Integer.parseInt(sc.nextLine());

            enrollmentService.markEnrollmentCancelled(cancelId);
            break;

          case 9:
            System.out.println("Exiting program...");
            sc.close();
            return;

          default:
            System.out.println("Option not found. Please select a valid menu option.");
        }

      } catch (NumberFormatException e) {
        ExceptionHandler.showMessage("Invalid number entered. Please enter numeric values where required.");
      } catch (EntityNotFoundException e) {
        ExceptionHandler.handleException(e);
      } catch (Exception e) {
        ExceptionHandler.showMessage("Something went wrong. Please try again.");
      }
    }
  }
}