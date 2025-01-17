# **Tail Recursion**

### Definition:
<p>
If a recursive function calling itself and that recursive call is the last statement in the function then it’s known as Tail Recursion. After that call the recursive function performs nothing. The function has to process or perform any operation at the time of calling and it does nothing at returning time.
</p>

---

### Code:
```java
public class TailRecursion {
    public static void main(String[] args) {
        func(3);
    }

    static void func(int n) {
        if (n == 0) return;
        System.out.println(n);
        func(--n);
    }
}
```

---

### Program Flow:

1. **`main` method execution begins**:
   - Calls `func(3)`.

2. **First call: `func(3)`**:
   - Condition `n == 0` is `false`.
   - Executes `System.out.println(3)`:
     - Prints `3`.
   - Decrements `n` (pre-decrement, so `n = 2`) and calls `func(2)`.

3. **Second call: `func(2)`**:
   - Condition `n == 0` is `false`.
   - Executes `System.out.println(2)`:
     - Prints `2`.
   - Decrements `n` (pre-decrement, so `n = 1`) and calls `func(1)`.

4. **Third call: `func(1)`**:
   - Condition `n == 0` is `false`.
   - Executes `System.out.println(1)`:
     - Prints `1`.
   - Decrements `n` (pre-decrement, so `n = 0`) and calls `func(0)`.

5. **Fourth call: `func(0)`**:
   - Condition `n == 0` is `true`.
   - Returns immediately without doing anything.

6. **Backtracking**:
   - Since the recursive call was the last operation in the function, no additional operations are performed as the stack unwinds.

---

### Output:
```
3
2
1
```

---

### Summary of Execution:
- Recursive calls are made in the order: `func(3) -> func(2) -> func(1) -> func(0)`.
- Printing happens **before** the recursive calls in each function invocation.
- The numbers are printed in descending order: `3, 2, 1`.

---