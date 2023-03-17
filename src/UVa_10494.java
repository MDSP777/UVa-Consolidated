

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_10494 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            BigInteger a = new BigInteger(sc.next());
            String o = sc.next().trim();
            BigInteger b = new BigInteger(sc.next());
            if(o.equals("/"))
                System.out.println(a.divide(b));
            else
                System.out.println(a.mod(b));
        }while(sc.hasNext());

    }
}
