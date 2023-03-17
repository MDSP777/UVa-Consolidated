

import java.util.Scanner;

public class UVa_12898 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        StringBuilder out = new StringBuilder("");
        for(int x=1; x<=nC; x++){
            long a = sc.nextLong();
            long b = sc.nextLong();
            long or = ~and(~a, ~b);
            long and = and(a, b);
            out.append("Case "+x+": "+or+" "+and+"\n");
        }
        System.out.print(out);
    }
    
    static long and(long a, long b) {
        long x = a^b;
        long s = x>>1;

        while (s!=0) {
            x = x|s;
            s = s>>1;
        }
        return a&b&~x;
    }
}
