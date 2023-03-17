

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_231 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while(true){
            ArrayList<Integer> list = new ArrayList();
            int c = sc.nextInt();
            if(c==-1) break;
            if(t>1) System.out.println();
            while(c!=-1){
                list.add(c);
                c = sc.nextInt();
            }
            int n = lis(list);
            System.out.println("Test #"+t+++":");
            System.out.println("  maximum possible interceptions: "+n);
        }
    }
    
    public static int lis(ArrayList<Integer> list){
        int l = list.size();
        int[] longest = new int[l];
        longest[0] = 1;
        int max;
        for(int i=1; i<l; i++){
            int ti = list.get(i);
            max = 0;
            for(int j=0; j<i; j++){
                int tj = list.get(j);
                if(tj>ti && longest[j]>max)
                    max = longest[j];
            }
            longest[i] = max+1;
        }
        
        max = 0;
        int lisIndex=-1;
        for(int i=0; i<l; i++)
            if(longest[i] > max){
                max = longest[i];
                lisIndex = i;
            }
        int[] lis = new int[max];
        lis[max-1] = list.get(lisIndex);
        int mTemp = max-2;
        int max2 = lis[max-1];
        for(int i=lisIndex-1; i>=0; i--)
            if(list.get(i)>=max2){
                lis[mTemp--] = list.get(i);
                max2 = list.get(i);
            }
        for(int i=0; i<max; i++) System.out.print(lis[i]+" ");
        System.out.println("");
        return max;   
    }
}
