

import java.util.Scanner;

public class UVa_11715 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int c = 0;
        while(true){
            c++;
            int n = sc.nextInt();
            if(n==0) break;
            if(n==1){
                double u = sc.nextDouble();
                double v = sc.nextDouble();
                double t = sc.nextDouble();
                double a = (v-u)/t;
                double s = u*t + 0.5*a*t*t;
                System.out.printf("Case %d: %.3f %.3f\n", c, s, a);
            }
            else if(n==2){
                double u = sc.nextDouble();
                double v = sc.nextDouble();
                double a = sc.nextDouble();
                double t = (v-u)/a;
                double s = u*t + 0.5*a*t*t;
                System.out.printf("Case %d: %.3f %.3f\n", c, s, t);
            }
            else if(n==3){
                double u = sc.nextDouble();
                double a = sc.nextDouble();
                double s = sc.nextDouble();
                double v = Math.sqrt(u*u+2*a*s);
                double t = (v-u)/a;
                System.out.printf("Case %d: %.3f %.3f\n", c, v, t);
            }
            else if(n==4){
                double v = sc.nextDouble();
                double a = sc.nextDouble();
                double s = sc.nextDouble();
                double u = Math.sqrt(v*v-2*a*s);
                double t = (v-u)/a;
                System.out.printf("Case %d: %.3f %.3f\n", c, u, t);
            }
        }

    }
}
