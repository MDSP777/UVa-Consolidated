

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_465 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            String n = sc.nextLine();
            String[] split = n.split(" ");
            BigInteger bound = new BigInteger(Integer.MAX_VALUE+"");
            BigInteger a = new BigInteger(split[0]);
            BigInteger b = new BigInteger(split[2]);
            System.out.println(n);
            if(a.compareTo(bound)>0) System.out.println("first number too big");
            if(b.compareTo(bound)>0) System.out.println("second number too big");
            if(split[1].equals("+"))
                if(a.add(b).compareTo(bound)>0) System.out.println("result too big");
            if(split[1].equals("*"))
                if(a.multiply(b).compareTo(bound)>0) System.out.println("result too big");
        }while(sc.hasNext());

    }
}
