

import java.util.Scanner;

public class UVa_11875 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1; i<=t; i++){
            int n = sc.nextInt();
            for(int j=0; j<n/2; j++)
                sc.nextInt();
            System.out.println("Case "+i+": "+sc.nextInt());
            sc.nextLine();
        }
    }
}
