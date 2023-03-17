

import java.util.Scanner;

public class UVa_499 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            Letter[] letters = new Letter[52];
            for(int i=0; i<26; i++){
                letters[i] = new Letter((char)(65+i));
                letters[26+i] = new Letter((char)(97+i));
            }
            String in = sc.nextLine().replaceAll("[^a-zA-Z]", "");
            int l = in.length();
            for(int i=0; i<l; i++){
                char c = in.charAt(i);
                if(c>='a') letters[c-97+26].freq++;
                else letters[c-65].freq++;
            }
            sort(letters);
            int max = letters[0].freq;
            int i=0;
            while(letters[i].freq==max){
                System.out.print(letters[i].l);
                i++;
            }
            System.out.println(" "+max);
        }while(sc.hasNext());

    }
    
    static void sort(Letter[] l){
        for(int i=0; i<l.length; i++)
            for(int j=0; j<l.length-i-1; j++)
                if(l[j].freq<l[j+1].freq){
                    Letter temp = l[j];
                    l[j] = l[j+1];
                    l[j+1] = temp;
                }
    }
    
    static class Letter{
        char l;
        int freq;
        
        public Letter(char a){
            l = a;
            freq = 0;
        }
    }
}
