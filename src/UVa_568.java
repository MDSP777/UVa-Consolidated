

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_568 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger[] facts = new BigInteger[10000];
        facts[1] = BigInteger.ONE;
        for(int i=2; i<10000; i++)
            facts[i] = new BigInteger(i+"").multiply(facts[i-1]);
        do{
            int n = sc.nextInt();
            String in = n+"";
            while(in.length()<5)
                in = " "+in;
            System.out.println(in+" -> "+lastDigit(facts[n].toString()));
        }while(sc.hasNext());
    }
    
    static char lastDigit(String a){
        int l = a.length()-1;
        for(int i=l; i>=0; i--)
            if(a.charAt(i)!='0') return a.charAt(i);
        return '~';
    }
}
