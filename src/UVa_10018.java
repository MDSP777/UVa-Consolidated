

import java.util.Scanner;

public class UVa_10018 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int i=0; i<nC; i++){
            int total = 0;
            long in = sc.nextLong();
            while(!palindrome(String.valueOf(in))){
                in += reverse(String.valueOf(in));
                total++;
            }
            System.out.println(total+" "+in);
        }
    }
    
    public static boolean palindrome(String n){
        int l = n.length()-1;
        for(int i=0; i<n.length()/2; i++){
            if(n.charAt(i)!=n.charAt(l))
                return false;
            l--;
        }
        return true;
    }
    
    public static long reverse(String n){
        StringBuilder out = new StringBuilder();
        for(int i = n.length()-1; i>=0; i--)
            out.append(n.charAt(i));
        return Long.parseLong(out.toString());
    }
}
