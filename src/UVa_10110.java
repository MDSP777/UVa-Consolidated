

import java.util.Scanner;

public class UVa_10110 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        while(n!=0){
            double root = Math.sqrt(n);
            if(root == Math.floor(root)) System.out.println("yes");
            else System.out.println("no");
            n = sc.nextLong();
        }
    }
}
