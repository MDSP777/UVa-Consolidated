

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_10220 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger[] fact = new BigInteger[1050];
        fact[0] = fact[1] = BigInteger.ONE;
        for(int i=2; i<1050; i++)
            fact[i] = new BigInteger(i+"").multiply(fact[i-1]);
        do{
            System.out.println(sum(fact[sc.nextInt()].toString()));
        }while(sc.hasNext());
    }
    
    static long sum(String n){
        long total = n.charAt(0)-48;
        int l = n.length();
        for(int i=1; i<l; i++)
            total += (n.charAt(i)-48);
        return total;
    }
}
