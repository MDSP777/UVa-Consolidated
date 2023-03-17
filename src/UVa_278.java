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
public class UVa_278 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        String a;
        char ca;
        int m, n;
        for(int i=0; i<nC; i++){
            a = sc.next();
            ca = a.charAt(0);
            m = sc.nextInt();
            n = sc.nextInt();
            if(ca=='r' || ca=='Q')
                System.out.println(Math.min(m, n));
            else if(ca=='k'){
                if((m*n)%2==0)
                    System.out.println(m*n/2);
                else{
                    System.out.println(m*n/2+1);
                }
            }
            else{
                int max = Math.max(m, n);
                int min = Math.min(m, n);
                if(max%2==0){
                    if(min%2==0)
                        System.out.println(max/2*min/2);
                    else
                        System.out.println(max/2*(min/2+1));
                }
                else{
                    if(min%2==0)
                        System.out.println((max/2+1)*min/2);
                    else
                        System.out.println((max/2+1)*(min/2+1));
                }
            }
        }
    }
}
