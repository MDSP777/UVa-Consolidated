

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class UVa_11616 {
    static int[] points = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static HashMap<Integer, String> importantPoints;
    static HashMap<String, Integer> toArabic;
    
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
        
        toArabic = new HashMap<>();
        
        String[] toRoman = new String[4000];
        for(int i=1; i<4000; i++){
            toRoman[i] = convertToRoman(i);
            toArabic.put(toRoman[i], i);
        }
        do{
            String s = sc.readLine();
            if(s==null) break;
            if(isNumber(s)) sb.append(toRoman[new Integer(s)]+"\n");
            else sb.append(toArabic.get(s)+"\n");
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
    
    static boolean isNumber(String s){
        try{
            int i = new Integer(s);
        } catch(Exception e){
            return false;
        }
        return true;
    }
}
