

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_10176 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger prime = new BigInteger("131071");
        do{
            String in = sc.nextLine();
            while(!in.contains("#")){
                in+=sc.nextLine();
            }
            in = in.substring(0, in.length()-1);
            in = in.replaceAll("[^01]", "");
            if(toDecimal(in).mod(prime).equals(BigInteger.ZERO))
                System.out.println("YES");
            else System.out.println("NO");
        }while(sc.hasNext());
    }
    
   static BigInteger toDecimal(String n){
       int l = n.length();
       BigInteger res = new BigInteger(n.charAt(0)+"");
       for(int i=1; i<l; i++){
           res = res.add(res).add(new BigInteger(n.charAt(i)+""));
       }
       return res;
   }
}
