### **1. Constant Time Complexity - O(1)**

**Scenario**: Checking if a number is even or odd.

#### Code Example:
```java
class ConstantTimeExample {
    public static void main(String[] args) {
        int number = 10;

        // Check if the number is even or odd (constant time)
        if (number % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}
```

**Best, Average, Worst Case**:
- All cases are **O(1)** since the operation doesn't depend on input size.  
  Examples:
  - Best: `number = 10`
  - Average: `number = 25`
  - Worst: `number = 99`

---

### **2. Linear Time Complexity - O(n)**

**Scenario**: Find the largest number in an array.

#### Code Example:
```java
class LinearTimeExample {
    public static void main(String[] args) {
        int[] arr = {5, 12, 7, 20, 3};

        // Find the maximum element in the array
        int max = findMax(arr);
        System.out.println("Maximum value: " + max);
    }

    static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
```

**Best, Average, Worst Case**:
- Best case: The array has a single element: `{5}`.
- Average case: `{5, 12, 7, 20, 3}`.
- Worst case: `{1, 2, 3, ..., n}` (n elements, all need to be checked).

---

### **3. Quadratic Time Complexity - O(n²)**

**Scenario**: Check for duplicate pairs in an array.

#### Code Example:
```java
class QuadraticTimeExample {
    public static void main(String[] args) {
        int[] arr = {5, 7, 5, 9};

        // Check for duplicate pairs
        findDuplicatePairs(arr);
    }

    static void findDuplicatePairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Duplicate pair found: " + arr[i]);
                }
            }
        }
    }
}
```

**Best, Average, Worst Case**:
- Best case: No duplicates (e.g., `{1, 2, 3}`).
- Average case: Some duplicates (e.g., `{5, 7, 5, 9}`).
- Worst case: All elements are duplicates (e.g., `{5, 5, 5, 5, 5}`).

---

### **4. Logarithmic Time Complexity - O(log n)**

**Scenario**: Binary search to find a number in a sorted array.

#### Code Example:
```java
class LogarithmicTimeExample {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 30;

        int result = binarySearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
```

**Best, Average, Worst Case**:
- Best case: Target is the middle element (`30` in `{10, 20, 30, 40, 50}`).
- Average case: Target found after a few iterations.
- Worst case: Target not found, requiring full logarithmic traversal.
---

### **5. Exponential Time Complexity - O(2ⁿ)**

**Description**: Time doubles with every additional input (e.g., solving the Fibonacci sequence recursively).

#### Code Example:
```java
class ExponentialTime {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
    }

    static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
```

**Test Cases**:
- **Best case**: `fibonacci(0)` or `fibonacci(1)` (constant time).
- **Average case**: `fibonacci(5)` (several recursive calls).
- **Worst case**: `fibonacci(n)` for large n, requiring `2ⁿ` recursive calls.
---

### **6. Factorial Time Complexity - O(n!)**

**Scenario**: Generate all permutations of a string.

#### Code Example:
```java
import java.util.ArrayList;
import java.util.List;

class FactorialTimeExample {
    public static void main(String[] args) {
        String str = "ABC";
        List<String> permutations = generatePermutations(str, "");
        System.out.println(permutations);
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

**Best, Average, Worst Case**:
- Best case: String has 1 character (`"A"` → 1 permutation).
- Average case: String has 3 characters (`"ABC"` → 6 permutations).
- Worst case: String has `n` characters (`n!` permutations).

---

### **7. Linearithmic Time Complexity - O(n log n)**

**Description**: Commonly occurs in divide-and-conquer algorithms like **merge sort** and **quick sort**, where the input is divided and sorted multiple times.

#### Example Scenario:
Sorting an array using **merge sort**.

```java
class LinearithmicTimeExample {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr, 0, arr.length - 1);

        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++) rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }
}
```

- **Best case**: Sorting an already sorted array, still `O(n log n)`.
- **Average case**: Random array.
- **Worst case**: Sorting a reverse-ordered array, still `O(n log n)`.

---

### **8. Sublinear Time Complexity - O(√n)**

**Description**: Less common but useful in specific scenarios, like checking for divisors up to the square root of a number.

#### Example Scenario:
Checking if a number is prime.

```java
class SublinearTimeExample {
    public static void main(String[] args) {
        int number = 29;
        boolean isPrime = isPrime(number);

        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }

    static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
```

- **Best case**: Small prime numbers (e.g., `2` or `3`).
- **Average case**: Random number.
- **Worst case**: Large composite numbers.

---
