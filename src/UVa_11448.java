

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_11448 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int i=0; i<nC; i++){
            System.out.println(new BigInteger(sc.next()).subtract(new BigInteger(sc.next())));
        }

    }
}
