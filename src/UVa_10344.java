

import java.util.Scanner;

public class UVa_10344 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            boolean[] visited = new boolean[5];
            int[] terms = new int[5];
            boolean flag = false;
            for(int i=0; i<5; i++){
                terms[i] = sc.nextInt();
                if(terms[i]!=0) flag = true;
            }
            if(!flag) break;
            if(dp(terms, visited, 0, 0)) System.out.println("Possible");
            else System.out.println("Impossible");
        }
    }
    
    static boolean dp(int[] terms, boolean[] visited, int nTerms, int ans){
       if(nTerms==5){
           if(ans==23) return true;
           else return false;
       }
       else{
           boolean res = false;
           for(int i=0; i<5; i++){
               if(!visited[i]){
                   visited[i] = true;
                   if(nTerms==0)
                        res = (dp(terms, visited, nTerms+1, terms[i]));
                   else res = (dp(terms, visited, nTerms+1, ans+terms[i]) ||
                                dp(terms, visited, nTerms+1, ans-terms[i]) ||
                                dp(terms, visited, nTerms+1, ans*terms[i]));
                   if(res) return true;
                   visited[i] = false;
               }
           }
           return false;
       }
    }
}
