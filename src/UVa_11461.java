

import java.util.Scanner;

public class UVa_11461 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean[] arr = new boolean[100001];
        for(int i=1; i<100001; i++){
            double root = Math.sqrt(i);
            if(root==Math.floor(root)) arr[i] = true;
            else arr[i] = false;
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        while(!(a==0&&b==0)){
            int total=0;
            for(int i=a; i<=b; i++)
                if(arr[i]) total++;
            System.out.println(total);
            a = sc.nextInt();
            b = sc.nextInt();
        }
    }
}
