

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_526 {
    static int[][] memo;
    static ArrayList<String> list;
    static String a;
    static String b;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            a = sc.nextLine();
            b = sc.nextLine();
            memo = new int[a.length()+1][b.length()+1];
            for(int i=0; i<=a.length(); i++)
                for(int j=0; j<=b.length(); j++) memo[i][j] = -1;
            list = new ArrayList();
            int ans = dp(a, b);
            System.out.println(ans);
//            for(int i=0; i<=a.length(); i++){
//                for(int j=0; j<=b.length(); j++){
//                    System.out.print(memo[i][j]+" ");
//                }
//                System.out.println("");
//            }
//            int i = a.length();
//            int j = b.length();
//            for(int ctr=0; ctr<ans; ctr++){
//                int cur = memo[i][j];
//                int best = memo[i-1][j-1];
//                String command = "Replace "+i+","+b.charAt(j);
//                int temp = memo[]
//            }
        }while(sc.hasNext());
    }

    private static int dp(String a, String b) {
        if(a.equals(b)) return 0;
        if(a.equals("")) return b.length();
        if(b.equals("")) return a.length();
        if(memo[a.length()][b.length()]!=-1) return memo[a.length()][b.length()];
        
        int best = Integer.MAX_VALUE;
        if(a.charAt(a.length()-1) == b.charAt(b.length()-1)){
            int temp = dp(a.substring(0, a.length()-1), b.substring(0, b.length()-1));
            if(temp<best){
                best = temp;
            }
        }
        else{
            int temp = 1+dp(a.substring(0, a.length()-1)+b.charAt(b.length()-1), b);
            if(temp<best){
                best = temp;
                
            }
            temp = 1+dp(a.substring(0, a.length()-1), b);
            if(temp<best){
                best = temp;
                
            }
        }
        memo[a.length()][b.length()] = best;
        return best;
    }
}
