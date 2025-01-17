### **1. Constant Space Complexity - O(1)**

**Description**: The algorithm uses a fixed amount of memory, regardless of input size.

#### Example Scenario: Find the sum of an array
```java
class ConstantSpaceExample {
    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20};
        int sum = 0;

        for (int num : arr) {
            sum += num; // No extra memory allocated
        }

        System.out.println("Sum: " + sum);
    }
}
```

**Space Analysis**:
- Memory usage is constant: the algorithm only uses variables like `sum` and a loop counter.
- **Space Complexity**: O(1).

---

### **2. Linear Space Complexity - O(n)**

**Description**: The algorithm's memory usage grows linearly with the input size.

#### Example Scenario: Reversing an array into a new array
```java
class LinearSpaceExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] reversed = reverseArray(arr);

        System.out.print("Reversed Array: ");
        for (int num : reversed) {
            System.out.print(num + " ");
        }
    }

    static int[] reverseArray(int[] arr) {
        int n = arr.length;
        int[] reversed = new int[n]; // Allocating memory proportional to the input size

        for (int i = 0; i < n; i++) {
            reversed[i] = arr[n - 1 - i];
        }
        return reversed;
    }
}
```

**Space Analysis**:
- Extra memory is allocated for the `reversed` array.
- **Space Complexity**: O(n), where `n` is the size of the input array.

---

### **3. Logarithmic Space Complexity - O(log n)**

**Description**: Often occurs with recursive algorithms like divide-and-conquer, where the space is used for the call stack.

#### Example Scenario: Binary search using recursion
```java
class LogarithmicSpaceExample {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 30;

        int index = binarySearch(arr, target, 0, arr.length - 1);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found.");
        }
    }

    static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;

        if (arr[mid] > target) {
            return binarySearch(arr, target, left, mid - 1); // Recursive call
        } else {
            return binarySearch(arr, target, mid + 1, right); // Recursive call
        }
    }
}
```

**Space Analysis**:
- Each recursive call uses memory for the function's stack frame.
- Depth of recursion = log(n) for binary search.
- **Space Complexity**: O(log n).

---


### **4. Quadratic Space Complexity - O(n²)**

**Scenario**: Creating a multiplication table.  
Memory usage grows quadratically as the table size increases.

#### Code Example:
```java
class QuadraticSpace {
    public static void main(String[] args) {
        int n = 3;
        int[][] table = new int[n][n]; // 2D array of size n x n

        // Fill the multiplication table
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }

        // Print the table
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

**Explanation**:
- The 2D array uses `n × n` memory.
- **Space Complexity**: O(n²).

---

### **5. Exponential Space Complexity - O(2ⁿ)**

**Description**: Common in recursive algorithms where each recursive call spawns two or more branches.

#### Example Scenario: Calculating Fibonacci numbers recursively
```java
class ExponentialSpaceExample {
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

**Space Analysis**:
- Each recursive call creates a new stack frame.
- The maximum depth of the recursion tree is proportional to `n`, but the branching creates exponential growth.
- **Space Complexity**: O(2ⁿ).

---

### **6. Factorial Space Complexity - O(n!)**

**Description**: Algorithms that deal with permutations or combinations often use factorial space.

#### Example Scenario: Generating all permutations of a string
```java
import java.util.ArrayList;
import java.util.List;

class FactorialSpaceExample {
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

**Space Analysis**:
- For `n` characters, there are `n!` permutations, and memory is allocated for each.
- **Space Complexity**: O(n!).

---
