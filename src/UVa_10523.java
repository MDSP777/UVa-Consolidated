

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_10523 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            int n = sc.nextInt();
            int a = sc.nextInt();
            BigInteger A = new BigInteger(a+"");
            BigInteger N = new BigInteger(n+"");
            BigInteger total = N.multiply(A);
            for(int i=n-1; i>=1; i--){
                N = N.subtract(BigInteger.ONE);
                total = total.add(N);
                total = total.multiply(A);
            }
            System.out.println(total);
        }while(sc.hasNext());

    }
}
