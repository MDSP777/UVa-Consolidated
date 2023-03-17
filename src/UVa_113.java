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
public class UVa_113 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double n, p;
        do{
            n = sc.nextDouble();
            p = sc.nextDouble();
            System.out.println((int)Math.round(Math.pow(p, 1/n)));
        }while(sc.hasNext());
    }
}


