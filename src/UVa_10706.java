

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_10706 {
    static ArrayList<Integer> end;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long ans = 0;
        long cur = 0;
        end = new ArrayList();
        int nDigits;
        int offset = 0;
        while(true){
            cur++;
            nDigits = getLen(cur)-1;
            offset += nDigits;
            ans += cur + offset;
            if(ans>Integer.MAX_VALUE) break;
            end.add((int)ans);
        }
        end.add(Integer.MAX_VALUE);
        
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            System.out.println(valAt(sc.nextInt()));
        }
    }

    private static int valAt(int index) {
        int l = Collections.binarySearch(end, index);
        if(l<0) l = -(l+1);
        if(l==0) return 1;
        int left = end.get(l-1)+1;
        int right = end.get(l);
        
        StringBuilder add = new StringBuilder();
        int ctr = 1;
        index -= left;
        right -= left;
        left = 0;
        for(int i=left; i<=right; i++){
            add.append(ctr++);
        }
        String out = add.toString();
        return Integer.parseInt(out.charAt(index)+"");
    }

    private static int getLen(long cur) {
        if(cur<10) return 1;
        if(cur<100) return 2;
        if(cur<1000) return 3;
        if(cur<10000) return 4;
        if(cur<100000) return 5;
        if(cur<1000000) return 6;
        if(cur<10000000) return 7;
        if(cur<100000000) return 8;
        if(cur<1000000000) return 9;
        return 10;
    }
}
