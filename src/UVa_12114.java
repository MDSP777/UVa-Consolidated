

import java.util.Scanner;

public class UVa_12114 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double b = sc.nextDouble(), s = sc.nextDouble();
        int cases = 1;
        while(b!=0||s!=0){
            if(b==1)
                System.out.println("Case "+cases+": :-\\");
            else if(b<=s)
                System.out.println("Case "+cases+": :-|");
            else
                System.out.println("Case "+cases+": :-(");
            cases++;
            b = sc.nextDouble();
            s = sc.nextDouble();
        }
    }   
}
