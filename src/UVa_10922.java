

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_10922 {
    static long total;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        BigInteger n = new BigInteger(a);
        while(n.compareTo(BigInteger.ZERO)!=0){
            total = 0;
            if(a.equals("9")) System.out.println("9 is a multiple of 9 and has 9-degree 1.");
            else{
                shit(n);
                total--;
                if(total!=-2)
                    System.out.println(a+" is a multiple of 9 and has 9-degree "+total+".");
                else System.out.println(a+" is not a multiple of 9.");
            }
            a = sc.nextLine();
            n = new BigInteger(a);
        }
    }
    
    public static void shit(BigInteger n){
        total++;
        if(n.compareTo(new BigInteger("10"))<0){
            if(n.compareTo(new BigInteger("9"))!=0)
                total = -1;
        }
        else{
            String nn = n.toString();
            int l = nn.length();
            long total = 0;
            for(int i=0; i<l; i++)
                total += nn.charAt(i)-48;
            shit(new BigInteger(String.valueOf(total)));
        }
    }
}
