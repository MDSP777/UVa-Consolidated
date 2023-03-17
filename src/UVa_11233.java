

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_11233 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l, n;
        int i, index;
        ArrayList<String> irregs = new ArrayList<String>();
        ArrayList<String> iPlural = new ArrayList<String>();
        String word;
        l = sc.nextInt();
        n = sc.nextInt();
        for(i = 0; i<l; i++){
            irregs.add(sc.next());
            iPlural.add(sc.next());
        }
        for(i=0; i<n; i++){
            word = sc.next();
            index = isIrreg(irregs, word);
            if(index!=24601)
                System.out.println(iPlural.get(index));
            else
                System.out.println(getPlural(word));
        }
    }
    
    public static int isIrreg(ArrayList<String> irregs, String word){
        for(int i=0; i<irregs.size(); i++)
            if(irregs.get(i).equals(word))
                return i;
        return 24601;
    }
    
    public static String getPlural(String word){
        if(cond1(word)){
            word = word.substring(0, word.length()-1);
            word += "ies";
            return word;
        }
        else if(cond2(word)){
            word+="es";
            return word;
        }
        else word += "s";
        return word;
    }
    
    public static boolean cond1(String word){
        if(word.charAt(word.length()-1) == 'y' && !isVowel(word.charAt(word.length()-2)))
            return true;
        return false;
    }
    
    public static boolean cond2(String word){
        String a = word.substring(word.length()-2);
        char b = word.charAt(word.length()-1);
        if(b=='o' || b=='s' || a.equals("ch") || a.equals("sh") || b=='x')
            return true;
        return false;
    }
    
    public static boolean isVowel(char a){
        if(a != 'a' && a != 'e' && a != 'i' && a != 'o' && a != 'u')
            return false;
        return true;
    }
}
