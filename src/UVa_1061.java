

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_1061 {
    static boolean[][] visited;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nc = 1;
        while(true){
            String p1 = sc.next();
            String p2 = sc.next();
            String c = sc.next();
            if(p1.equals("E") && p2.equals("N") && c.equals("D")) break;
            visited = new boolean[100][100];
            ArrayList<String> ans = new ArrayList();
            if(c.equals("?")){
                getAns(p1, p2, ans);
            } else{
                if(p1.equals("?")){
                    String[] blood = {"A", "B", "AB", "O"};
                    for(int a=0; a<4; a++){
                        ArrayList<String> ar = new ArrayList();
                        getAns(blood[a]+"+", p2, ar);
                        if(ar.contains(c)) ans.add(blood[a]+"+");
                        ar = new ArrayList();
                        getAns(blood[a]+"-", p2, ar);
                        if(ar.contains(c)) ans.add(blood[a]+"-");
                    }
                } else{
                    String[] blood = {"A", "B", "AB", "O"};
                    for(int a=0; a<4; a++){
                        ArrayList<String> ar = new ArrayList();
                        getAns(p1, blood[a]+"+", ar);
                        if(ar.contains(c)) ans.add(blood[a]+"+");
                        ar = new ArrayList();
                        getAns(p1, blood[a]+"-", ar);
                        if(ar.contains(c)) ans.add(blood[a]+"-");
                    }
                }
            }
            Collections.sort(ans);
            System.out.print("Case "+nc+++": ");
            if(ans.isEmpty()){
                if(p1.equals("?"))
                    System.out.println("IMPOSSIBLE "+p2+" "+c);
                else if(p2.equals("?"))
                    System.out.println(p1+" IMPOSSIBLE "+c);
                else System.out.println(p1+" "+p2+" IMPOSSIBLE");
            }else if(ans.size()==1){
                if(p1.equals("?"))
                    System.out.println(ans.get(0).toString()+" "+p2+" "+c);
                else if(p2.equals("?"))
                    System.out.println(p1+" "+ans.get(0).toString()+" "+c);
                else System.out.println(p1+" "+p2+" "+ans.get(0).toString());
            }
            else{
                if(p1.equals("?"))
                    System.out.println("{"+ans.toString().substring(1, ans.toString().length()-1)+"} "
                                        +p2+" "+c);
                else if(p2.equals("?"))
                    System.out.println(p1+" {"+ans.toString().substring(1, ans.toString().length()-1)+"} "+c);
                else System.out.println(p1+" "+p2+" {"+ans.toString().substring(1, ans.toString().length()-1)+"}");
            }
        }

    }
    
    static String getABO(char a1, char a2){
        if(a1=='A'){
            if(a2=='B') return "AB";
            else return "A";
        } else if(a1=='B'){
            if(a2=='A') return "AB";
            else return "B";
        } else{
            if(a2=='A') return "A";
            else if(a2=='B') return "B";
            else return "O";
        }
    }

    private static void getAns(String p1, String p2, ArrayList<String> ans) {
        char[] p1a;
        String temp = p1.substring(0, p1.length()-1);
        if(temp.equals("A")){
            p1a = new char[2];
            p1a[0] = 'A';
            p1a[1] = 'O';
        } else if(temp.equals("B")){
            p1a = new char[2];
            p1a[0] = 'B';
            p1a[1] = 'O';
        } else if(temp.equals("AB")){
            p1a = new char[2];
            p1a[0] = 'A';
            p1a[1] = 'B';
        } else{
            p1a = new char[1];
            p1a[0] = 'O';
        }

        char[] p2a;
        temp = p2.substring(0, p2.length()-1);
        if(temp.equals("A")){
            p2a = new char[2];
            p2a[0] = 'A';
            p2a[1] = 'O';
        } else if(temp.equals("B")){
            p2a = new char[2];
            p2a[0] = 'B';
            p2a[1] = 'O';
        } else if(temp.equals("AB")){
            p2a = new char[2];
            p2a[0] = 'A';
            p2a[1] = 'B';
        } else{
            p2a = new char[1];
            p2a[0] = 'O';
        }

        char p1s  = p1.substring(p1.length()-1).charAt(0);
        char p2s = p2.substring(p2.length()-1).charAt(0);

        for(int i=0; i<p1a.length; i++)
            for(int j=0; j<p2a.length; j++){
                String cur = getABO(p1a[i], p2a[j]);
                if(p1s=='+' || p2s=='+'){
                    if(!ans.contains((cur+"+")))
                        ans.add(cur+"+");
                }
                if(!ans.contains(cur+"-"))
                    ans.add(cur+"-");
            }
    }
}
