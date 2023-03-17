

import java.util.Scanner;

public class UVa_12468 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        while(!(a==-1&&b==-1)){
            int r = Math.abs(a-b);
            if(r>50) r = 100-r;
            System.out.println(r);
            a = sc.nextInt();
            b = sc.nextInt();
        }
    }
}
