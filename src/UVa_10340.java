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
public class UVa_10340 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s, t;
        int nL;
        do{
            nL = 0;
            s = sc.next();
            t = sc.next();
            for(int i=0; i<t.length(); i++){
                if(t.charAt(i)==s.charAt(nL))
                    nL++;
                if(nL==s.length())
                    break;
            }
            if(nL==s.length())
                System.out.println("Yes");
            else
                System.out.println("No");
        }while(sc.hasNext());
    }
}
