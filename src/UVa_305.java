

import java.util.Scanner;

public class UVa_305 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        while(true){
//            int n = sc.nextInt();
//            if(n==0) break;
//            int offset = n;
//            int nPeople = n*2;
//            while(true){
//                boolean valid = true;
//                boolean[] dead = new boolean[nPeople];
//                int attempt = offset%nPeople;
//                if(attempt<n){
//                    offset++;
//                    continue;
//                }
//                for(int i=1; i<n; i++){
//                    dead[attempt] = true;
//                    for(int j=0; j<=offset; j++){
//                        attempt++;
//                        attempt%=nPeople;
//                        if(dead[attempt]) j--;
////                        System.out.print(attempt + " ");
//                    }
////                    System.out.println();
//                    if(attempt<n){
//                        valid = false;
//                        break;
//                    }
//                }
//                if(valid) break;
//                offset++;
//            }
//            System.out.println(offset+1);
//        }

        int[] ans = new int[14];
        ans[1] = 2;
        ans[2] = 7;
        ans[3] = 5;
        ans[4] = 30;
        ans[5] = 169;
        ans[6] = 441;
        ans[7] = 1872;
        ans[8] = 7632;
        ans[9] = 1740;
        ans[10] = 93313;
        ans[11] = 459901;
        ans[12] = 1358657;
        ans[13] = 2504881;
        while(true){
            int n = sc.nextInt();
            if(n==0) break;
            System.out.println(ans[n]);
        }
    }
}
