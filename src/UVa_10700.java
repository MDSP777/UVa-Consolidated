

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_10700 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        sc.nextLine();
        for(int x=0; x<nC; x++){
            String in = sc.nextLine();
            ArrayList<String> eq1 = new ArrayList();
            ArrayList<String> eq2 = new ArrayList();
            for(int i=0; i<in.length(); i++)
                if(in.charAt(i)=='*' || in.charAt(i)=='+'){
                    in = in.substring(0, i) +" "+in.charAt(i)+" "+in.substring(i+1);
                    i+=2;
                }
            String[] split = in.split(" ");
            for(int i=0; i<split.length; i++){
                eq1.add(split[i]);
                eq2.add(split[i]);
            }
            System.out.println("The maximum and minimum are "+compute2(eq2)+" and "+compute1(eq1)+".");
        }
    }
    
    public static String compute1(ArrayList<String> equation){
        for(int i=0; i<equation.size(); i++){
            String cur = equation.get(i);
            if(cur.equals("*")){
                equation.set(i-1, String.valueOf(Long.parseLong(equation.get(i-1))*Long.parseLong(equation.get(i+1))));
                equation.remove(i);
                equation.remove(i);
                i-=2;
            }
        }
        for(int i=0; i<equation.size(); i++){
            String cur = equation.get(i);
            if(cur.equals("+")){
                equation.set(i-1, String.valueOf(Long.parseLong(equation.get(i-1))+Long.parseLong(equation.get(i+1))));
                equation.remove(i);
                equation.remove(i);
                i-=2;
            }
        }
        return equation.get(0);
    }
    
    public static String compute2(ArrayList<String> equation){
        for(int i=0; i<equation.size(); i++){
            String cur = equation.get(i);
            if(cur.equals("+")){
                equation.set(i-1, String.valueOf(Long.parseLong(equation.get(i-1))+Long.parseLong(equation.get(i+1))));
                equation.remove(i);
                equation.remove(i);
                i-=2;
            }
        }
        for(int i=0; i<equation.size(); i++){
            String cur = equation.get(i);
            if(cur.equals("*")){
                equation.set(i-1, String.valueOf(Long.parseLong(equation.get(i-1))*Long.parseLong(equation.get(i+1))));
                equation.remove(i);
                equation.remove(i);
                i-=2;
            }
        }
        return equation.get(0);
    }
}
