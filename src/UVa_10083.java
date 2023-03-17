

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class UVa_10083 {
    public static void main(String[] args) throws Exception{
        StringBuilder out = new StringBuilder("");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String in = "";
        while ((in = br.readLine()) != null){
            String[] str = in.split(" ");
            int t = Integer.parseInt(str[0]);
            int a = Integer.parseInt(str[1]);
            int b = Integer.parseInt(str[2]);
            BigInteger bigT = new BigInteger(t+"");
            BigInteger bigA = bigT.pow(a).subtract(BigInteger.ONE);
            BigInteger bigB = bigT.pow(b).subtract(BigInteger.ONE);
            String result = bigA.divide(bigB).toString();
            if(result.length()>=100 || !bigA.mod(bigB).equals(BigInteger.ZERO)) 
                out.append("("+t+"^"+a+"-1)/("+t+"^"+b+"-1) is not an integer with less than 100 digits.\n");
            else out.append("("+t+"^"+a+"-1)/("+t+"^"+b+"-1) "+result+"\n");
        }
        System.out.print(out);
    }
}
