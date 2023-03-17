

import java.util.Scanner;

public class UVa_10656 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n==0) break;
            int[] arr = new int[n];
            int sum = 0;
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            if(sum==0){
                System.out.println("0");
                continue;
            }
            int start = 0;
            int end = n-1;
            for(int i=0; i<n; i++)
                if(arr[i]==0)
                    start++;
                else break;
            for(int i=end; i>=0; i--)
                if(arr[i]==0)
                    end--;
                else break;
            for(int i=start; i<end; i++){
                if(arr[i]!=0)
                    System.out.print(arr[i]+" ");
            }
            System.out.println(arr[end]);
        }

    }
}
