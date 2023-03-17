

import java.util.Scanner;

public class UVa_12555 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        sc.nextLine();
        for(int x=1; x<=nC; x++){
            StringBuilder in = new StringBuilder(sc.nextLine());
            for(int i=0; i<in.length(); i++)
                if(in.charAt(i)<48 || in.charAt(i)>57) in.setCharAt(i, ' ');
            String[] split = in.toString().split(" ");
            double a = new Double(split[0]);
            double b = 0;
            for(int i=1; i<split.length; i++)
                if(!split[i].equals("")){
                    b = new Double(split[i]);
                    break;
                }
            double ans = a*0.5 + b*0.05;
            if(b%2==1) System.out.printf("Case %d: %.2f\n", x, ans);
            else if(Math.floor(ans)!=ans) System.out.printf("Case %d: %.1f\n", x, ans);
            else System.out.printf("Case %d: %.0f\n", x, ans);
        }
    }
}
