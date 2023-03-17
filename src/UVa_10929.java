

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_10929 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        while(!n.equals("0")){
            BigInteger a = new BigInteger(n);
            if(a.mod(new BigInteger("11"))==BigInteger.ZERO) System.out.println(n + " is a multiple of 11.");
            else System.out.println(n + " is not a multiple of 11.");
            n = sc.nextLine();
        }
    }
}
