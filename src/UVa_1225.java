

import java.util.Scanner;

public class UVa_1225 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            int[] res = new int[10];
            int n = sc.nextInt();
            for(int i=1; i<=n; i++){
                addDigits(i, res);
            }
            for(int i=0; i<9; i++) System.out.print(res[i]+" ");
            System.out.println(res[9]);
        }
    }
    
    public static void addDigits(int n, int[] res){
        String in = n+"";
        int l = in.length();
        for(int i=0; i<l; i++) res[in.charAt(i)-48]++;
    }
}
