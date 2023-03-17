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
public class UVa_11636 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int nPastes, nLines, nCases = 1;
        
        while(cases >= 0){
            nPastes = 0;
            nLines  = 1;
            while(nLines < cases){
                nLines *=2;
                nPastes++;
            }
            System.out.println("Case " + nCases + ": " + nPastes+"");
            nCases++;
            cases = sc.nextInt();
        }
    }
}
