

import java.math.BigDecimal;
import java.util.Scanner;

public class UVa_748 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            BigDecimal in = new BigDecimal(sc.next());
            in = in.pow(sc.nextInt());
            String ans = in.toPlainString();
            while(ans.endsWith("0")){
                ans = ans.substring(0, ans.length()-1);
            }
            while(ans.startsWith("0")){
                ans = ans.substring(1, ans.length());
            }
            System.out.println(ans);
        } while(sc.hasNext());

    }
}
