

import java.util.Scanner;

public class UVa_10924 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            long total = 0;
            String n = sc.nextLine();
            for(int i=0; i<n.length(); i++){
                char c = n.charAt(i);
                if(c>=65 && c<=90) total+=c-38;
                else if(c>=97 && c<=122) total+=c-96;
            }
            if(prime(total)) System.out.println("It is a prime word.");
            else System.out.println("It is not a prime word.");
        }while(sc.hasNext());
    }
    
    public static boolean prime(long total){
        double root = Math.sqrt(total);
        for(int i=2; i<=root; i++)
            if(total%i==0) return false;
        return true;
    }
}
