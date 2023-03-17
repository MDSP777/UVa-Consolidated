

import java.util.Scanner;

public class UVa_11264 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            int nTerms = sc.nextInt();
            int total = 1;
            int[] list = new int[nTerms];
            long curSum = list[0] = sc.nextInt();
            for(int i=1; i<nTerms; i++){
                list[i] = sc.nextInt();
                int curTerm = list[i];
                if(curTerm>curSum){
                    total++;
                    curSum+=curTerm;
                } else{
                    curSum-=list[i-1];
                    curSum+=curTerm;
                }
            }
            System.out.println(total);
        }
    }
}
