

import java.util.Scanner;

public class UVa_11805 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int n, k, p;
        for(int i=1; i<=cases; i++){
            n = sc.nextInt();
            k = sc.nextInt();
            p = sc.nextInt();
            for(int j=0; j<p; j++){
                k++;
                if(k>n)
                    k=1;
            }
            System.out.println("Case "+i+": "+k);
        }
    }
}
