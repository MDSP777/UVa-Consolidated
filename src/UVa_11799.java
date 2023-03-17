

import java.util.Scanner;

public class UVa_11799{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt(), m, n, max;
        for(int i=1; i<=cases; i++){
            max=-999;
            n = sc.nextInt();
            for(int j=0; j<n; j++){
                m = sc.nextInt();
                if(m>max)
                    max=m;
            }
            System.out.println("Case "+i+": "+max);
        }
    }
}