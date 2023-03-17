

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_10474 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = 1;
        while(true){
            int n = sc.nextInt();
            int q = sc.nextInt();
            if(n==0 && q==0) break;
            
            System.out.println("CASE# "+nC+++":");
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<n; i++) list.add(sc.nextInt());
            Collections.sort(list);
            
            int[] indices = new int[11000];
            for(int i=0; i<11000; i++) indices[i] = -1;
            
            for(int i=0; i<list.size(); i++){
                if(indices[list.get(i)]==-1) indices[list.get(i)] = i;
            }
            
            for(int i=0; i<q; i++){
                int query = sc.nextInt();
                if(indices[query]==-1) System.out.println(query+" not found");
                else System.out.println(query+" found at "+(indices[query]+1));
            }
        }

    }
}
