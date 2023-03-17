

import java.util.Scanner;

public class UVa_10684 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int size = sc.nextInt();
            if(size==0) break;
            int[] arr = new int[size];
            for(int i=0; i<size; i++) arr[i] = sc.nextInt();
            
            int ans = kadane(arr);
            if(ans>0) System.out.println("The maximum winning streak is "+ans+".");
            else System.out.println("Losing streak.");
        }

    }

    private static int kadane(int[] arr) {
        int total = 0;
        int maxSoFar = 0;
        for(int i=0; i<arr.length; i++){
            total += arr[i];
            maxSoFar = Math.max(maxSoFar, total);
            if(total<0) total = 0;
        }
        
        return maxSoFar;
    }
}
