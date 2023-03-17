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
public class UVa_10783 {
    public static boolean isPrime(int a){
        if(a == 1)
            return false;
        for(int i = 2; i < a; i++)
            if(a%i==0)
                return false;
        return true;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), total;
        char curr;
        String asdf, trash;
        String out;
        char[] out2;
        trash = sc.nextLine();
        
        for (int i = 1; i <= x; i++) {
            out = "";
            asdf = sc.nextLine();
            System.out.print("Case " + i + ": ");
            while(!asdf.isEmpty()){
                total = 0;
                curr = asdf.charAt(0);
                for(int i3 = 0; i3 < asdf.length() && asdf.charAt(i3) == curr; i3++)
                        total++;
                asdf = asdf.replaceAll(curr+ "", "");
                if(isPrime(total))
                    out += curr;
            }
            if(!out.isEmpty()){
                out2 = out.toCharArray();
                for(int x2=0; x2<out.length(); x2++){
                    for(int y=0; y<out.length()-1; y++){
                        if(out2[y]>out2[y+1]){
                            char temp = out2[y+1];
                            out2[y+1] = out2[y];
                            out2[y] = temp;
                        }
                    }
                }
                for(int y=0; y<out.length(); y++)
                    System.out.print(out2[y]);
            }
            else
                System.out.print("empty");
            System.out.print("\n");
        }
    }
}
