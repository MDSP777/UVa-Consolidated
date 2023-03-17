

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_10579 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input;
        BigInteger a, b, c;
        do{
            a = new BigInteger("1");
            b = new BigInteger("1");
            c = new BigInteger("1");
            input = sc.nextInt();
            for(int i=2; i<input; i++){
                c = a.add(b);   
                a=b;
                b=c;
            }
            System.out.println(c);
        }while(sc.hasNext());
    }
}
