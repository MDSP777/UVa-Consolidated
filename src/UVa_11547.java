

import java.math.BigInteger;
import java.util.Scanner;

/* Automatic Answer */
public class UVa_11547 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<nC; i++){
            BigInteger n = new BigInteger(sc.nextLine());
            n = n.multiply(new BigInteger("567"));
            n = n.divide(new BigInteger("9"));
            n = n.add(new BigInteger("7492"));
            n = n.multiply(new BigInteger("235"));
            n = n.divide(new BigInteger("47"));
            n = n.subtract(new BigInteger("498"));
            System.out.println(n.toString().charAt(n.toString().length()-2));
        }

    }
}
