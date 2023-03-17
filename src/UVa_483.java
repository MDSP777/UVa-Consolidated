

import java.util.Scanner;

public class UVa_483 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(rev(sc.nextLine()));
        }while(sc.hasNext());
    }
    
    static String rev(String n){
        String[] split = n.split(" ");
        StringBuilder out = new StringBuilder("");
        for(int i=0; i<split.length; i++){
            String cur = split[i];
            StringBuilder temp = new StringBuilder("");
            int l = cur.length()-1;
            for(int j=l; j>=0; j--){
                temp.append(cur.charAt(j));
            }
            out.append(temp+" ");
        }
        return out.toString().substring(0, n.length());
    }
}
