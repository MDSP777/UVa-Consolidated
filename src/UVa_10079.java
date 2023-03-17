

import java.util.Scanner;

public class UVa_10079 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            long in = sc.nextLong();
            if(in<0) break;
            System.out.println((in*in+in+2)/2);
        }

    }
}
