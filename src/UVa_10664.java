

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_10664 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        sc.nextLine();
        for(int x=0; x<nC; x++){
            boolean found = false;
            int total = 0;
            int half;
            ArrayList<Integer> arr = new ArrayList();
            String in = sc.nextLine();
            String[] split = in.split(" ");
            int[] terms = new int[split.length];
            for(int i=0; i<split.length; i++){
                terms[i] = Integer.parseInt(split[i]);
                total+=terms[i];
            }
            if(total%2==1){
                System.out.println("NO");
                continue;
            }
            half = total/2;
            for(int i=0; i<split.length; i++){
                int l = arr.size();
                for(int j=0; j<l; j++){
                    int n = arr.get(j)+terms[i];
                    if(n==half){
                        found = true;
                        break;
                    }
                    arr.add(n);
                }
                arr.add(terms[i]);
                if(terms[i]==half) found = true;
                if(found) break;
            }
            if(found) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
