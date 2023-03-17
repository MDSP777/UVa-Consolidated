

import java.util.Scanner;

public class UVa_10115 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nRules = sc.nextInt();
        String modText, dump = sc.nextLine();
        Rule[] rules;
        while(nRules!=0){
            rules = new Rule[nRules];
            for(int i=0; i<nRules; i++){
                rules[i] = new Rule();
                rules[i].find = sc.nextLine();
                rules[i].replace = sc.nextLine();
            }
            modText = sc.nextLine();
            fix(modText, rules);
            
            nRules = sc.nextInt();
            dump = sc.nextLine();
        }
    }
    
    public static void fix(String modText, Rule[] rules){
        int findL;
        String sub="";
        for(int i=0; i<rules.length; i++){
            findL = rules[i].find.length();
            for(int j=0; j<modText.length(); j++){
                sub="";
                if(j+findL<=modText.length())
                    sub = modText.substring(j, j+findL);
                if(sub.equals(rules[i].find)){
                    modText = modText.substring(0, j) + rules[i].replace + modText.substring(j+findL);
                    j=0;
                }
            }
        }
        System.out.println(modText);
    }
    
    public static class Rule{
        String find, replace;
    }
}
