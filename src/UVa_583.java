

import java.util.Scanner;

public class UVa_583 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean[] prime = new boolean[50000];
        for(int i=1; i<50000; i++) prime[i] = true;
        for(int i=2; i<50000; i++){
            if(prime[i]){
                for(int j=2*i; j<50000; j+=i){
                    prime[j] = false;
                }
            }
        }
        
        while(true){
            int in = sc.nextInt();
            if(in==0) break;
            boolean isNeg = false;
            if(in<0){
                in *= -1;
                isNeg = true;
            }
            StringBuilder factors = new StringBuilder();
            int inCopy = in;
            for(int i=2; i<Math.sqrt(in)+1; i++){
                if(prime[i]){
                    while(inCopy%i==0){
                        inCopy/=i;
                        factors.append(i+" x ");
                        if(inCopy==1) break;
                    }
                }
                if(inCopy==1) break;
            }
            if(inCopy!=1 || in==1) factors.append(inCopy);
            else if(factors.length()>=3) factors.setLength(factors.length()-3);
            if(isNeg) System.out.print((-in)+" = -1 x ");
            else System.out.print(in+" = ");
            System.out.println(factors);
        }
    }
}
