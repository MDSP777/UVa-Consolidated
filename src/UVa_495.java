

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_495 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger[] fibo = new BigInteger[10000];
        fibo[0] = BigInteger.ZERO;
        fibo[1] = fibo[2] = BigInteger.ONE;
        for(int i=3; i<10000; i++) fibo[i] = fibo[i-1].add(fibo[i-2]);
        do{
            int n = sc.nextInt();
            System.out.println("The Fibonacci number for "+n+" is "+fibo[n]);
        }while(sc.hasNext());
    }
}
