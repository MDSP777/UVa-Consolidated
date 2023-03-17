

import java.util.Scanner;

public class UVa_10812 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int i=0; i<nC; i++){
            int sum = sc.nextInt();
            int diff = sc.nextInt();
            boolean found = false;
            for(int j=sum; j>=sum/2; j--){
                int opp = sum-j;
                if(Math.abs(j-opp)==diff){
                    System.out.println(j+" "+opp);
                    found = true;
                    break;
                }
            }
            if(!found) System.out.println("impossible");
        }
    }
}
