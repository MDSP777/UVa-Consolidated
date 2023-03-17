

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class UVa_10062 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do {
            char[] in = sc.nextLine().toCharArray();
            ArrayList<Answer> answers = new ArrayList<>();
            HashMap<Character, Answer> map = new HashMap<>();
            
            for(int i=0; i<in.length; i++){
                char cur = in[i];
                if(!map.containsKey(cur)){
                    Answer ans = new Answer(cur);
                    answers.add(ans);
                    map.put(cur, ans);
                }
                Answer a = map.get(cur);
                a.count++;
            }
            Collections.sort(answers);
            for(int i=0; i<answers.size(); i++){
                System.out.println(answers.get(i));
            }
            if(sc.hasNext())System.out.println("");
        } while(sc.hasNext());

    }
    
    static class Answer implements Comparable<Answer> {
        int c;
        int count;
        
        public Answer(int c){
            this.c = c;
            count = 0;
        }
        
        @Override
        public String toString(){
            return c+" "+count;
        }

        @Override
        public int compareTo(Answer o) {
            if(this.count<o.count) return -1;
            else if(this.count>o.count) return 1;
            else {
                if(this.c>o.c) return -1;
                else if(this.c<o.c) return 1;
                else return 0;
            }
        }
    }
}
