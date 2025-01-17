package Recursion.DirectRecursion;

public class TailRecursion {
    public static void main(String[] args) {
        func(3);
    }
    static void func(int n){
        if(n==0) return;
        System.out.println(n);
        func(--n);
    }
}
