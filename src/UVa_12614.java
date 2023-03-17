

import java.util.Scanner;

public class UVa_12614 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int i=1; i<=nC; i++){
            int max = -99, temp;
            int arr = sc.nextInt();
            for(int j=0; j<arr; j++){
                temp = sc.nextInt();
                if(temp>max) max = temp;
            }
            System.out.println("Case "+i+": "+max);
        }
    }
}
