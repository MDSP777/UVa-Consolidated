

import java.util.Scanner;

public class UVa_621 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nc = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<nc; i++){
            String in = sc.nextLine();
            if(in.equals("1")||in.equals("4")||in.equals("78"))
                System.out.println("+");
            else if(in.substring(in.length()-2).equals("35")) System.out.println("-");
            else if(in.charAt(0)=='9' && in.charAt(in.length()-1)=='4') System.out.println("*");
            else System.out.println("?");
        }
    }
}
