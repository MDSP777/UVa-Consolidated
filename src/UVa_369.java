

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_369 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger[] fact = new BigInteger[110];
        fact[0] = fact[1] = BigInteger.ONE;
        for(int i=2; i<110; i++)
            fact[i] = new BigInteger(i+"").multiply(fact[i-1]);
        while(true){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(n==0 && m==0) break;
            BigInteger out = fact[n].divide(fact[n-m].multiply(fact[m]));
            System.out.println(n+" things taken "+m+" at a time is "+out+" exactly.");
        }
    }
}
