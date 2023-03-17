

import java.util.Scanner;

public class UVa_382 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("PERFECTION OUTPUT");
        while(true){
            int n = sc.nextInt();
            if(n==0) break;
            String in = n+"";
            while(in.length()!=5) in = " "+in;
            int sumOfFactors = 0;
            for(int i=1; i<=n/2; i++)
                if(n%i==0) sumOfFactors += i;
            String out2;
            if(sumOfFactors == n) out2 = "PERFECT";
            else if(sumOfFactors < n) out2 = "DEFICIENT";
            else out2 = "ABUNDANT";
            System.out.println(in+"  "+out2);
        }
        System.out.println("END OF OUTPUT");
    }
}
