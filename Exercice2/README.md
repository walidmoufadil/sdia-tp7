### `Sommeur` Class

The `Sommeur` class is a Java implementation of the `Runnable` interface designed to calculate the partial sum of an integer array. This class is often used in a multithreaded context to split and compute the sum of an array in parallel.

#### **Constructor**

```java
public Sommeur(int[] tab, int debut, int fin);
```
- **Parameters**:
    - `tab`: The integer array to sum.
    - `debut`: The starting index (inclusive) for the summation.
    - `fin`: The ending index (exclusive) for the summation.
- **Description**: The constructor initializes the range of the array to be summed (`debut` to `fin`) and sets the initial sum to `0`.

#### **Methods**

1. **`run()`**
    - **Description**: This method is executed when the thread is started. It iterates through the portion of the array defined by `debut` and `fin` and calculates the partial sum, storing the result in the `sum` variable.

2. **`getSum()`**
    - **Return Value**: Returns the calculated sum of the array slice.
    - **Description**: This method allows access to the sum calculated by the `run()` method, useful for combining results when multiple threads are used.

#### **Example Usage**

```java
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        // Define threads to calculate the sum of different parts of the array
        Sommeur sommeur1 = new Sommeur(array, 0, 5);  // Sum first half
        Sommeur sommeur2 = new Sommeur(array, 5, 10); // Sum second half
        
        Thread thread1 = new Thread(sommeur1);
        Thread thread2 = new Thread(sommeur2);
        
        thread1.start();
        thread2.start();
        
        thread1.join();
        thread2.join();
        
        // Combine results from both threads
        int totalSum = sommeur1.getSum() + sommeur2.getSum();
        System.out.println("Total Sum: " + totalSum); // Output: 55
    }
}
```

#### **Features**
- **Thread-Safe Summation**: By dividing the array into slices and using separate threads, the class enables parallel computation of array sums.
- **Flexibility**: The starting (`debut`) and ending (`fin`) indices allow summing arbitrary portions of an array.

#### **Potential Use Cases**
- Splitting large datasets for parallel processing to improve performance.
- Applications requiring fast computations over large arrays, such as in scientific computing or data analysis.

#### **Considerations**
- **Thread Coordination**: Ensure proper synchronization when accessing shared resources in larger applications.
- **Boundary Validation**: The indices `debut` and `fin` must be within the array bounds to avoid runtime exceptions.

---

### `Main` Class

The `Main` class demonstrates the usage of the `Sommeur` class for parallel computation of the sum of an integer array using multithreading. It divides the array into three parts and calculates the sum of each part in a separate thread.

#### **How It Works**

1. **Array Division**:
    - The array is divided into three equal (or nearly equal) parts, based on its length.
    - Each part is assigned to a `Sommeur` instance.

2. **Thread Creation and Execution**:
    - Three `Thread` objects are created, each associated with a `Sommeur` instance.
    - The threads are started and execute their respective `run()` methods concurrently.

3. **Thread Synchronization**:
    - The `join()` method ensures the main thread waits for all threads to finish before proceeding.

4. **Sum Calculation**:
    - The partial sums calculated by each thread are retrieved using the `getSum()` method.
    - The total sum of the array is computed by adding the partial sums.

#### **Code Example**

```java
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Define the array to sum
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Split the array into three parts
        Sommeur sommeur1 = new Sommeur(array, 0, array.length / 3);
        Sommeur sommeur2 = new Sommeur(array, array.length / 3, 2 * array.length / 3);
        Sommeur sommeur3 = new Sommeur(array, 2 * array.length / 3, array.length);

        // Create threads for each part
        Thread thread1 = new Thread(sommeur1);
        Thread thread2 = new Thread(sommeur2);
        Thread thread3 = new Thread(sommeur3);

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for threads to finish
        thread1.join();
        thread2.join();
        thread3.join();

        // Compute the total sum
        int totalSum = sommeur1.getSum() + sommeur2.getSum() + sommeur3.getSum();
        System.out.println("The total sum of the array is: " + totalSum);
    }
}
```

#### **Output Example**
Given the array `{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}`, the output will be:
```
The total sum of the array is: 55
```

#### **Key Concepts Demonstrated**
1. **Parallel Processing**:
    - The array is processed in three parts simultaneously, leveraging multithreading for efficiency.

2. **Thread Coordination**:
    - The `join()` method ensures that the main thread waits for the results of all worker threads.

3. **Scalability**:
    - This approach can easily be extended to divide the array into more parts, allowing better load balancing and higher concurrency for larger datasets.

#### **Limitations**
- **Thread Overhead**: For small arrays, the overhead of creating and managing threads may outweigh the performance gains.
- **Unequal Division**: If the array length is not divisible by 3, some threads may process slightly more or fewer elements.

#### **Potential Enhancements**
- **Dynamic Thread Count**: Dynamically determine the number of threads based on available system resources.
- **Error Handling**: Add error handling to manage exceptions during thread execution.

---
