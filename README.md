# Multithreading and Parallel Processing in Java

This project demonstrates the usage of multithreading in Java through two practical examples: **Talkative** and **Sommeur**. Each example showcases different aspects of threading, from concurrent printing to parallel computation.

## Table of Contents
1. [Exercise 1: Talkative](Exercice1)
2. [Exercise 2: Sommeur](Exercice2)

---

## Exercise 1: Talkative

The **Talkative** class highlights how multiple threads can run concurrently to demonstrate shared resource access. Each thread prints a shared static integer multiple times, showcasing the importance of understanding thread behavior when working with shared variables.

**Key Features**:
- Creation of multiple threads using the `Runnable` interface.
- Demonstration of shared static variable behavior in multithreading.

**[Go to Exercise 1](Exercice1)**

---

## Exercise 2: Sommeur

The **Sommeur** class demonstrates the use of multithreading for parallel processing. It calculates the sum of an array by splitting the work into multiple threads, with each thread computing the sum of a subarray.

**Key Features**:
- Efficient parallel computation of an array's sum.
- Thread synchronization using the `join()` method.
- Flexibility in dividing the workload among threads.

**[Go to Exercise 2](Exercice2)**

---

## Project Objectives

- **Learn Multithreading**: Understand how to create, execute, and synchronize threads in Java.
- **Explore Concurrency**: Discover common challenges such as shared resource access and how they impact program behavior.
- **Implement Parallel Processing**: Leverage multithreading to divide and conquer computational tasks for improved performance.
