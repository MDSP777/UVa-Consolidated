

import java.util.Scanner;

public class UVa_10013 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            int m = sc.nextInt();
            int[] a = new int[m];
            int[] b = new int[m];
            int[] ans = new int[m];
            StringBuilder out = new StringBuilder();
            for(int i=0; i<m; i++){
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
            }
            
            for(int i=m-1; i>=0; i--){
                ans[i] += a[i]+b[i];
                if(ans[i]>9){
                    ans[i-1] += ans[i]/10;
                    ans[i]%=10;
                }
                out.append(ans[i]);
            }
            out.reverse();
            System.out.println(out);
            if(x!=nC-1) System.out.println();
        }

    }
}
