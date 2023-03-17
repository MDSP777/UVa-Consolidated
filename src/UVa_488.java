

import java.util.Scanner;

public class UVa_488 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            int amp = sc.nextInt();
            int freq = sc.nextInt();
            String n = "";
            for(int i=1; i<=amp; i++){
                for(int j=1; j<=i; j++)
                    n+=i;
                n+='\n';
            }
            for(int i=amp-1; i>1; i--){
                for(int j=1; j<=i; j++)
                    n+=i;
                n+='\n';
            }
            if(amp!=1)
                n+='1';
            else n = n.substring(0, n.length()-1);
            freq--;
            for(int i=0; i<freq; i++) System.out.println(n+'\n');
            System.out.println(n);
            if(x<nC-1) System.out.println();
        }
    }
}
