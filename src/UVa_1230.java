

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_1230 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int i=0; i<nC; i++){
            System.out.println(new BigInteger(sc.next()).modPow(new BigInteger(sc.next()), new BigInteger(sc.next())));
        }
        sc.next();
    }
}
