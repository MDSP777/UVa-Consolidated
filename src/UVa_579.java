

import java.util.Scanner;

public class UVa_579 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        while(!n.equals("0:00")){
            String[] split = n.split(":");
            double h = Integer.parseInt(split[0]);
            if(h==12) h=0;
            double m = Integer.parseInt(split[1]);
            double hm = 0.5 * (60*h+m);
            double mm = 6*m;
            double ans = hm-mm;
            if(ans<0) ans*=-1;
            if(ans>180)
                ans=360-ans;
            System.out.printf("%.3f\n", ans);
            n = sc.nextLine();
        }
    }
}
