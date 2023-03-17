/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author MarcDominic
 */
public class UVa_10323 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            int n = sc.nextInt();
            if(n<0&&-n%2==1) System.out.println("Overflow!");
            else if(n<0&&-n%2==0) System.out.println("Underflow!");
            else fac(n);
        }while(sc.hasNext());
    }
    
    public static void fac(int n){
        BigInteger a = new BigInteger(Integer.toString(n));
        do{
            n--;
            a = a.multiply(new BigInteger(Integer.toString(n)));
            if(a.compareTo(new BigInteger("6227020800"))==1){
                System.out.println("Overflow!");
                return;
            }
        }while(n>1);
        if(a.compareTo(new BigInteger("10000"))==-1)
            System.out.println("Underflow!");
        else
            System.out.println(a.toString());
    }
}
