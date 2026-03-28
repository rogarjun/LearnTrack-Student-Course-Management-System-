# Design Notes

## Why ArrayList was used instead of Array

ArrayList was used instead of a traditional array because it provides dynamic resizing. In this application, the number of students, courses, and enrollments is not fixed, so using an array would require manual resizing and copying of elements.

ArrayList offers the following advantages:

* It can grow and shrink dynamically as elements are added or removed
* It provides built-in methods for insertion, deletion, and traversal
* It reduces the complexity of managing memory manually

Using ArrayList makes the code simpler, more flexible, and easier to maintain compared to fixed-size arrays.

---

## Where static members were used and why

Static members were used in the IdGenerator utility class. Methods such as getNextStudentId(), getNextCourseId(), and getNextEnrollmentId() are declared as static.

Reasons for using static:

* ID generation is a shared functionality and does not depend on object instances
* It ensures a single sequence of IDs across the application
* It allows direct access without creating an object of the IdGenerator class

This approach ensures consistency and avoids duplication of ID values.

---

## Where inheritance was used and what was gained from it

Inheritance can be applied in the project through the use of a custom exception class, EntityNotFoundException, which extends the base Exception class.

Benefits gained from inheritance:

* Code reuse from the built-in Exception class
* Ability to create a specific type of exception for better error handling
* Improved readability and maintainability by distinguishing application-specific errors

Using inheritance in this way allows the program to handle errors more effectively and in a structured manner.