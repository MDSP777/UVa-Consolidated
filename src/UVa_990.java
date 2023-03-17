

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_990 {
    static long[][] memo;
    static Treasure[] treasures;
    static int w;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            int t = sc.nextInt();
            w = sc.nextInt();
            int nTreasures = sc.nextInt();
            treasures = new Treasure[nTreasures];
            
            for(int i=0; i<nTreasures; i++){
                treasures[i] = new Treasure(sc.nextInt(), sc.nextInt());
            }
            
            memo = new long[t+1][nTreasures+1];
            for(int i=0; i<=t; i++){
                for(int j=0; j<=nTreasures; j++){
                    memo[i][j] = -1;
                }
            }
            for(int i=0; i<=t; i++){
                memo[i][0] = 0;
            }
            for(int i=0; i<=nTreasures; i++){
                memo[0][i] = 0;
            }
            
            long ans = dp(t, nTreasures);
            System.out.println(ans);
            ArrayList<Treasure> got = new ArrayList<>();
            
            int curI = t;
            int curJ = nTreasures;
            for(int i=nTreasures-1; i>=0; i--){
                int travelTime = 3*w*treasures[i].depth;
                if(curI-travelTime>=0 && memo[curI][curJ]-memo[curI-travelTime][curJ-1]==treasures[i].val){
                    got.add(treasures[i]);
                curI = curI-travelTime;
                }
                curJ--;
            }
            System.out.println(got.size());
            for(int i=got.size()-1; i>=0; i--){
                System.out.println(got.get(i));
            }
            if(sc.hasNext()) System.out.println("");
        }while(sc.hasNext());

    }
    
    static long dp(int timeLeft, int nTreasures){
        if(timeLeft<=0 || nTreasures==0) return 0;
        if(memo[timeLeft][nTreasures]!=-1){
            return memo[timeLeft][nTreasures];
        }
        
        long best = dp(timeLeft, nTreasures-1);
        if(timeLeft>=3*w*treasures[nTreasures-1].depth){
            best = Math.max(best, dp(timeLeft-3*w*treasures[nTreasures-1].depth, nTreasures-1)+treasures[nTreasures-1].val);
        }
        memo[timeLeft][nTreasures] = best;
        return best;
    }
    
    static class Treasure{
        int depth;
        int val;
        
        public Treasure (int d, int v){
            depth = d;
            val = v;
        }
        
        public String toString(){
            return depth+" "+val;
        }
    }
}
