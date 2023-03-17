

import java.util.Scanner;

public class UVa_11888 {
    static String n;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<nC; i++){
            n = sc.nextLine();
            stuff(n);
        }
    }
    
    public static void stuff(String n){
        int a = n.length();
        for(int i=0; i<a-1; i++){
            if(n.charAt(0)==n.charAt(i) && n.charAt(i+1)==n.charAt(a-1)){
                if(checkP(0, i+1))
                    if(checkP(i+1, a)){
                        System.out.println("alindrome");
                        return;
                    }
            }
        }
        if(checkP(0, a))
            System.out.println("palindrome");
        else
            System.out.println("simple");
    }
    
    public static boolean checkP(int a, int b){
        for(int i=a; i<b; i++, b--){
            if(n.charAt(i)!=n.charAt(b-1)){
                return false;
            }
        }
        return true;
    }
}
