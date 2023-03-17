

import java.util.Scanner;

public class UVa_10424 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            String a = sc.nextLine();
            String b = sc.nextLine();
            a = a.toLowerCase();
            b = b.toLowerCase();
            long sum1 = 0;
            long sum2 = 0;
            int aa = a.length();
            int bb = b.length();
            for(int i=0; i<aa; i++)if(a.charAt(i)>=97&&a.charAt(i)<=122) sum1 += a.charAt(i)-96;
            for(int i=0; i<bb; i++)if(b.charAt(i)>=97&&b.charAt(i)<=122) sum2 += b.charAt(i)-96;
            double lol = comp(sum1)/comp(sum2);
            if(lol>1) lol = 1/lol;
            lol*=100;
            System.out.printf("%.2f", lol);
            System.out.println(" %");
        }while(sc.hasNext());
    }
    
    public static double comp(long n){
        if(n<10) return n;
        String nn = Long.toString(n);
        int a = nn.length();
        long sum = 0;
        for(int i=0; i<a; i++) sum += nn.charAt(i)-48;
        return comp(sum);
    }
}
