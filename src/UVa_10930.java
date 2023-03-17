

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_10930 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = 1;
        do{
            ArrayList<Integer> newArr = new ArrayList();
            int max = -99;
            boolean flag = true;
            boolean[] vals = new boolean[1001];
            for(int i=0; i<1001; i++)
                vals[i] = false;
            int nTerms = sc.nextInt();
            String in = sc.nextLine();
            in = in.substring(1);
            int[] terms = new int[nTerms];
            String[] split = in.split(" ");
            for(int i=0; i<nTerms; i++){
                terms[i] = Integer.parseInt(split[i]);
                if(terms[i]<=max || vals[terms[i]]){
                    flag = false;
                    break;
                }
                else{
                    max = terms[i];
                    //System.out.println("Max "+max);
                    int l = newArr.size();
                    for(int j=0; j<l; j++){
                        int n = newArr.get(j)+terms[i];
                        if(n>1000 || vals[n]) continue;
                        vals[n] = true;
                        newArr.add(n);
                    }
                    newArr.add(terms[i]);
                }
            }
            //for(int i=0; i<newArr.size(); i++) System.out.println(newArr.get(i));
            System.out.printf("Case #%d:", t++);
            for ( int i = 0; i < nTerms; i++ )
                System.out.printf(" %d", Integer.parseInt(split[i]));
            System.out.printf("\n");
            if(flag){
                System.out.println("This is an A-sequence.");
            }
            else{
                System.out.println("This is not an A-sequence.");
            }
        }while(sc.hasNext());
    }
}
