

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_12455 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            boolean found = false;
            int desiredLength = sc.nextInt();
            int nBars = sc.nextInt();
            int smallest = Integer.MAX_VALUE;
            int[] bars = new int[nBars];
            int total = 0;
            ArrayList<Integer> subsetSums = new ArrayList();
            for(int i=0; i<nBars; i++){
                bars[i] = sc.nextInt();
                total+=bars[i];
                smallest = Math.min(smallest, bars[i]);
            }
            if(desiredLength==0) System.out.println("YES");
            else if(desiredLength<smallest) System.out.println("NO");
            else{
                boolean[] memo = new boolean[total+1];
                for(int i=0; i<nBars; i++){
                    int curTerm = bars[i];
                    if(curTerm==desiredLength){
                        found = true;
                        break;
                    }
                    int l = subsetSums.size();
                    for(int j=0; j<l; j++){
                        int prospect = subsetSums.get(j)+curTerm;
                        if(prospect==desiredLength){
                            found = true;
                            break;
                        }
                        if(!memo[prospect]){
                            subsetSums.add(prospect);
                            memo[prospect] = true;
                        }
                    }
                    if(found) break;
                    if(!memo[curTerm]){
                        subsetSums.add(curTerm);
                        memo[curTerm] = true;
                    }
                }
                if(found) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
