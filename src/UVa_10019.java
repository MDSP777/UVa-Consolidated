

import java.util.Scanner;

public class UVa_10019 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            int b1 = 0;
            int b2 = 0;
            int input = sc.nextInt();
            String a = Integer.toBinaryString(input);
            for(int i=0; i<a.length(); i++)
                if(a.charAt(i)=='1') b1++;
            a = input+"";
            String b = "";
            for(int i=0; i<a.length(); i++){
                b = getBinary(a.charAt(i));
                for(int j=0; j<b.length(); j++)
                    if(b.charAt(j)=='1') b2++;
            }
            System.out.println(b1+" "+b2);
        }
    }
    
    static String getBinary(char hex){
        switch(hex){
            case '0': return "0000";
            case '1': return "0001";
            case '2': return "0010";
            case '3': return "0011";
            case '4': return "0100";
            case '5': return "0101";
            case '6': return "0110";
            case '7': return "0111";
            case '8': return "1000";
            case '9': return "1001";
            case 'a': return "1010";
            case 'b': return "1011";
            case 'c': return "1100";
            case 'd': return "1101";
            case 'e': return "1110";
            case 'f': return "1111";    
        }
        return "";
    }
}
