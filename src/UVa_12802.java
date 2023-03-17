

import java.util.Scanner;

public class UVa_12802 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean[] prime = new boolean[2000001];
        for(int i=1; i<=2000000; i++) prime[i] = true;
        for(int i=2; i<=2000000; i++){
            if(prime[i]){
                for(int j=2*i; j<=2000000; j+=i){
                    prime[j] = false;
                }
            }
        }
        while(true){
            int n = sc.nextInt();
            System.out.println(n*2);
            if(isPalindrome(n+"") && prime[n]) break;
        }

    }

    private static boolean isPalindrome(String n) {
        int half = n.length()/2;
        for(int i=0; i<half; i++) if(n.charAt(i)!=n.charAt(n.length()-1-i)) return false;
        return true;
    }
}
