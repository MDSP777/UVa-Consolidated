

import java.util.Scanner;

public class UVa_11291 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            String n = sc.nextLine();
            if(n.equals("()")) break;
            if(n.charAt(0)!='(')
                System.out.printf("%.2f\n", new Double(n));
            else
                System.out.printf("%.2f\n", calculate(n));
        }
    }
    
    static double calculate(String in){
        String n = in.substring(1, in.length()-1);
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        while(n.charAt(i)!=' '){
            sb.append(n.charAt(i));
            i++;
        }
        double p = new Double(sb.toString());
        i++;
        
        sb = new StringBuilder("");
        if(n.charAt(i)!='('){
            while(n.charAt(i)!=' '){
                sb.append(n.charAt(i));
                i++;
            }
        } else{
            int ctr = 0;
            do{
                sb.append(n.charAt(i));
                if(n.charAt(i)=='(') ctr++;
                else if(n.charAt(i)==')') ctr--;
                i++;
            }while(ctr!=0);
        }
        String a = sb.toString();
        i++;
        
        sb = new StringBuilder("");
        if(n.charAt(i)!='('){
            while(n.charAt(i)!=' '){
                sb.append(n.charAt(i));
                i++;
                if(i==n.length()) break;
            }
        } else{
            int ctr = 0;
            do{
                sb.append(n.charAt(i));
                if(n.charAt(i)=='(') ctr++;
                else if(n.charAt(i)==')') ctr--;
                i++;
            }while(ctr!=0);
        }
        String b = sb.toString();
        if(test(a) && test(b)){
            double x = new Integer(a);
            double y = new Integer(b);
            return p*(x+y)+(1-p)*(x-y);
        } else if(test(a)){
            double x = new Integer(a);
            double y = calculate(b);
            return p*(x+y)+(1-p)*(x-y);
        } else if(test(b)){
            double x = calculate(a);
            double y = new Integer(b);
            return p*(x+y)+(1-p)*(x-y);
        } else{
            double x = calculate(a);
            double y = calculate(b);
            return p*(x+y)+(1-p)*(x-y);
        }
    }
    
    static boolean test(String n){
        try{
            new Integer(n);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
