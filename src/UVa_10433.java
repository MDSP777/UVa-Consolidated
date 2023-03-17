

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_10433 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger n;
        do{
            
            String a = sc.nextLine();
            n = new BigInteger(a);
            if(n.equals(BigInteger.ZERO)||n.equals(BigInteger.ONE)){
                System.out.println("Not an Automorphic number.");
                continue;
            }
            BigInteger s = n.multiply(n);
            String b = s.toString().substring(s.toString().length()-a.length(), s.toString().length());
            if(a.equals(b))
                System.out.println("Automorphic number of "+a.length()+"-digit.");
            else
                System.out.println("Not an Automorphic number.");
        }while(sc.hasNext());
    }
}
