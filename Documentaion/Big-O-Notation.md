## **What is Big-O Notation?**

Big-O Notation is a way to describe how **efficient** an algorithm is. It helps us measure:
1. **Time Complexity**: How much time an algorithm takes as the input size grows.
2. **Space Complexity**: How much memory an algorithm uses as the input size grows.

In simple words:
- **Big-O tells us how "fast" or "slow" an algorithm will be for really big inputs.**

---

## **Why is Big-O Notation important?**
Imagine you’re sorting a list of 1 million numbers:
- One algorithm takes 1 second.
- Another takes 10 years.

Big-O helps us choose the better algorithm! It gives a way to compare how algorithms perform as the input size increases.

---

## **The Basics of Big-O**
Big-O uses symbols like **O(1)**, **O(n)**, and **O(n²)** to describe an algorithm’s growth rate. Let’s look at these step by step.

### 1. **O(1): Constant Time**
- **Definition**: The algorithm takes the **same time**, no matter how big the input is.
- **Example**: Checking if the first number in a list is even.

```java
class O1Example {
    public static void main(String[] args) {
        int[] numbers = {5, 10, 15, 20};
        System.out.println(numbers[0] % 2 == 0 ? "Even" : "Odd"); // Constant time
    }
}
```
- **Why O(1)?**: No matter how many numbers are in the list, you only check one.

---

### 2. **O(n): Linear Time**
- **Definition**: The time taken grows **linearly** with the size of the input.
- **Example**: Adding all numbers in a list.

```java
class ONExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int num : numbers) { // Goes through each number
            sum += num;
        }
        System.out.println("Sum: " + sum);
    }
}
```
- **Why O(n)?**: If there are 5 numbers, you do 5 operations. For 100 numbers, you do 100 operations.

---

### 3. **O(n²): Quadratic Time**
- **Definition**: The time grows with the **square** of the input size.
- **Example**: Checking all pairs of numbers in a list.

```java
class ON2Example {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) { // Nested loop
                System.out.println("Pair: " + numbers[i] + ", " + numbers[j]);
            }
        }
    }
}
```
- **Why O(n²)?**: For 3 numbers, there are \(3 × 3 = 9\) pairs. For 100 numbers, \(100 × 100 = 10,000\) pairs.

---

### 4. **O(log n): Logarithmic Time**
- **Definition**: The time grows **very slowly** as the input size increases. Often occurs when dividing the input into halves.
- **Example**: Binary search in a sorted list.

```java
class OLogNExample {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9};
        int target = 7;

        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Middle of the list
            if (numbers[mid] == target) {
                System.out.println("Found at index: " + mid);
                break;
            } else if (numbers[mid] < target) {
                left = mid + 1; // Look in the right half
            } else {
                right = mid - 1; // Look in the left half
            }
        }
    }
}
```
- **Why O(log n)?**: Each step cuts the list in half, so the number of steps is much smaller than the input size.

---

### 5. **O(2ⁿ): Exponential Time**
- **Definition**: The time doubles with each increase in input size.
- **Example**: Calculating Fibonacci numbers using recursion.

```java
class O2NExample {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
    }

    static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2); // Two recursive calls
    }
}
```
- **Why O(2ⁿ)?**: Each number generates two new calculations, leading to exponential growth.

---

### 6. **O(n!): Factorial Time**
- **Definition**: The time grows as the factorial of the input size. Often seen in problems involving permutations or combinations.
- **Example**: Generating all permutations of a string.

```java
import java.util.ArrayList;
import java.util.List;

class ONFactorialExample {
    public static void main(String[] args) {
        String str = "ABC";
        List<String> permutations = generatePermutations(str, "");
        System.out.println("Permutations: " + permutations);
    }

    static List<String> generatePermutations(String str, String prefix) {
        List<String> result = new ArrayList<>();
        if (str.length() == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                result.addAll(generatePermutations(rem, prefix + str.charAt(i)));
            }
        }
        return result;
    }
}
```
- **Why O(n!)**: For 3 characters, there are \(3! = 6\) permutations. For 10 characters, there are \(10! = 3,628,800\) permutations.

---

## **Big-O Chart (Growth Rates)**

| Big-O       | Example Algorithm                      | Growth (Fastest to Slowest)  |
|-------------|----------------------------------------|------------------------------|
| **O(1)**    | Checking the first element             |  Constant                  |
| **O(log n)**| Binary search                          |  Very Fast                 |
| **O(n)**    | Looping through a list                 |  Fast                      |
| **O(n²)**   | Nested loops (pairs)                   |  Slower                    |
| **O(2ⁿ)**   | Fibonacci with recursion               |  Very Slow                 |
| **O(n!)**   | Generating permutations                |  Extremely Slow           |

---

## **How to Recognize Big-O in Code**
1. **O(1)**: No loops, fixed operations.
2. **O(n)**: A single loop through the data.
3. **O(n²)**: Nested loops.
4. **O(log n)**: Halving the input size (e.g., binary search).
5. **O(2ⁿ)**: Recursion with multiple branches.

---


### **Various Big-O Comparison Table**


| Input Size (n) | O(1) Time | O(n) Time | O(n²) Time | O(log n) Time | O(2ⁿ) Time |
|----------------|-----------|-----------|------------|---------------|------------|
| 10             | 1         | 10        | 100        | 3             | 1024       |
| 100            | 1         | 100       | 10,000     | 7             | 1,267,650  |
| 1000           | 1         | 1000      | 1,000,000  | 10            | 1,071,508,000 |
| 10,000         | 1         | 10,000    | 100,000,000| 14            | 1.07 × 10¹³ |

This table illustrates how the time grows differently for each algorithm type.

---