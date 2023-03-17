

import java.util.Arrays;
import java.util.Scanner;

public class UVa_10815 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] words = new String[5000];
        int index=0;
        char dump='a';
        String temp, temp2;
        while(sc.hasNext()){
            temp="";
            do{
                try{
                    dump = sc.findInLine(".").charAt(0);
                }
                catch(NullPointerException e){
                    temp2=sc.nextLine();
                    dump='$';
                }
                if((dump>='a' && dump<='z') || (dump>='A' && dump<='Z'))
                    temp += dump;
                /*if(temp.equals("lol"))
                    break;*/
            }while((dump>='a' && dump<='z') || (dump>='A' && dump<='Z'));
            temp = temp.toLowerCase();
           // temp = clean(temp);
            /*if(temp.equals("lol"))
                break;
            else */if(!temp.equals("\n") && !temp.equals("") && not(words, temp, index)){
                words[index] = temp;
                index++;
            }
            
        }
        Arrays.sort(words, 0, index);
        for(int i=0; i<index; i++){
            System.out.println(words[i]);
        }
    }
    
    public static boolean not(String[] words, String temp, int index){
        for(int i=0; i<index; i++)
            if(words[i].equals(temp))
                return false;
        return true;
    }
    
    public static String clean(String word){
        for(int i=0; i<word.length(); i++)
            if(word.charAt(i)<'a' || word.charAt(i)>'z')
                try{
                    word = word.substring(0, i) + word.substring(i+1);
                    i=0;
                }
                catch(NullPointerException e){
                    
                }
        return word;
    }
}
