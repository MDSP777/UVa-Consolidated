

import java.util.Scanner;

public class UVa_10235 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean[] sieve = new boolean[1000000];
        for(int i=0; i<1000000; i++) sieve[i] = true;
        for(int i=2; i<1000000; i++){
            if(!sieve[i]) continue;
            int temp = 2*i;
            for(int j=temp; j<1000000; j+=i){
                sieve[j] = false;
            }
        }
        do{
            int n = sc.nextInt();
            if(!sieve[n])
                System.out.println(n+" is not prime.");
            else{
                String s = n+"";
                String s2 = "";
                for(int i=0; i<s.length(); i++)
                    s2+=s.charAt(s.length()-i-1);
                int rev = new Integer(s2);
                if(sieve[rev] && n!=rev)
                    System.out.println(n+" is emirp.");
                else System.out.println(n+" is prime.");
            }
        }while(sc.hasNext());
    }
}
