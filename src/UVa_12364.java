

import java.util.Scanner;

public class UVa_12364 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int x = sc.nextInt();
            if(x==0) break;
            sc.nextLine();
            String type = sc.nextLine();
            if(type.equals("S")){
                String in = sc.nextLine();
                StringBuilder a = new StringBuilder("");
                StringBuilder b = new StringBuilder("");
                StringBuilder c = new StringBuilder("");
                for(int i=0; i<in.length(); i++){
                    char ch = in.charAt(i);
                    switch(ch){
                        case '1':
                            a.append("*.");
                            b.append("..");
                            c.append("..");
                            break;
                        case '2':
                            a.append("*.");
                            b.append("*.");
                            c.append("..");
                            break;
                        case '3':
                            a.append("**");
                            b.append("..");
                            c.append("..");
                            break;
                        case '4':
                            a.append("**");
                            b.append(".*");
                            c.append("..");
                            break;
                        case '5':
                            a.append("*.");
                            b.append(".*");
                            c.append("..");
                            break;
                        case '6':
                            a.append("**");
                            b.append("*.");
                            c.append("..");
                            break;
                        case '7':
                            a.append("**");
                            b.append("**");
                            c.append("..");
                            break;
                        case '8':
                            a.append("*.");
                            b.append("**");
                            c.append("..");
                            break;
                        case '9':
                            a.append(".*");
                            b.append("*.");
                            c.append("..");
                            break;
                        case '0':
                            a.append(".*");
                            b.append("**");
                            c.append("..");
                            break;
                    }
                    if(i<in.length()-1){
                        a.append(" ");
                        b.append(" ");
                        c.append(" ");
                    }
                }
                System.out.println(a+"\n"+b+"\n"+c);
            }
            else{
                String[] a = sc.nextLine().split(" ");
                String[] b = sc.nextLine().split(" ");
                String[] c = sc.nextLine().split(" ");
                StringBuilder out = new StringBuilder("");
                for(int i=0; i<a.length; i++){
                    String cur1 = a[i];
                    String cur2 = b[i];
                    String cur3 = c[i];
                    if(cur1.equals("*.")){
                        if(cur2.equals("..")) out.append("1");
                        else if(cur2.equals("*.")) out.append("2");
                        else if(cur2.equals(".*")) out.append("5");
                        else out.append("8");
                        continue;
                    }
                    if(cur1.equals("**")){
                        if(cur2.equals("..")) out.append("3");
                        else if(cur2.equals(".*")) out.append("4");
                        else if(cur2.equals("*.")) out.append("6");
                        else out.append("7");
                        continue;
                    }
                    if(cur1.equals(".*")){
                        if(cur2.equals("*.")) out.append("9");
                        else out.append("0");
                    }
                }
                System.out.println(out);
            }
        }

    }
}
