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
public class UVa_10945 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        while(!input.equals("DONE")){
            input = removeNonAlpha(input);
            if(checkPalindrome(input))
                System.out.println("You won't be eaten!");
            else
                System.out.println("Uh oh..");
            input = sc.nextLine();
        }
    }
    
    public static String removeNonAlpha(String s){
        s = s.replace('.', '~');
        s = s.replace(',', '~');
        s = s.replace('!', '~');
        s = s.replace('?', '~');
        s = s.replace(' ', '~');
        s = s.replaceAll("~", "");
        s= s.toLowerCase();
        return s;
    }
    
    public static boolean checkPalindrome(String s){
        String s2 = "";
        for(int i = s.length()-1; i >= 0; i--)
            s2 += s.charAt(i);
        if(s.equals(s2))
            return true;
        else return false;
    }
}
