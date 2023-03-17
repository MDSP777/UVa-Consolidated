

import java.math.BigDecimal;
import java.util.Scanner;

public class UVa_11821 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int i=0; i<nC; i++){
            BigDecimal total = BigDecimal.ZERO;
            while(true){
                BigDecimal in = new BigDecimal(sc.next());
                if(in.equals(BigDecimal.ZERO)) break;
                total = total.add(in);
            }
            String ans = total.toPlainString();
            while(ans.endsWith("0")) ans = ans.substring(0, ans.length()-1);
            if(ans.endsWith(".")) ans = ans.substring(0, ans.length()-1);
            if(ans.length()==0) ans = "0";
            System.out.println(ans);
        }

    }
}
