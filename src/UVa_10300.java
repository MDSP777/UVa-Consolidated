

import java.util.Scanner;

public class UVa_10300 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int nFarmer = sc.nextInt();
            long total = 0;
            for(int j=0; j<nFarmer; j++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                long l = a*c;
                total+=l;
            }
            System.out.println(total);
        }
    }
}
