/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MarcDominic
 */
public class UVa_10391 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] letters = new int[26];
        for(int i=0; i<26; i++)
            letters[i] = 0;
        ArrayList<String> words = new ArrayList<String>();
        String n;
        char curr = 'a';
        do{
            n = sc.next();
            if(n.charAt(0)!=curr)
                curr = n.charAt(0);
            letters[curr-'a']++;    
            words.add(n);   
        }while(/*!n.equals("zzz")*/sc.hasNext());
        for(int i=0; i<words.size(); i++){
            checkComp(words, words.get(i), letters);
        } 
    }
    
    public static void checkComp(ArrayList<String> words, String n, int[] indexes){
        String extra = "thestringhasnotbeenmodified";
        int start=0, end, i;
        for(i=0; i<n.charAt(0)-'a'; i++){
            start+=indexes[i];
        }
        end = start + indexes[n.charAt(0)-'a'];
        for(i=start; i<end; i++){
            if(n.length()>words.get(i).length())
                if(n.substring(0, words.get(i).length()).equals(words.get(i))){
                    extra = n.substring(words.get(i).length());
                    if(getS(words, extra, indexes)){
                        System.out.println(n);
                        break;
                    }
                }
        }
    }
    
    public static boolean getS(ArrayList<String> words, String extra, int[] indexes){
        int i, start, end;
        start = 0;
        for(i=0; i<extra.charAt(0)-'a'; i++){
            start+=indexes[i];
        }
        end = start + indexes[extra.charAt(0)-'a'];
        for(i=start; i<end; i++)
            if(extra.equals(words.get(i))){
                return true;
            }
        return false;
    }
}
