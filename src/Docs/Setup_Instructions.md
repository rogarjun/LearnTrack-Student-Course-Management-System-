# Setup Instructions

## JDK Version Used

JDK 25.0.2

## Running Hello World Program

### Steps:

1. Create a file named `HelloWorld.java`
2. Write the following code:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

3. Compile the program:

```
javac HelloWorld.java
```

4. Run the program:

```
java HelloWorld
```

### Output:

```
Hello, World!
```

### Explanation:

* `javac` compiles the Java file into bytecode (`.class` file)
* `java` command runs the bytecode using JVM