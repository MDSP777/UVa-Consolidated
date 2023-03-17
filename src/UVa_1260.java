

import java.util.Scanner;

public class UVa_1260 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            int nDays = sc.nextInt();
            int[] days = new int[nDays];
            for(int i=0; i<nDays; i++){
                days[i] = sc.nextInt();
            }
            int sum = 0;
            for(int i=1; i<nDays; i++){
                int cur = days[i];
                for(int j=0; j<i; j++){
                    if(days[j]<=days[i]) sum++;
                }
            }
            System.out.println(sum);
        }

    }
}
