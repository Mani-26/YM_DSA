package Recursion.DirectRecursion;

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
