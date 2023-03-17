

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_623 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger[] fac = new BigInteger[1001];
        fac[0] = fac[1] = BigInteger.ONE;
        for(int i=2; i<=1000; i++)
            fac[i] = new BigInteger(i+"").multiply(fac[i-1]);
        do{
            int n = sc.nextInt();
            System.out.println(n+"!");
            System.out.println(fac[n]);
        }while(sc.hasNext());
    }
}
