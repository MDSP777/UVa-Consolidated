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
public class UVa_12136 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nCases = sc.nextInt();
        int wS, wE, mS, mE;
        String g, dump = sc.nextLine();
        String[] gg;
        for(int i=1; i<=nCases; i++){
            g = sc.next();
            gg = g.split(":");
            wS = Integer.parseInt(gg[0])*100+Integer.parseInt(gg[1]);
            g = sc.next();
            gg = g.split(":");
            wE = Integer.parseInt(gg[0])*100+Integer.parseInt(gg[1]);
            g = sc.next();
            gg = g.split(":");
            mS = Integer.parseInt(gg[0])*100+Integer.parseInt(gg[1]);
            g = sc.next();
            gg = g.split(":");
            mE = Integer.parseInt(gg[0])*100+Integer.parseInt(gg[1]);
            if(wS>mS){
                if(mE<wS){
                    System.out.println("Case "+i+": Hits Meeting");
                }
                else
                    System.out.println("Case "+i+": Mrs Meeting");
            }
            else if(wS<mS){
                if(wE<mS){
                    System.out.println("Case "+i+": Hits Meeting");
                }
                else
                    System.out.println("Case "+i+": Mrs Meeting");
            }
            else
                System.out.println("Case "+i+": Mrs Meeting");
        }
    }
}
