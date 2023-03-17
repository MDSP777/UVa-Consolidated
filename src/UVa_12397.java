

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class UVa_12397 {
    static int[] points = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static HashMap<Integer, String> importantPoints;
    
    public static void main(String[] args) throws IOException{
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        importantPoints = new HashMap<>();
        importantPoints.put(1, "I");
        importantPoints.put(4, "IV");
        importantPoints.put(5, "V");
        importantPoints.put(9, "IX");
        importantPoints.put(10, "X");
        importantPoints.put(40, "XL");
        importantPoints.put(50, "L");
        importantPoints.put(90, "XC");
        importantPoints.put(100, "C");
        importantPoints.put(400, "CD");
        importantPoints.put(500, "D");
        importantPoints.put(900, "CM");
        importantPoints.put(1000, "M");
        
        String[] toRoman = new String[4000];
        int[] counts = new int[4000];
        for(int i=1; i<4000; i++){
            toRoman[i] = convertToRoman(i);
            counts[i] = getMatchCount(toRoman[i]);
        }
        do{
            String s = sc.readLine();
            if(s==null) break;
            sb.append(counts[new Integer(s)]+"\n");
        }while(true);
        System.out.print(sb);
    }
    
    private static String convertToRoman(int num) {
        StringBuilder out = new StringBuilder("");
        while(num>=1){
            int highest = 0;
            for(int i=0; i<points.length; i++){
                if(points[i]<=num){
                    highest = points[i];
                    break;
                }
            }
            out.append(importantPoints.get(highest));
            out.append(convertToRoman(num-highest));
            return out.toString();
        }
        return out.toString();
    }

    private static int getMatchCount(String roman) {
        int l = roman.length();
        int total = 0;
        for(int i=0; i<l; i++){
            char c = roman.charAt(i);
            int val = 0;
            switch(c){
                case 'I': val = 1; break;
                case 'V': val = 2; break;
                case 'X': val = 2; break;
                case 'L': val = 2; break;
                case 'C': val = 2; break;
                case 'D': val = 3; break;
                case 'M': val = 4; break;
            }
            total+=val;
        }
        return total;
    }
}
