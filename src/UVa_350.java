

import java.util.Scanner;

public class UVa_350 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = 1;
        while(true){
            int z = sc.nextInt();
            int i = sc.nextInt();
            int m = sc.nextInt();
            int l = sc.nextInt();
            
            if(z==0 && i==0 && m==0 && l==0) break;
            
            int[] position = new int[10000];
            boolean[] visited = new boolean[10000];
            
            position[l] = 0;
            visited[l] = true;
            int nGen = 1;
            int ans;
            while(true){
                l = (z*l+i)%m;
                if(visited[l]){
                    ans = nGen - position[l];
                    break;
                } else {
                    visited[l] = true;
                    position[l] = nGen++;
                }
            }
            
            System.out.println("Case "+nC+++": "+ans);
        }

    }
}
