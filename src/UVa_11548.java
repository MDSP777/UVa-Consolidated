

import java.util.Scanner;

public class UVa_11548 {
    static int[][] memo;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int xx=0; xx<nC; xx++){
            int best = 0;
            int nWords = sc.nextInt();
            String[] words = new String[nWords];
            for(int i=0; i<nWords; i++) words[i] = sc.next();
            
            int[][] dpAns = new int[nWords][nWords];
            for(int i=0; i<nWords; i++)
                for(int j=0; j<nWords; j++){
                    if(i==j) dpAns[i][j] = Integer.MIN_VALUE;
                    else dpAns[i][j] = -1;
                }
            
            for(int i=0; i<nWords; i++){
                for(int j=0; j<nWords; j++){
                    if(i!=j){
                        if(dpAns[i][j]==-1){
                            dpAns[i][j] = dpAns[j][i] = getBestAlignment(words[i], words[j]); 
                            best = Math.max(best, dpAns[i][j]);
                        }
                    }
                }
            }
            System.out.println(best);
        }

    }
    
    static int getBestAlignment(String a, String b){
        if(a.length()<b.length()){
            String temp = a;
            a = b;
            b = temp;
        }
        int aLen = a.length();
        int bLen = b.length();
        int best = 0;
        int offest = -1*bLen;
        for(int i=offest; i<aLen; i++){
            int total = 0;
            for(int j=0; j<bLen; j++){
                int aIndex = j+i;
                if(aIndex>=0 && aIndex<aLen){
                    if(a.charAt(aIndex)==b.charAt(j)) total++;
                }
            }
            best = Math.max(total, best);
        }
        return best;
    }
}
