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
public class UVa_10970 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt(), i, iTax, income;
        double tax;
        for(i=1; i<=cases; i++){
            tax = 0;
            income = sc.nextInt();
            if(income >= 180000){
                income-=180000;
                if(income >= 300000){
                    income-=300000;
                    tax += 30000;
                    if(income >= 400000){
                        tax += income * 0.15;
                        income-= 400000;
                        if(income >= 300000){
                            tax += income * 0.2;
                            income -= 300000;
                            if(income > 0)
                                tax += income * 0.25;
                        }
                        else
                            tax += income *0.2;
                    }
                    else
                        tax += income * 0.15;

                }
                else if(income > 0)
                    tax += income*0.1;
            }
            
            if(tax < 2000 && tax > 0)
                tax = 2000;
            tax = Math.ceil(tax);
            System.out.println("Case " + i + ": " + (int)tax);
        }
    }
}
