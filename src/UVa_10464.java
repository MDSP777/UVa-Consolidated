

import java.math.BigDecimal;
import java.util.Scanner;

public class UVa_10464 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int i=0; i<nC; i++){
            BigDecimal total = new BigDecimal(sc.next());
            BigDecimal in = new BigDecimal(sc.next());
            total = total.add(in);
            String ans = total.toPlainString();
            while(ans.endsWith("0")) ans = ans.substring(0, ans.length()-1);
            if(ans.endsWith(".")) ans = ans.substring(0, ans.length()-1);
            if(ans.length()==0) ans = "0";
            if(!ans.contains(".")) ans += ".0";
            System.out.println(ans);
        }
    }
}
