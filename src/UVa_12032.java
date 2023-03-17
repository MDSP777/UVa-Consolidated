


import java.util.*;

public class UVa_12032 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=1; x<=nC; x++){
            int size = sc.nextInt();
            int[] rungs = new int[size];
            int max = Integer.MIN_VALUE;
            int cur = 0;
            for(int i=0; i<size; i++){
                rungs[i] = sc.nextInt();
                int height = rungs[i]-cur;
                cur = rungs[i];
                max = Math.max(height, max);
            }
            cur = 0;
            int k = max;
            boolean canCross = true;
            for(int i=0; i<size; i++){
                int height = rungs[i]-cur;
                if(height==k) k--;
                else if(height>k){
                    canCross = false;
                    break;
                }
                
                cur = rungs[i];
            }
            if(!canCross) max++;
            System.out.println("Case "+x+": "+max);
        }
    }
}
