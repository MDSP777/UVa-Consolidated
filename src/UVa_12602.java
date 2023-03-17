

import java.util.Scanner;

public class UVa_12602 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        sc.nextLine();
        int a, b;
        for(int i=0; i<nC; i++){
            a=b=0;
            String s = sc.nextLine();
            b = Integer.parseInt(s.substring(4));
            a+=26*26*(s.charAt(0)-65);
            a+=26*(s.charAt(1)-65);
            a+=(s.charAt(2)-65);
            if(Math.abs(a-b)<=100)
                System.out.println("nice");
            else System.out.println("not nice");
        }
    }
}
