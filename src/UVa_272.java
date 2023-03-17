

import java.util.Scanner;

public class UVa_272 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        boolean first = true;
        do{
            String n = sc.nextLine();
            for(int i=0; i<n.length(); i++){
                char c = n.charAt(i);
                if(c==34){
                    if(first) out.append("``");
                    else out.append("''");
                    first = !first;
                }
                else out.append(c);
                
            }
            out.append("\n");
        }while(sc.hasNext());
        System.out.print(out);
    }
}
