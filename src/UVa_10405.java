

import java.util.Scanner;

public class UVa_10405 {
//    static long[][] memo;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            String a = sc.nextLine();
            String b = sc.nextLine();
//            memo = new long[a.length()+1][b.length()+1];
//            for(int i=0; i<=a.length(); i++)
//                for(int j=0; j<=b.length(); j++) 
//                    if(i==0||j==0) memo[i][j] = 0; 
//                    else memo[i][j] = -1;
            System.out.println(lcs2(a, b));
        }while(sc.hasNext());

    }

//    private static long lcs(String a, String b) {
//        if(memo[a.length()][b.length()]!=-1)
//            return memo[a.length()][b.length()];
//        if(a.length()==0||b.length()==0)
//            return 0;
//        if(a.charAt(a.length()-1)==b.charAt(b.length()-1)){
//            memo[a.length()][b.length()] = lcs(a.substring(0, a.length()-1), b.substring(0, b.length()-1))+1;
//            return memo[a.length()][b.length()];
//        }
//        else{
//            memo[a.length()][b.length()] = Math.max(lcs(a, b.substring(0, b.length()-1)), lcs(a.substring(0, a.length()-1), b));
//            return memo[a.length()][b.length()];
//        }
//    }
    
    private static long lcs2(String a, String b){
        long[][] memo = new long[a.length()+1][b.length()+1];
        for(int i=0; i<=a.length(); i++)
            for(int j=0; j<=b.length(); j++) 
                if(i==0||j==0) memo[i][j] = 0; 
                else {
                    if(a.charAt(i-1)==b.charAt(j-1)) memo[i][j] = memo[i-1][j-1]+1;
                    else memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
                }
        return memo[a.length()][b.length()];
    }
}
