

import java.util.Arrays;
import java.util.Scanner;

public class UVa_11292 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int nHeads = sc.nextInt();
            int nKnights = sc.nextInt();
            if(nHeads==0 && nKnights==0) break;
            if(nHeads>nKnights){
                System.out.println("Loowater is doomed!");
                for(int i=0; i<nHeads+nKnights; i++) sc.nextInt();
                continue;
            }
            int[] heads = new int[nHeads];
            int[] knights = new int[nKnights];
            for(int i=0; i<nHeads; i++) heads[i] = sc.nextInt();
            for(int i=0; i<nKnights; i++) knights[i] = sc.nextInt();
            Arrays.sort(heads);
            Arrays.sort(knights);
            boolean isDoomed = false;
            int total = 0;
            for(int i=0; i<heads.length; i++){
                if(heads[i]>knights[knights.length-1]){
                    isDoomed = true;
                    break;
                }
                for(int j=0; j<knights.length; j++){
                    if(knights[j]>=heads[i]){
                        total+=knights[j];
                        knights[j] = Integer.MIN_VALUE;
                        heads[i] = Integer.MIN_VALUE;
                        Arrays.sort(heads);
                        Arrays.sort(knights);
                        break;
                    }
                }
            }
            if(isDoomed) System.out.println("Loowater is doomed!");
            else System.out.println(total);
        }
    }
}
