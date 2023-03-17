

import java.util.Scanner;

public class UVa_409 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nKeys, nExcuses, max, n=1;
        int[] vals;
        String[] keys, excuses, split, cleaner;
        String dump;
        do{
            max = 0;
            nKeys = sc.nextInt();
            nExcuses = sc.nextInt();
            dump = sc.nextLine();
            keys = new String[nKeys];
            excuses = new String[nExcuses];
            cleaner = new String[nExcuses];
            vals = new int[nExcuses];
            for(int i=0; i<nKeys; i++){
                keys[i] = sc.nextLine();
                keys[i] = keys[i].toLowerCase();
            }
            for(int i=0; i<nExcuses; i++){
                excuses[i] = sc.nextLine();
                cleaner[i] = clean(excuses[i]);
            }
            
            for(int i=0; i<nExcuses; i++){
                split = cleaner[i].split(" ");
                for(int j=0; j<split.length; j++){
                    split[j] = split[j].toLowerCase();
                    if(isExcuse(keys, split[j]))
                       vals[i]++;
                }
                if(vals[i]>max)
                    max = vals[i];
            }
            System.out.println("Excuse Set #" + n);
            for(int i=0; i<excuses.length; i++)
                if(vals[i]==max)
                    System.out.println(excuses[i]);
            System.out.println();
            n++;
        }while(sc.hasNext());
    }
    
    public static String clean(String word){
        word = word.replaceAll("[^a-zA-Z]", " ");
        return word;
    }
    
    public static boolean isExcuse(String[] keys, String word){
        for(int i=0; i<keys.length; i++)
            if(word.equals(keys[i]))
                return true;
        return false;
    }
}
