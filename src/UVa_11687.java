

import java.util.Scanner;

public class UVa_11687 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        while(!n.equals("END")){
            if(n.equals("1")) System.out.println("1");
            else if(n.length()==1) System.out.println("2");
            else if(n.length()<10) System.out.println("3");
            else System.out.println("4");
            n = sc.nextLine();
        }
    }
}
