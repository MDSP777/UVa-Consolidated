

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_10193 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        sc.nextLine();
        for(int x=1; x<=nC; x++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            if(!new BigInteger(toDecimal(a)+"").gcd(new BigInteger(toDecimal(b)+"")).equals(BigInteger.ONE)) System.out.println("Pair #"+x+": All you need is love!");
            else System.out.println("Pair #"+x+": Love is not all you need!");
        }
    }
    
    static long toDecimal(String a){
        long total = a.charAt(0)-48;
        int l = a.length();
        for(int i=1; i<l; i++)
            total = total*2 + (a.charAt(i)-48);
        return total;
    }
}
