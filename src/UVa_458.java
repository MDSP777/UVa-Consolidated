

import java.util.Scanner;

public class UVa_458 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            String n = sc.nextLine();
            StringBuilder out = new StringBuilder();
            for(int i=0; i<n.length(); i++)
                out.append((char)(n.charAt(i)-7));
            System.out.println(out);
        }while(sc.hasNext());

    }
}
