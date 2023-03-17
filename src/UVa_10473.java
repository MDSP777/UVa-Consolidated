

import java.util.Scanner;

public class UVa_10473 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            String in = sc.nextLine();
            if(in.startsWith("-")) break;
            if(in.startsWith("0x")) System.out.println(toDecimal(in.substring(2)));
            else System.out.println(toHex(Long.parseLong(in)));
        }

    }

    private static String toHex(long in) {
        StringBuilder ans = new StringBuilder();
        while(in!=0){
            long rem = in%16;
            if(rem<10) ans.append(rem);
            else {
                ans.append((char)('A'+rem-10));
            }
            in/=16;
        }
        return "0x"+ans.reverse().toString();
    }

    private static long toDecimal(String in) {
        long total;
        if(in.charAt(0)<='9') total = Long.parseLong(in.charAt(0)+"");
        else total = Long.parseLong((in.charAt(0)-55)+"");
        for(int i=1; i<in.length(); i++){
            total*=16;
            char cur = in.charAt(i);
            if(cur<='9') total+=Long.parseLong(cur+"");
            else total+=Long.parseLong((cur-55)+"");
        }
        return total;
    }
}
