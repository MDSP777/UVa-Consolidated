

import java.util.Scanner;

public class UVa_11332 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n==0) break;
            else System.out.println(f(n));
        }
    }
    
    static int f(int n){
        if(n<10) return n;
        else{
            int total=0;
            while(n>0){
                total+=n%10;
                n/=10;
            }
            return f(total);
        }
    }
}
