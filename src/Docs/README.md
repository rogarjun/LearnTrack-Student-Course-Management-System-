# Project Description

This project is a console-based Student Course Management System developed using Java.

The application allows users to manage students, courses, and enrollments efficiently. It provides full CRUD (Create, Read, Update, Delete) operations for both students and courses, along with enrollment management functionality.

Key features include:

* Add, update, delete, and list students
* Add, update, delete, and list courses
* Enroll students into courses
* View enrollments by student
* Mark enrollments as completed or cancelled
* Input validation and exception handling for reliability

The project follows a layered architecture:

* UI Layer: Handles user interaction (Main class)
* Service Layer: Contains business logic (StudentService, CourseService, EnrollmentService)
* Entity Layer: Defines data models (Student, Course, Enrollment)
* Utility Layer: Provides helper functions such as validation, ID generation, and exception handling

---

# How to Compile and Run

## Using Command Line

1. Navigate to the project root directory:

```
cd your-project-folder
```

2. Compile all Java files:

```
javac UI/*.java Service/*.java Entity/*.java Util/*.java Exception/*.java
```

3. Run the application:

```
java UI.Main
```

---

## Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Locate the Main class inside the UI package
3. Right-click on Main.java and select "Run 'Main.main()'"

---

## Output

After running the program, a menu-driven interface will be displayed, allowing the user to perform various operations such as managing students, courses, and enrollments.

---

## Notes

* Ensure that JDK is properly installed and configured
* Follow the correct package structure while compiling
* IDs are generated automatically by the system
* It is recommended to view available students and courses before performing enrollment operations