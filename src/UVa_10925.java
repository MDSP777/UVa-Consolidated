

import java.math.BigInteger;
import java.util.*;

public class UVa_10925 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 1;
        while(true){
            int nItems = sc.nextInt();
            int nFriends = sc.nextInt();
            if(nItems==0 && nFriends==0) break;
            BigInteger total = BigInteger.ZERO;
            for(int i=0; i<nItems; i++){
                total = total.add(new BigInteger(sc.next()));
            }
            System.out.println("Bill #"+n+++" costs "+total+": each friend should pay "+total.divide(new BigInteger(nFriends+""))+"\n");
        }
    }
}