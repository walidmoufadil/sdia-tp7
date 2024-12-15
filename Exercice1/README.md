### `Talkative` Class

The `Talkative` class implements the `Runnable` interface and demonstrates the creation and execution of threads in Java. Each instance of this class shares a static integer variable, which is printed 100 times by each thread during its execution.

#### **Constructor**

```java
public Talkative(int entier);
```
- **Parameter**:
    - `entier`: An integer value assigned to the static variable shared across all instances of the class.
- **Description**: This constructor initializes the static variable `entier` with the provided value.  
  **Note**: Since the variable is static, it is shared among all instances, and each new instantiation overwrites the previous value.

#### **Methods**

1. **`run()`**
    - **Description**: This method is called when a thread is executed. It iterates 100 times, printing the current value of the static variable `entier` to the console.
    - **Example Output**:
      ```
      1
      1
      ...
      2
      2
      ...
      ```

2. **`main(String[] args)`**
    - **Description**: The entry point of the program. This method:
        1. Creates 10 instances of the `Talkative` class, each initialized with a different integer value.
        2. Starts 10 threads in parallel, each executing the `run` method.

#### **Features and Limitations**
- **Static Variable**: The variable `entier` is declared as `static`, meaning it is shared among all instances of the `Talkative` class. As a result, the value displayed by all threads corresponds to the most recently assigned value at runtime.
- **Concurrency Issues**: Threads access the shared static variable `entier` concurrently without synchronization, which may lead to unexpected behavior in real-world applications.

#### **Observation**
When this program is executed, we observe that **all threads print the same value**, which corresponds to the last value assigned to the static variable `entier`. This happens because all threads share the same memory space for the static variable, and changes made by one thread affect all others.

#### **Example Execution**
The output typically shows the same value printed by all threads due to concurrent access to the shared static variable `entier`. A potential snippet of the output might look like this:
```
10
10
10
...
10
```

#### **Potential Improvements**
- **Synchronization**: Synchronize access to the static variable `entier` to avoid interference between threads.
- **Instance Variables**: Replace the static variable with an instance variable to give each thread its own unique value.

---
