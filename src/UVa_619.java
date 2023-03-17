

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_619 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            String input = sc.next();
            if(input.equals("*")) break;
            if(input.charAt(0)>='a' && input.charAt(0)<='z'){
                int firstVal = input.charAt(0)-'a'+1;
                BigInteger val = new BigInteger(firstVal+"");
                for(int i=1; i<input.length(); i++){
                    val = val.multiply(new BigInteger("26"));
                    int newVal = input.charAt(i)-'a'+1;
                    val = val.add(new BigInteger(newVal+""));
                }
                int l = input.length();
                for(int i=0; i<22-l; i++){
                    input+=" ";
                }
                System.out.println(input+addCommas(val));
            } else {
                StringBuilder ans = new StringBuilder("");
                BigInteger val = new BigInteger(input);
                BigInteger store = new BigInteger(input);
                while(!val.equals(BigInteger.ZERO)){
                    int letter = Integer.parseInt(val.mod(new BigInteger("26"))+"");
                    ans.append((char) (letter+'a'-1));
                    val = val.divide(new BigInteger("26"));
                }
                input = ans.reverse().toString();
                int l = input.length();
                for(int i=0; i<22-l; i++){
                    input+=" ";
                }
                System.out.println(input+addCommas(store));
            }
        }

    }

    private static String addCommas(BigInteger val) {
        String ans = val.toString();
        int extra = ans.length()%3;
        String out = "";
        if(extra>0){
            out = ans.substring(0, extra)+",";
        }
        int nPartitions = ans.length()/3;
        for(int i=0; i<nPartitions; i++){
            out += ans.substring(i*3+extra, i*3+extra+3);
            if(i<nPartitions-1) out += ","; 
        }
        return out;
    }
}
