

import java.util.Arrays;
import java.util.Scanner;

public class UVa_11057 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            int n = sc.nextInt();
            int[] books = new int[n];
            int max = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                books[i] = sc.nextInt();
                max = Math.max(max, books[i]);
            }
            Arrays.sort(books);
            int m = sc.nextInt();
            int[] ctr = new int[max+1];
            
            for(int i=0; i<n; i++){
                ctr[books[i]]++;
            }
            
            int left = 0;
            int right = 0;
            int diff = Integer.MAX_VALUE;
            for(int i=0; i<n; i++){
                if(books[i]>m) break;
                if(books[i]*2==m){
                    if(ctr[books[i]]>=2){
                        left = right = books[i];
                        break;
                    }
                } else {
                    try{
                        if(ctr[m-books[i]]>=1){
                            if(Math.abs(books[i]-(m-books[i]))<diff){
                                left = Math.min(books[i], m-books[i]);
                                right = Math.max(books[i], m-books[i]);
                                diff = Math.abs(books[i]-(m-books[i]));
                            }
                        }
                    } catch(Exception e){}
                }
            }
            System.out.println("Peter should buy books whose prices are "+left+" and "+right+".\n");
        } while(sc.hasNext());

    }
}
