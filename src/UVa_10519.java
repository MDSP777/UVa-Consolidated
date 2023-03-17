

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_10519 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            BigInteger n = new BigInteger(sc.next());
            if(n.equals(BigInteger.ZERO)) System.out.println("1");
            else System.out.println(n.multiply(n).subtract(n).add(new BigInteger("2")));
        }while(sc.hasNext());

    }
}
