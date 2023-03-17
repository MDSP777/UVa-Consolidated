

import java.util.Scanner;

public class UVa_10533 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int i=1; i<=nC; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int total = 0;
            for(int x=a; x<=b; x++){
                if(prime(x) && digitprime(x))
                    total++;
            }
            System.out.println(total);
        }
    }
    
    public static boolean prime(int x){
        for(int i=2; i<x; i++)
            if(x%i==0) return false;
        return true;
    }
    
    public static boolean digitprime(int x){
        String n = Integer.toString(x);
        int total = 0;
        for(int i=0; i<n.length(); i++){
            total += Integer.parseInt(n.charAt(i)+"");
        }
        if(prime(total)) return true;
        return false;
    }
}
