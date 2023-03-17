

import java.util.Scanner;

public class UVa_11689 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt(), a, b, c, total, drank;
        for(int i=0; i<cases; i++){
            drank=0;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            total = a+b;
            while(total>0){
                total-=c;
                if(total>=0){
                    drank++;
                    total++;
                }
            }
            System.out.println(drank);
        }
    }
}
