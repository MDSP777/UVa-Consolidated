

import java.util.Scanner;

public class UVa_12502 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int ans = c*(a+(a-b))/(a+b);
            if(ans<=0) System.out.println("0");
            else System.out.println(ans);
        }
    }
}
