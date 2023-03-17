

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_11830 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            String d = sc.next();
            String s = sc.next();
            if(d.equals("0") && s.equals("0")) break;
            s = s.replaceAll(d, "");
            if(s.equals("")) s = "0";
            System.out.println(new BigInteger(s));
        }

    }
}
