

import java.util.Scanner;

public class UVa_11059 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = 1;
        do{
            int nterms = sc.nextInt();
            long total = 1;
            for(int i=0; i<nterms; i++){
                int s = sc.nextInt();
                if(s>0) total *= s;
            }
            System.out.println("Case #" + t++ + ": The maximum product is " + total + ".");
        }while(sc.hasNext());

    }
}
