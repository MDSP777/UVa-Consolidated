/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MarcDominic
 */
public class UVa_10931 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nCase = sc.nextInt();
        
        while(nCase != 0){
            System.out.print("The parity of ");
            printBinary(nCase);
            System.out.println(" is " + getSumOfBinaryDigits(nCase) + " (mod 2).");
            nCase = sc.nextInt();
        }
    }
    
    public static void printBinary(int i){
        ArrayList<Integer> binary = new ArrayList<Integer>();
        while(i>0){
            binary.add(i%2);
            i /= 2;
        }
        for(i = binary.size()-1; i >= 0; i--)
            System.out.print(binary.get(i));
    }
    
    public static int getSumOfBinaryDigits(int i){
        int total = 0;
        while(i>0){
            total += (i%2);
            i /= 2;
        }
        
        return total;
    }
}
