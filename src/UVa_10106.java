

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_10106 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(new BigInteger(sc.nextLine()).multiply(new BigInteger(sc.nextLine())));
        }while(sc.hasNext());

    }
}
