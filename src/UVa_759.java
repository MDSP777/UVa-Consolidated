

import java.util.HashMap;
import java.util.Scanner;

public class UVa_759 {
    static HashMap<String, Integer> values = new HashMap<>();
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        generateRomans();
        do{
            String in = sc.nextLine().trim();
            System.out.println(values.get(in)==null ? "This is not a valid number" : values.get(in));
        }while(sc.hasNext());

    }
 
    static void generateRomans(){
        for(int i=0; i<4000; i++){
            String roman = "";
            int cur = i;
            int l = cur/1000;
            for(int j=0; j<l; j++) roman+="M";
            cur%=1000;
            if(cur>=900) {
                roman+="CM";
                cur-=900;
            }
            if(cur>=500){
                roman+="D";
                cur-=500;
            }
            if(cur>=400){
                roman+="CD";
                cur-=400;
            }
            l = cur/100;
            for(int j=0; j<l; j++) roman+="C";
            cur%=100;
            if(cur>=90) {
                roman+="XC";
                cur-=90;
            }
            if(cur>=50){
                roman+="L";
                cur-=50;
            }
            if(cur>=40){
                roman+="XL";
                cur-=40;
            }
            l = cur/10;
            for(int j=0; j<l; j++) roman+="X";
            cur%=10;
            if(cur>=9) {
                roman+="IX";
                cur-=9;
            }
            if(cur>=5){
                roman+="V";
                cur-=5;
            }
            if(cur>=4){
                roman+="IV";
                cur-=4;
            }
            l = cur;
            for(int j=0; j<l; j++) roman+="I"; 
            values.put(roman, i);
        }
    }
}
