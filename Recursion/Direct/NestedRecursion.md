# **Nested Recursion**

### Definition:
<p> In this recursion, a recursive function will pass the parameter as a recursive call. That means “recursion inside recursion”. Let see the example to understand this recursion.</p>

---

### Code:
```java
public class NestedRecursion { 
    static int fun(int n) { 
        if (n > 100) 
            return n - 10; 
        return fun(fun(n + 11)); 
    } 
    public static void main(String args[]) { 
        int r; 
        r = fun(95); 
        System.out.print(" " + r); 
    } 
}
```

---

### Key Observations:
1. The function `fun(n)` checks:
   - **Base Case**: If `n > 100`, it returns `n - 10`.
   - **Recursive Case**: If `n <= 100`, it calls itself with `fun(n + 11)` as the argument.

2. Since the recursion is nested, the recursive calls branch deeply before resolving. The nested calls keep increasing `n` until it exceeds `100`, after which the base case is triggered, and the recursion starts resolving.

---

### Step-by-Step Execution:
1. **Initial Call**: `fun(95)`
   - `95 <= 100`, so it makes a nested call: `fun(fun(95 + 11)) = fun(fun(106))`.

2. **Evaluate `fun(106)`**:
   - `106 > 100`, so the base case is triggered: `fun(106)` returns `106 - 10 = 96`.

3. **Resolve `fun(fun(106))`**:
   - Now, we evaluate `fun(96)`.

4. **Evaluate `fun(96)`**:
   - `96 <= 100`, so it makes another nested call: `fun(fun(96 + 11)) = fun(fun(107))`.

5. **Evaluate `fun(107)`**:
   - `107 > 100`, so the base case is triggered: `fun(107)` returns `107 - 10 = 97`.

6. **Resolve `fun(fun(107))`**:
   - Now, we evaluate `fun(97)`.

7. **Repeat the Process**:
   - This process continues for `fun(97)`, `fun(98)`, `fun(99)`, and `fun(100)`, each triggering nested calls until the base case is reached.

8. **Base Case Stabilization**:
   - Once `n > 100`, the recursion starts resolving:
     - `fun(101)` returns `91`.
     - All subsequent nested calls resolve to `91`.

---

### Final Result:
- The recursion finally stabilizes at `91` for all inputs less than or equal to `100`.

---

### Output:
```
 91
```

---

### Summary of Execution:
- The function performs deeply nested recursion, repeatedly increasing `n` by `11` until `n > 100`.
- Once the base case is reached, the recursion stabilizes, and the final result is `91` for all inputs `n <= 100`.

---