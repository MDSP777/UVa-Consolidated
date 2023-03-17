

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_10814 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt(); sc.nextLine();
        for(int i=0; i<nC; i++){
            BigInteger a = sc.nextBigInteger();
            sc.next();
            BigInteger b = sc.nextBigInteger();
            BigInteger g = a.gcd(b);
            System.out.println(a.divide(g)+" / "+b.divide(g));
        }
    }
}
