

import java.util.Scanner;

public class UVa_10324 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = 1;
        do{
            char[] in;
            do{
                in = sc.nextLine().toCharArray();
            }while(in.length==0);
            int n = sc.nextInt();
            System.out.println("Case "+x+":");
            for(int i=0; i<n; i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                if(start>end){
                    int temp = end;
                    end = start;
                    start = temp;
                }
                if(checkIfSame(in, start, end)) System.out.println("Yes");
                else System.out.println("No");
            }
            x++;
            sc.nextLine();
        }while(sc.hasNext());
    }
    
    static boolean checkIfSame(char[] c, int start, int end){
        char basis = c[start];
        for(int i=start+1; i<=end; i++)
            if(c[i]!=basis) return false;
        return true;
    }
}
