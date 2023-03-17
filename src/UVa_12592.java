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
public class UVa_12592 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String dump = sc.nextLine(), a;
        Slogan[] s = new Slogan[n];
        for(int i=0; i<n; i++){
            s[i] = new Slogan(sc.nextLine(), sc.nextLine());
        }
        
        int n2 = sc.nextInt();
        dump = sc.nextLine();
        for(int i=0; i<n2; i++){
            a = sc.nextLine();
            for(int j=0; j<n; j++)
                if(a.equals(s[j].a))
                    System.out.println(s[j].b);
        }
    }
    
    public static class Slogan{
        String a, b;
        
        public Slogan(String a, String b){
            this.a = a;
            this.b = b;
        }
    }
}
