

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_10954 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n==0) break;
            ArrayList<Integer> terms = new ArrayList();
            for(int i=0; i<n; i++) terms.add(sc.nextInt());
            Collections.sort(terms);
            int total = 0;
            for(int i=1; i<n; i++){
                terms.set(i, terms.get(i)+terms.get(i-1));
                total+=terms.get(i);
                terms.remove(i-1);
                Collections.sort(terms);
                n--;
                i--;
            }
            System.out.println(total);
        }
    }
}
