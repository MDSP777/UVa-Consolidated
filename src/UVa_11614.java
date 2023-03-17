

import java.util.Scanner;

public class UVa_11614 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int i=0; i<nC; i++){
            long s = sc.nextLong();
            long nRows = (long)((Math.sqrt(1+8*s)-1)/2);
            System.out.println(nRows);
        }
    }
}
