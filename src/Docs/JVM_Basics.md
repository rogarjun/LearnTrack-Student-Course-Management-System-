# JVM Basics

## What is JDK, JRE, JVM?

### JDK (Java Development Kit)

JDK is a full package used to develop Java applications. It includes tools like compiler (`javac`) and also contains JRE.

### JRE (Java Runtime Environment)

JRE provides the environment to run Java programs. It includes JVM and libraries required to execute the program.

### JVM (Java Virtual Machine)

JVM is responsible for executing Java bytecode. It converts bytecode into machine-level instructions so that the system can understand.

---

## What is Bytecode?

When you compile a Java program, it does not convert directly into machine code. Instead, it generates an intermediate code called **bytecode** (`.class` file).

This bytecode is platform-independent and can run on any system that has JVM.

---

## What does “Write Once, Run Anywhere” mean?

Java programs are compiled into bytecode, which is not specific to any operating system. This bytecode can be executed on any machine that has a JVM.

This means you can write your Java code once and run it on Windows, Linux, or Mac without changing the code. JVM handles the platform-specific execution, making Java highly portable.