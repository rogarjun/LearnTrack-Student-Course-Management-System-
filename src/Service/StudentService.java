package Service;

import Entity.Student;
import Exception.EntityNotFoundException;
import Util.IdGenerator;
import Util.InputValidator;

import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (student == null) {
            System.out.println("Invalid student object.");
            return;
        }

        if (!InputValidator.isValidId(student.id)
                || !InputValidator.isValidName(student.firstName)
                || !InputValidator.isValidName(student.lastName)
                || !InputValidator.isValidEmail(student.email)
                || !InputValidator.isValidBatch(student.batch)) {
            System.out.println("Invalid student details. Student not added.");
            return;
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void addStudent(String firstName, String lastName, String email, String batch, boolean active) {
        int id = IdGenerator.getNextStudentId();

        if (!InputValidator.isValidName(firstName)
                || !InputValidator.isValidName(lastName)
                || !InputValidator.isValidEmail(email)
                || !InputValidator.isValidBatch(batch)) {
            System.out.println("Invalid student details. Student not added.");
            return;
        }

        Student student = new Student(id, firstName, lastName, email, batch, active);
        students.add(student);
        System.out.println("Student added successfully with ID: " + id);
    }

    public void removeStudent(int id) throws EntityNotFoundException {
        if (!InputValidator.isValidId(id)) {
            System.out.println("Invalid student ID.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == id) {
                students.remove(i);
                System.out.println("Student removed successfully.");
                return;
            }
        }

        throw new EntityNotFoundException("Student with ID " + id + " not found.");
    }

    public void updateStudent(int id, String firstName, String lastName, String email, String batch, boolean active)
            throws EntityNotFoundException {

        if (!InputValidator.isValidId(id)
                || !InputValidator.isValidName(firstName)
                || !InputValidator.isValidName(lastName)
                || !InputValidator.isValidEmail(email)
                || !InputValidator.isValidBatch(batch)) {
            System.out.println("Invalid student details. Update failed.");
            return;
        }

        for (Student student : students) {
            if (student.id == id) {
                student.firstName = firstName;
                student.lastName = lastName;
                student.email = email;
                student.batch = batch;
                student.active = active;
                System.out.println("Student updated successfully.");
                return;
            }
        }

        throw new EntityNotFoundException("Student with ID " + id + " not found.");
    }

    public void updateStudent(int id, String batch, boolean active) throws EntityNotFoundException {
        if (!InputValidator.isValidId(id) || !InputValidator.isValidBatch(batch)) {
            System.out.println("Invalid student details. Update failed.");
            return;
        }

        for (Student student : students) {
            if (student.id == id) {
                student.batch = batch;
                student.active = active;
                System.out.println("Student batch/status updated successfully.");
                return;
            }
        }

        throw new EntityNotFoundException("Student with ID " + id + " not found.");
    }

    public Student getStudentById(int id) throws EntityNotFoundException {
        for (Student student : students) {
            if (student.id == id) {
                return student;
            }
        }
        throw new EntityNotFoundException("Student with ID " + id + " not found.");
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student student : students) {
            student.displayStudentDetails();
        }
    }
}