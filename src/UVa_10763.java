

import java.util.Scanner;

public class UVa_10763 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            boolean flag = true;
            int n = sc.nextInt();
            if(n==0) break;
            int[] locs = new int[5000000];
            for(int i=0; i<n; i++){
                locs[sc.nextInt()]++;
                locs[sc.nextInt()]+=2;
            }
            for(int i=0; i<5000000; i++){
                if(locs[i]%3!=0){
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
        
    }
}
