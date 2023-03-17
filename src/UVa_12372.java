

import java.util.Scanner;

public class UVa_12372 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=1; x<=nC; x++){
            int l = sc.nextInt();
            int w = sc.nextInt();
            int h = sc.nextInt();
            if(l>20 || w>20 || h>20) System.out.println("Case "+x+": bad");
            else System.out.println("Case "+x+": good");
        }
    }
}
