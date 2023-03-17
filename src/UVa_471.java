

import java.util.Scanner;

public class UVa_471 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            long num = sc.nextLong();
            int mult = 1;
            while(true){
                long prod = num*mult;
                if((prod+"").length()>10){
                    break;
                }
                if(noRep(prod) && noRep(mult)){
                    System.out.println(prod+" / "+mult+" = "+num);
                }
                mult++;
            }
            if(x<nC-1) System.out.println("");
        }

    }

    private static boolean noRep(long num) {
        String n = num+"";
        int len = n.length();
        int[] dCount = new int[10];
        for(int i=0; i<len; i++){
            dCount[n.charAt(i)-'0']++;
            if(dCount[n.charAt(i)-'0']>1) return false;
        }
        return true;
    }
}
