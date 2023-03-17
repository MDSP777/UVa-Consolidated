

import java.util.Scanner;

public class UVa_11385 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] fibo = new int[46];
        fibo[1] = 1;
        fibo[2] = 2;
        for(int i=3; i<=45; i++)
            fibo[i] = fibo[i-1]+fibo[i-2];
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            int nTerms = sc.nextInt();
            int[] terms = new int[nTerms];
            for(int i=0; i<nTerms; i++)
                terms[i] = sc.nextInt();
            sc.nextLine();
            String message = sc.nextLine();
            for(int i=0; i<message.length(); i++){
                if(message.charAt(i)>'Z' || message.charAt(i)<'A' && message.charAt(i)!=' '){
                    message = message.substring(0, i)+message.substring(i+1);
                    i--;
                }
            }
            int maxFibo = 0;
            for(int i=0; i<terms.length; i++){
                int index = -1;
                for(int j=0; j<fibo.length; j++)
                    if(terms[i]==fibo[j]){
                        index = j;
                        break;
                    }
                maxFibo = Math.max(maxFibo, index);
            }
            char[] decode = new char[maxFibo];
            for(int i=0; i<decode.length; i++)
                decode[i] = ' ';
            for(int i=0; i<message.length(); i++)
                if(message.charAt(i)==' '){
                    message = message.substring(0, i)+message.substring(i+1);
                    i--;
                }
            int index = -1;
            for(int i=0; i<terms.length; i++){
                for(int j=0; j<fibo.length; j++)
                    if(terms[i]==fibo[j]){
                        index = j;
                        break;
                    }
                decode[index-1] = message.charAt(i);
            }
            System.out.println(decode);
        }
    }
}
