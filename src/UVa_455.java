

import java.util.Scanner;

public class UVa_455 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int asdf=0; asdf<nC; asdf++){
            String cur = sc.next();
            int len = cur.length();
            for(int i=1; i<=len; i++){
                if(len%i==0){
                    int nPer = len/i;
                    String segment = cur.substring(0, i);
                    StringBuilder n = new StringBuilder(segment);
                    for(int j=1; j<nPer; j++) n.append(segment);
                    if(cur.equals(new String(n))){
                        System.out.println(i);
                        break;
                    }
                }
            }
            if(asdf!=nC-1) System.out.println("");
        }
    }
}
