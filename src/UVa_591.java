

import java.util.Scanner;

public class UVa_591 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int set = 1;
        while(true){
            int n = sc.nextInt();
            if(n==0) break;
            int[] blocks = new int[n];
            int total = 0;
            for(int i=0; i<n; i++){
                blocks[i] = sc.nextInt();
                total+=blocks[i];
            }
            total/=n;
            int res = 0;
            for(int i=0; i<n; i++)
                if(blocks[i]>total) res+=blocks[i]-total;
            System.out.println("Set #"+set+"\nThe minimum number of moves is "+res+".\n");
            set++;
        }

    }
}
