import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UVa_10875 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            String d = sc.nextLine();
            String e = sc.nextLine();
            String inter = interpret(a.split(" "), b.split(" "), c.split(" "), d.split(" "), e.split(" "));
            if(inter.equals("0")) break;
            ArrayList<String> eq = new ArrayList((Arrays.asList(inter.split(" "))));
            sc.nextLine();
            printDigits(compute(eq));
        }
    }
    
    public static String interpret(String[] a, String[] b, String[] c, String[] d, String[] e){
        String[] ans = new String[a.length];
        StringBuilder out = new StringBuilder("");
        for(int i=0; i<a.length; i++){
            ans[i] = toChar(a[i], b[i], c[i], d[i], e[i]);
            if(ans[i].equals("+")||ans[i].equals("-")||ans[i].equals("*")||ans[i].equals("/"))
                out.append(" "+ans[i]+" ");
            else
                out.append(ans[i]);
        }
        return out.toString();
    }
    
    public static String toChar(String a, String b, String c, String d, String e){
        if(a.equals("000")){
            if(c.equals("0.0")) return "0";
            if(c.equals("..0")) return "7";
            if(c.equals("000")){
                if(e.equals("..0")) return "9";
                if(d.equals("0.0")) return "8";
                if(d.equals("0..")) return "2";
                if(b.equals("..0")) return "3";
                if(b.equals("0..")) return "5";
            }
        }
        else if(a.equals(".0.")){
            if(b.equals("...")) return "/";
            if(c.equals("000")) return "+";
            if(c.equals(".0.")) return "1";
        }
        else if(a.equals("0..")) return "6";
        else if(a.equals("0.0")){
            if(c.equals("000")) return "4";
            if(c.equals(".0.")) return "*";
        }
        return "-";
    }
    
    public static String compute(ArrayList<String> equation){
        for(int i=0; i<equation.size(); i++){
            String cur = equation.get(i);
            if(cur.equals("*")){
                equation.set(i-1, String.valueOf(Integer.parseInt(equation.get(i-1))*Integer.parseInt(equation.get(i+1))));
                equation.remove(i);
                equation.remove(i);
                i-=2;
            }
            else if(cur.equals("/")){
                equation.set(i-1, String.valueOf(Integer.parseInt(equation.get(i-1))/Integer.parseInt(equation.get(i+1))));
                equation.remove(i);
                equation.remove(i);
                i-=2;
            }
        }
        for(int i=0; i<equation.size(); i++){
            String cur = equation.get(i);
            if(cur.equals("+")){
                equation.set(i-1, String.valueOf(Integer.parseInt(equation.get(i-1))+Integer.parseInt(equation.get(i+1))));
                equation.remove(i);
                equation.remove(i);
                i-=2;
            }
            else if(cur.equals("-")){
                equation.set(i-1, String.valueOf(Integer.parseInt(equation.get(i-1))-Integer.parseInt(equation.get(i+1))));
                equation.remove(i);
                equation.remove(i);
                i-=2;
            }
        }
        return equation.get(0);
    }
    
    public static void printDigits(String n){
        int asdf = Integer.parseInt(n);
        n = String.valueOf(asdf);
        StringBuilder a = new StringBuilder("");
        StringBuilder b = new StringBuilder("");
        StringBuilder c = new StringBuilder("");
        StringBuilder d = new StringBuilder("");
        StringBuilder e = new StringBuilder("");
        for(int i=0; i<n.length(); i++){
            char cur = n.charAt(i);
            switch(cur){
                case '0': a.append("000");
                          b.append("0.0");
                          c.append("0.0");
                          d.append("0.0");
                          e.append("000");
                          break;
                case '1': a.append(".0.");
                          b.append(".0.");
                          c.append(".0.");
                          d.append(".0.");
                          e.append(".0.");
                          break;
                case '2': a.append("000");
                          b.append("..0");
                          c.append("000");
                          d.append("0..");
                          e.append("000");
                          break;
                case '3': a.append("000");
                          b.append("..0");
                          c.append("000");
                          d.append("..0");
                          e.append("000");
                          break;
                case '4': a.append("0.0");
                          b.append("0.0");
                          c.append("000");
                          d.append("..0");
                          e.append("..0");
                          break;
                case '5': a.append("000");
                          b.append("0..");
                          c.append("000");
                          d.append("..0");
                          e.append("000");
                          break;
                case '6': a.append("0..");
                          b.append("0..");
                          c.append("000");
                          d.append("0.0");
                          e.append("000");
                          break;    
                case '7': a.append("000");
                          b.append("..0");
                          c.append("..0");
                          d.append("..0");
                          e.append("..0");
                          break;
                case '8': a.append("000");
                          b.append("0.0");
                          c.append("000");
                          d.append("0.0");
                          e.append("000");
                          break;
                case '9': a.append("000");
                          b.append("0.0");
                          c.append("000");
                          d.append("..0");
                          e.append("..0");
                          break;
                case '-': a.append("...");
                          b.append("...");
                          c.append("000");
                          d.append("...");
                          e.append("...");
                          break;
            }
            if(i<n.length()-1){
                a.append(" ");
                b.append(" ");
                c.append(" ");
                d.append(" ");
                e.append(" ");
            }
        }
        System.out.println(a+"\n"+b+"\n"+c+"\n"+d+"\n"+e+"\n");
    }
}