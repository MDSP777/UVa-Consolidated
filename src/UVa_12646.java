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
public class UVa_12646 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        char ans;
        do{
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            if(a==0){
                if(b==0){
                    if(c==0) ans = '*';
                    else ans = 'C';
                }
                else{
                    if(c==0) ans = 'B';
                    else ans = 'A';
                }
            }
            else{
                if(b==0){
                    if(c==0) ans = 'A';
                    else ans = 'B';
                }
                else{
                    if(c==0) ans = 'C';
                    else ans = '*';
                }
            }
            System.out.println(ans);
        }while(sc.hasNext());
    }
}
