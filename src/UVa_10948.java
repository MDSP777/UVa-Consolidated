

import java.util.Scanner;

public class UVa_10948 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean[] primes = new boolean[1000001];
        for (int i = 2; i < 1000001; i++) {
            primes[i] = true;
        }
        for(int i=2; i<1000001; i++){
            if(primes[i]){
                for(int j=i*2; j<1000001; j+=i){
                    primes[j] = false;
                }
            }
        }
        
        String[] answers = new String[1000001];
        for(int i=4; i<1000001; i++){
            if(i%2==1){
                if(primes[i-2]){
                    answers[i] = "2+"+(i-2);
                } else {
                    answers[i] = "NO WAY!";
                }
                continue;
            }
            int half = i/2;
            boolean found = false;
            for(int j=2; j<=half; j++){
                if(primes[j] && primes[i-j]){
                    answers[i] = j+"+"+(i-j);
                    found = true;
                    break;
                }
            }
            if(!found) answers[i] = "NO WAY!";
            //System.out.println(answers[i]+"="+i);
        }
        answers[4] = "2+2";
        answers[6] = "3+3";
        
        while(true){
            int n = sc.nextInt();
            if(n==0) break;
            System.out.println(n+":");
            System.out.println(answers[n]);
        }
    }
}
