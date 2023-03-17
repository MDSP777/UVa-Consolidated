/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Scanner;

/**
 *
 * @author MarcDominic
 */
public class UVa_12243 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char cur;
        boolean yes;
        String n = sc.nextLine();
        while(!n.equals("*")){
            yes = true;
            String[] split = n.split(" ");
            cur = split[0].charAt(0);
            cur = (cur+"").toLowerCase().charAt(0);
            for(int i=1; i<split.length; i++){
                char c = split[i].charAt(0);
                c = (c+"").toLowerCase().charAt(0);
                if(cur!=c){
                    yes = false;
                    break;
                }
            }
            if(yes) System.out.println("Y");
            else System.out.println("N");
            n = sc.nextLine();
        }
    }
}
