

import java.util.Scanner;

public class UVa_344 {    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Answer[] answers = new Answer[101];
        answers[1] = new Answer();
        answers[1].i = 1;
        answers[1].val = 1;
        for(int i=2; i<=100; i++){
            Answer curAns = generateRoman(i);
            answers[i] = answers[i-1].add(curAns);
            answers[i].val = i;
        }
        while(true){
            int n = sc.nextInt();
            if(n==0) break;
            System.out.println(answers[n].toString());
        }
    }

    private static Answer generateRoman(int i) {
        Answer ans = new Answer();
        while(i>=100){
            ans.c++;
            i-=100;
        }
        while(i>=90){
            ans.x++;
            ans.c++;
            i-=90;
        }
        while(i>=50){
            ans.l++;
            i-=50;
        }
        while(i>=40){
            ans.l++;
            ans.x++;
            i-=40;
        }
        while(i>=10){
            ans.x++;
            i-=10;
        }
        while(i>=9){
            ans.x++;
            ans.i++;
            i-=9;
        }
        while(i>=5){
            ans.v++;
            i-=5;
        }
        while(i>=4){
            ans.i++;
            ans.v++;
            i-=4;
        }
        while(i>=1){
            ans.i++;
            i--;
        }
        return ans;
    }
    
    static class Answer{
        int val;
        int i;
        int v;
        int x;
        int l;
        int c;
        
        public Answer(){
            i = v = x = l = c = 0;
        }
        
        public String toString(){
            return val+": "+i+" i, "+v+" v, "+x+" x, "+l+" l, "+c+" c";
        }
        
        public Answer add(Answer o){
            Answer newAnswer = new Answer();
            newAnswer.i = this.i+o.i;
            newAnswer.v = this.v+o.v;
            newAnswer.x = this.x+o.x;
            newAnswer.l = this.l+o.l;
            newAnswer.c = this.c+o.c;
            return newAnswer;
        }
    }
}
