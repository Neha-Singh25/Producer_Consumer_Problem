# Java Multithreading Producer-Consumer 🛠️🛒

## 📚 Description
This project demonstrates the **Producer-Consumer** problem using Java threads. It simulates a real-world scenario where a **Producer** produces items and adds them to a shared resource, while a **Consumer** consumes items from the shared resource. The implementation showcases thread synchronization and inter-thread communication using Java’s `synchronized`, `wait()`, and `notify()` mechanisms.

## ⚙️ Files
- **`Company.java`**: Manages the shared resource and handles synchronization between Producer and Consumer.
- **`Producer.java`**: Simulates the production of items and adds them to the shared resource.
- **`Consumer.java`**: Simulates the consumption of items from the shared resource.
- **`Main.java`**: Initializes and starts the Producer and Consumer threads.

## 🚀 How to Run
1. **Compile the Java files**:
    javac *.java

2. **Run the Main class:**:   
    java Main

## 📈 Example Output
    Produced: 1
    Consumed: 1
    Produced: 2
    Consumed: 2
    ...

## 🛠️ Features

-Thread synchronization using **`synchronized`** blocks.<br>
-Inter-thread communication using **`wait()`** and **`notify()`**.<br>
-Simulates continuous production and consumption cycles.    
