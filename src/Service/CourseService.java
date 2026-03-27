package Service;

import Entity.Course;
import Exception.EntityNotFoundException;
import Util.IdGenerator;
import Util.InputValidator;

import java.util.ArrayList;

public class CourseService {

    private ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(String courseName, String description, int durationInWeeks, boolean active) {
        int id = IdGenerator.getNextCourseId();

        if (!InputValidator.isValidCourseName(courseName)
                || !InputValidator.isValidDescription(description)
                || !InputValidator.isValidDurationInWeeks(durationInWeeks)) {
            System.out.println("Invalid course details. Course not added.");
            return;
        }

        Course course = new Course(id, courseName, description, durationInWeeks, active);
        courses.add(course);
        System.out.println("Course added successfully with ID: " + id);
    }

    public void addCourse(String courseName, int durationInWeeks, boolean active) {
        int id = IdGenerator.getNextCourseId();
        if (!InputValidator.isValidCourseName(courseName)
                || !InputValidator.isValidDurationInWeeks(durationInWeeks)) {
            System.out.println("Invalid course details. Course not added.");
            return;
        }

        Course course = new Course(id, courseName, durationInWeeks, active);
        courses.add(course);
        System.out.println("Course added successfully.");
    }

    public void removeCourse(int id) throws EntityNotFoundException {
        if (!InputValidator.isValidId(id)) {
            System.out.println("Invalid course ID.");
            return;
        }

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).id == id) {
                courses.remove(i);
                System.out.println("Course removed successfully.");
                return;
            }
        }

        throw new EntityNotFoundException("Course with ID " + id + " not found.");
    }

    public void updateCourse(int id, String courseName, String description, int durationInWeeks, boolean active)
            throws EntityNotFoundException {

        if (!InputValidator.isValidId(id)
                || !InputValidator.isValidCourseName(courseName)
                || !InputValidator.isValidDescription(description)
                || !InputValidator.isValidDurationInWeeks(durationInWeeks)) {
            System.out.println("Invalid course details. Update failed.");
            return;
        }

        for (Course course : courses) {
            if (course.id == id) {
                course.courseName = courseName;
                course.description = description;
                course.durationInWeeks = durationInWeeks;
                course.active = active;
                System.out.println("Course updated successfully.");
                return;
            }
        }

        throw new EntityNotFoundException("Course with ID " + id + " not found.");
    }

    public void updateCourse(int id, int durationInWeeks, boolean active) throws EntityNotFoundException {
        if (!InputValidator.isValidId(id) || !InputValidator.isValidDurationInWeeks(durationInWeeks)) {
            System.out.println("Invalid course details. Update failed.");
            return;
        }

        for (Course course : courses) {
            if (course.id == id) {
                course.durationInWeeks = durationInWeeks;
                course.active = active;
                System.out.println("Course duration/status updated successfully.");
                return;
            }
        }

        throw new EntityNotFoundException("Course with ID " + id + " not found.");
    }

    public Course getCourseById(int id) throws EntityNotFoundException {
        for (Course course : courses) {
            if (course.id == id) {
                return course;
            }
        }
        throw new EntityNotFoundException("Course with ID " + id + " not found.");
    }

    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course course : courses) {
            course.displayCourseDetails();
        }
    }
}