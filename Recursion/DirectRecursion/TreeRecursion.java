package Recursion.DirectRecursion;

public class TreeRecursion {
    public static void main(String[] args) {
        int res =fib(5);
        System.out.println(res);
    }
    static int fib(int n){
        if(n==0||n==1) return n;
        return fib(n-1)+fib(n-2);
    }
}
