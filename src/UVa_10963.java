

import java.util.Scanner;

public class UVa_10963 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int i=0; i<nC; i++){
            boolean yes = true;
            int nTerms = sc.nextInt();
            int curDiff = sc.nextInt()-sc.nextInt();
            for(int j=1; j<nTerms; j++){
                int temp = sc.nextInt()-sc.nextInt();
                if(temp!=curDiff)
                    yes = false;
            }
            if(yes) System.out.println("yes");
            else System.out.println("no");
            if(i<nC-1) System.out.println();
        }
    }
}
