

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_10219 {
    static BigInteger[] factorials;
    static int total;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        factorials = new BigInteger[10000];
        factorials[0] = factorials[1] = BigInteger.ONE;
        for(int i=2; i<10000; i++){
            factorials[i] = new BigInteger(i+"").multiply(factorials[i-1]);
        }
        do{
            total = 0;
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println((factorials[n].divide(factorials[k].multiply(factorials[n-k]))+"").length());
        }while(sc.hasNext());

    }
//    
//    static BigInteger dp(int n, int k){
//        total++;
//        if(n<=0) return BigInteger.ZERO;
//        if(n<k) return BigInteger.ZERO;
//        if(n==k) return BigInteger.ONE;
//        if(k==1) return new BigInteger(n+"");
//        if(!memo[n][k].equals(negOne)) return memo[n][k];
//        memo[n][k] = dp(n-1, k).add(dp(n-1, k-1));
//        return memo[n][k];
//    }
}
