/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.math.BigInteger;

/**
 *
 * @author MarcDominic
 */
public class UVa_485 {
    public static void main(String[] args){
        BigInteger[] a = new BigInteger[1];
        BigInteger[] b = new BigInteger[2];
        BigInteger ten = new BigInteger("10").pow(60);
        BigInteger max = new BigInteger("-999");
        b[0] = new BigInteger("1");
        b[1] = new BigInteger("1");
        System.out.println("1\n1 1");
        do{
            a = new BigInteger[b.length+1];
            a[0] = new BigInteger("1");
            int aa = 0;
            for(int i=1; i<a.length-1; i++){
                a[i] = new BigInteger(b[aa].add(b[aa+1]).toString());
                aa++;
            }
            a[a.length-1] = new BigInteger("1");
            b = a;
            for(int i=0; i<b.length-1; i++){
                System.out.print(b[i]+" ");
                if(b[i].compareTo(max)==1)
                    max = b[i];
            }
            System.out.print("1\n");
        }while(max.compareTo(ten)<=0);
    }
}
