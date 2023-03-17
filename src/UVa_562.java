

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_562 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int  x=0; x<nC; x++){
            boolean sumIsEven = true;
            ArrayList<Integer> arr = new ArrayList();
            boolean[] inList = new boolean[50500];
            int nTerms = sc.nextInt();
            int ctr = 0;
            int best = Integer.MAX_VALUE;
            int[] terms = new int[nTerms];
            int half = 0;
            for(int i=0; i<nTerms; i++){
                terms[i] = sc.nextInt();
                half+=terms[i];
            }
            if(half%2==1) sumIsEven = false;
            half/=2;
            for(int i=0; i<nTerms; i++){
                int l = arr.size();
                for(int j=0; j<l; j++){
                    int n = arr.get(j)+terms[i];
                    if(Math.abs(half-n)<best){
                        best = Math.abs(half-n);
                        ctr = n;
                    }
                    if(!inList[n]){
                        arr.add(n);
                        inList[n] = true;
                    }
                }
                if(Math.abs(half-terms[i])<best){
                    best = Math.abs(half-terms[i]);
                    ctr = terms[i];
                }
                if(!inList[terms[i]]){
                    arr.add(terms[i]);
                    inList[terms[i]] = true;
                }
                if(best==0) break;
            }
            half*=2;
            if(!sumIsEven) half++;
            System.out.println(Math.abs(half-ctr*2));
        }
    }
}
