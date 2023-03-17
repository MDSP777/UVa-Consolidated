

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_642 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> words = new ArrayList();
        String in = sc.nextLine();
        while(!in.equals("XXXXXX")){
            words.add(in);
            in = sc.nextLine();
        }
        String n = sc.nextLine();
        while(!n.equals("XXXXXX")){
            int l = n.length();
            boolean flag = false;
            ArrayList<String> out = new ArrayList();
            int s = words.size();
            for(int i=0; i<s; i++){
                if(l!=words.get(i).length()) continue;
                if(same(n, words.get(i))){
                    out.add(words.get(i));
                    flag = true;
                }
            }
            if(!flag) System.out.println("NOT A VALID WORD");
            else{
                Collections.sort(out);
                int k = out.size();
                for(int i=0; i<k; i++)
                    System.out.println(out.get(i));
            }
            System.out.println("******");
            n = sc.nextLine();
        }
    }
    
    public static boolean same(String a, String b){
        int l = a.length();
        for(int i=0; i<l; i++){
            if(b.contains(a.charAt(i)+"")){
                char c = a.charAt(i);
                a = a.replaceAll(c+"", "");
                b = b.replaceAll(c+"", "");
                i=-1;
                l = a.length();
                if(a.length()!=b.length()) return false;
            }
        }
        if(a.equals("") && b.equals(""))
            return true;
        return false;
    }
}
