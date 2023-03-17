

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_11136 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n==0) break;
            long total = 0;
            int s = 0;
            ArrayList<Integer> a = new ArrayList();
            
            for(int i=0; i<n; i++){
                int nBills = sc.nextInt();
                s+=nBills;
                for(int j=0; j<nBills; j++)
                    a.add(sc.nextInt());
                Collections.sort(a);
                total += (a.get(s-1)-a.get(0));
                a.remove(s-1);
                a.remove(0);
                s-=2;
            }
            
            System.out.println(total);
        }
    }
}
