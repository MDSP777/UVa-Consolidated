

import java.util.Scanner;

public class UVa_10008 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nc = sc.nextInt(); sc.nextLine();
        int[] arr = new int[26];
        for(int i=0; i<26; i++) arr[i] = 0;
        for(int i=0; i<nc; i++){
            String in = sc.nextLine();
            in = in.toLowerCase();
            for(int j=0; j<in.length(); j++){
                char c = in.charAt(j);
                if(c>=97&&c<=122) arr[c-97]++;
            }
        }
        while(!cond(arr)){
            int max = -99, mi=0;
            for(int i=0; i<26; i++)
                if(arr[i]>max){
                    max = arr[i];
                    mi = i;
                }
            System.out.println((char)(mi+65)+" "+arr[mi]);
            arr[mi] = 0;
        }
    }
    
    public static boolean cond(int[] a){
        for(int i=0; i<a.length; i++)
            if(a[i]!=0) return false;
        return true;
    }
}
