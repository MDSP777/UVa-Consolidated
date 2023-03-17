

import java.util.Scanner;

public class UVa_12149 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] memo = new int[150];
        memo[1] = 1;
        for(int i=2; i<150; i++)
            memo[i] = i*i + memo[i-1];
        while(true){
            int n = sc.nextInt();
            if(n==0) break;
            System.out.println(memo[n]);
        }
    }
}
