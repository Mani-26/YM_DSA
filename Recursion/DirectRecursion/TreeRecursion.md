# **Tree Recursion**

### Definition:
<p>To understand Tree Recursion let’s first understand Linear Recursion. If a recursive function calling itself for one time then it’s known as Linear Recursion. Otherwise if a recursive function calling itself for more than one time then it’s known as Tree Recursion.</p>

---

### Code:
```java
public class TreeRecursion {
    public static void main(String[] args) {
        int n = 4;
        int res = fib(n);
        System.out.println(res);
    }

    static int fib(int n) {
        if (n == 0 || n == 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}
```

---

### Fibonacci Recursion Breakdown:
The Fibonacci sequence is defined as:
- **Base cases**:
  - `fib(0) = 0`
  - `fib(1) = 1`
- **Recursive case**:
  - `fib(n) = fib(n-1) + fib(n-2)`

When `n = 4`, the recursive calls proceed as follows:

---

### Call Tree for `fib(4)`:

```
fib(4)
├── fib(3)
│   ├── fib(2)
│   │   ├── fib(1) → 1
│   │   └── fib(0) → 0
│   └── fib(1) → 1
├── fib(2)
│   ├── fib(1) → 1
│   └── fib(0) → 0
```

### Step-by-Step Execution:
1. `fib(4)`:
   - Calls `fib(3)` and `fib(2)`.

2. **Evaluate `fib(3)`**:
   - Calls `fib(2)` and `fib(1)`.

3. **Evaluate `fib(2)` from `fib(3)`**:
   - Calls `fib(1)` → returns `1`.
   - Calls `fib(0)` → returns `0`.
   - `fib(2)` → `1 + 0 = 1`.

4. **Complete `fib(3)`**:
   - `fib(2)` → `1`.
   - `fib(1)` → `1`.
   - `fib(3)` → `1 + 1 = 2`.

5. **Evaluate `fib(2)` from `fib(4)`**:
   - Calls `fib(1)` → returns `1`.
   - Calls `fib(0)` → returns `0`.
   - `fib(2)` → `1 + 0 = 1`.

6. **Complete `fib(4)`**:
   - `fib(3)` → `2`.
   - `fib(2)` → `1`.
   - `fib(4)` → `2 + 1 = 3`.

---

### Output:
```
3
```

---

### Summary of Execution:
- The **call tree** grows exponentially for tree recursion, as each call branches into two further calls for `fib(n-1)` and `fib(n-2)`.
- The Fibonacci sequence for `n = 4` is computed as:
  - `fib(4) = fib(3) + fib(2)`
  - `fib(3) = fib(2) + fib(1)`
  - `fib(2) = fib(1) + fib(0)`
- The final result is `3`, which corresponds to the 4th Fibonacci number in 0-based indexing.

---