

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_374 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            System.out.println(new BigInteger(a+"").modPow(new BigInteger(b+""), new BigInteger(c+"")));
        }while(sc.hasNext());
    }
}
