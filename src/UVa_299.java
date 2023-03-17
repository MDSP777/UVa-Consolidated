

import java.util.Scanner;

public class UVa_299 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int x=0; x<t; x++){
            int s = sc.nextInt();
            int[] arr = new int[s];
            for(int i=0; i<s; i++) arr[i] = sc.nextInt();
            bubble(arr);
        }
    }
    
    public static void bubble(int[] a){
        int total = 0;
        for(int i=0; i<a.length; i++)
            for(int j=0; j<a.length-i-1; j++)
                if(a[j]>a[j+1]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                    total++;
                }
        System.out.println("Optimal train swapping takes "+total+" swaps.");
    }
}
