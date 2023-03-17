

import java.util.Scanner;

public class UVa_10696 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n!=0){
            System.out.println("f91("+n+") = "+f91(n));
            n = sc.nextInt();
        }
    }
    
    public static int f91(int n){
        if(n>=101) return n-10;
        return 91;
    }
}
