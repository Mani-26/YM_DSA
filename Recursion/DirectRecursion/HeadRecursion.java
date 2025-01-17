package Recursion.DirectRecursion;

public class HeadRecursion {
    public static void main(String[] args) {
        int n=3;
        func(n);
    }
    static void func(int n){
        if(n==0) return;
        func(n-1);
        System.out.println(n);
    }
}
