

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class UVa_1113 {
    static ArrayList<String> morse;
    static ArrayList<String> dict;
    static HashMap<String, Long> memo;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        morse = new ArrayList<>();
        morse.add(".-");
        morse.add("-...");
        morse.add("-.-.");
        morse.add("-..");
        morse.add(".");
        morse.add("..-.");
        morse.add("--.");
        morse.add("....");
        morse.add("..");
        morse.add(".---");
        morse.add("-.-");
        morse.add(".-..");
        morse.add("--");
        morse.add("-.");
        morse.add("---");
        morse.add(".--.");
        morse.add("--.-");
        morse.add(".-.");
        morse.add("...");
        morse.add("-");
        morse.add("..-");
        morse.add("...-");
        morse.add(".--");
        morse.add("-..-");
        morse.add("-.--");
        morse.add("--..");
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            memo = new HashMap<>();
            dict = new ArrayList<>();
            String in = sc.next();
            int nWords = sc.nextInt();
            for(int i=0; i<nWords; i++){
                String cur = sc.next();
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<cur.length(); j++){
                    sb.append(morse.get(cur.charAt(j)-'A'));
                }
                dict.add(sb.toString());
            }
            
            System.out.println(nComb(in));
            if(x!=nC-1) System.out.println("");
        }

    }

    private static long nComb(String in) {
        long total = 0;
        if(memo.containsKey(in)) return memo.get(in);
        for(int i=0; i<in.length(); i++){
            String left = in.substring(0, i+1);
            if(dict.contains(left)){
                if(i+1==in.length()) return total+Collections.frequency(dict, in);
                else {
                    long rem = nComb(in.substring(i+1));
                    rem *= Collections.frequency(dict, left);
                    total += rem;
                }
            }
        }
        memo.put(in, total);
        return total;
    }
}
