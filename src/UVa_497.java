

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_497 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); sc.nextLine();
        sc.nextLine();
        for(int i=0; i<t; i++){
            String n = sc.nextLine().trim();
            ArrayList<Integer> list = new ArrayList();
            while(!n.equals("")){
                list.add(Integer.parseInt(n));
                n = sc.nextLine().trim();
            }
            lis(list);
            if(i<t-1) System.out.println();
        }
    }
    
    public static void lis(ArrayList<Integer> list){
        int l = list.size();
        if(l==0){
            System.out.println("Max hits: 0");
            return;
        }
        int[] longest = new int[l];
        longest[0] = 1;
        int max;
        for(int i=1; i<l; i++){
            int ti = list.get(i);
            max = 0;
            for(int j=0; j<i; j++){
                int tj = list.get(j);
                if(tj<ti && longest[j]>max)
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
        System.out.println("Max hits: "+max);
        
        int[] lis = new int[max];
        lis[max-1] = list.get(lisIndex);
        int mTemp = max-2;
        int max2 = longest[lisIndex]-1;
        for(int i=lisIndex-1; i>=0; i--)
            if(longest[i]==max2){
                lis[mTemp--] = list.get(i);
                max2--;
            }
        for(int i=0; i<max; i++) System.out.println(lis[i]);
    }
}
