

import java.util.Scanner;

public class UVa_12195 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            String in = sc.nextLine();
            if(in.equals("*")) break;
            in = in.substring(1, in.length()-1);
            String[] split = in.split("/");
            int total = 0;
            for(int i=0; i<split.length; i++){
                total += nWholes(split[i]);
            }
            System.out.println(total);
        }

    }
    
    static int nWholes(String meas){
        double total = 0;
        for(int i=0; i<meas.length(); i++){
            char c = meas.charAt(i);
            switch(c){
                case 'W':
                    total += 1;
                    break;
                case 'H':
                    total += 0.5;
                    break;
                case 'Q':
                    total += 0.25;
                    break;
                case 'E':
                    total += 0.125;
                    break;
                case 'S':
                    total += 1/16.0;
                    break;
                case 'T':
                    total += 1/32.0;
                    break;
                case 'X':
                    total += 1/64.0;
                    break;
            }
        }
        if(total==1) return 1;
        else return 0;
    }
}
