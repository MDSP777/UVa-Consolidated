

import java.util.Scanner;

public class UVa_105 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[1500000];
        int firstL = Integer.MAX_VALUE, lastR = Integer.MIN_VALUE;
        do{
            int l = sc.nextInt();
            int h = sc.nextInt();
            int r = sc.nextInt();
//            if(l==0 && h==0 && r==0) break;
            firstL = Math.min(l, firstL);
            lastR = Math.max(r, lastR);
            
            for(int i=l; i<r; i++) heights[i] = Math.max(heights[i], h);
        }while(sc.hasNext());
        int curH = heights[firstL];
        
        System.out.print(firstL + " " + curH);
        firstL++;
        lastR++;
        while(firstL<=lastR){
            if(heights[firstL]!=curH){
                curH = heights[firstL];
                System.out.print(" "+firstL+" "+curH);
            }
            firstL++;
        }
        System.out.println();
    }
}
