

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_10070 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger four = new BigInteger("4");
        BigInteger oneHundred = new BigInteger("100");
        BigInteger fourHundred = new BigInteger("400");
        BigInteger fifteen = new BigInteger("15");
        BigInteger fiftyFive = new BigInteger("55");
        do{
            BigInteger year = new BigInteger(sc.next());
            boolean leap = false;
            boolean hulu = false;
            boolean bulu = false;
            
            if((year.mod(four).equals(BigInteger.ZERO) && !year.mod(oneHundred).equals(BigInteger.ZERO)) 
                    || year.mod(fourHundred).equals(BigInteger.ZERO)) leap = true;
            if(year.mod(fifteen).equals(BigInteger.ZERO)) hulu = true;
            if(leap && year.mod(fiftyFive).equals(BigInteger.ZERO)) bulu = true;
            
            if(!leap && !hulu && !bulu) System.out.println("This is an ordinary year.");
            else {
                if(leap) System.out.println("This is leap year.");
                if(hulu) System.out.println("This is huluculu festival year.");
                if(bulu) System.out.println("This is bulukulu festival year.");
            }
            
            if(sc.hasNext()) System.out.println("");
        }while(sc.hasNext());
    }
}
