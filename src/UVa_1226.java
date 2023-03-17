

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_1226 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int i=0; i<nC; i++){
            BigInteger n = new BigInteger(sc.next());
            System.out.println(new BigInteger(sc.next()).mod(n));
        }
    }
}
