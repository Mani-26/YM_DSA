# **Head Recursion**

### Definition:
<p>If a recursive function calling itself and that recursive call is the first statement in the function then it’s known as Head Recursion. There’s no statement, no operation before the call. The function doesn’t have to process or perform any operation at the time of calling and all operations are done at returning time.</p>

---

### Code:
```java
public class HeadRecursion {
    public static void main(String[] args) {
        int n = 3;
        func(n);
    }

    static void func(int n) {
        if (n == 0) return;
        func(n - 1);
        System.out.println(n);
    }
}
```

---

### Program Flow:

1. **`main` method execution begins**:
   - `n = 3`
   - Calls `func(3)`.

2. **First call: `func(3)`**:
   - Condition `n == 0` is `false`.
   - Makes a recursive call to `func(2)`.

3. **Second call: `func(2)`**:
   - Condition `n == 0` is `false`.
   - Makes a recursive call to `func(1)`.

4. **Third call: `func(1)`**:
   - Condition `n == 0` is `false`.
   - Makes a recursive call to `func(0)`.

5. **Fourth call: `func(0)`**:
   - Condition `n == 0` is `true`.
   - Returns immediately without doing anything.

6. **Back to third call: `func(1)`**:
   - After the recursive call finishes, `System.out.println(1)` is executed.
   - Prints `1`.

7. **Back to second call: `func(2)`**:
   - After the recursive call finishes, `System.out.println(2)` is executed.
   - Prints `2`.

8. **Back to first call: `func(3)`**:
   - After the recursive call finishes, `System.out.println(3)` is executed.
   - Prints `3`.

---

### Output:
```
1
2
3
```

---

### Summary of Execution:
- Recursive calls are made in the order: `func(3) -> func(2) -> func(1) -> func(0)`.
- On returning from recursion, the printing happens in reverse order of the calls: `1, 2, 3`.

---