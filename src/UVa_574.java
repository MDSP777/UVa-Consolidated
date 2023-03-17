

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class UVa_574 {
    static int[] terms;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int goal = sc.nextInt();
            int n = sc.nextInt();
            if(goal==0 && n==0) break;
            terms = new int[n];
            for(int i=0; i<n; i++) terms[i] = sc.nextInt();
            HashSet<String> a = getAnswers(goal, 0);
            ArrayList<String> ans = new ArrayList<>(a);
            Collections.sort(ans);
            Collections.reverse(ans);
            System.out.println("Sums of "+goal+":");
            if(ans.isEmpty()) System.out.println("NONE");
            else
                for(String sb: ans){
                    System.out.println(sb.substring(1));
                }
        }

    }
    
    static HashSet<String> getAnswers(int goal, int sIndex){
        HashSet<String> answers = new HashSet<>();
        if(goal<=0) return answers;
        if(sIndex==terms.length-1){
            if(terms[sIndex]==goal){
                answers.add("+"+goal);
                return answers;
            }
        }
        for(int i=sIndex; i<terms.length; i++){
            if(terms[i]==goal){
                answers.add("+"+goal);
            }
            else {
                HashSet<String> ans = getAnswers(goal-terms[i], i+1);
                for(String sb: ans){
                    answers.add("+"+terms[i]+sb);
                }
            }
        }
        return answers;
    }
}
