

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_424 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger total = BigInteger.ZERO;
        while(a.compareTo(BigInteger.ZERO)!=0){
            total = total.add(a);
            a = sc.nextBigInteger();
        }
        System.out.println(total);
    }
}
