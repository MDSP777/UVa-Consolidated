

import java.util.Scanner;

public class UVa_489 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int round = sc.nextInt();
        StringBuilder out = new StringBuilder();
        while(round!=-1){
            int eCorrect = 0;
            int t;
            boolean[] ansArr = new boolean[26];
            boolean[] guessArr = new boolean[26];
            sc.nextLine();
            String ans = sc.nextLine();
            t = ans.length();
            for(int i=0; i<t; i++) {
                int n = ans.charAt(i)-97;
                if(!ansArr[n]) eCorrect++;
                ansArr[n] = true;
            }
            String guess = sc.nextLine();
            t = guess.length();
            for(int i=0; i<t; i++) {
                int n = guess.charAt(i)-97;
                if(guessArr[n]){
                    guess = guess.substring(0, i)+guess.substring(i+1);
                    i--;
                    t--;
                }
                else guessArr[n] = true;
            }
            int tWrongs = 0, tCorrect = 0;
            t = guess.length();
            for(int i=0; i<t; i++){
                if(!ansArr[guess.charAt(i)-97])
                    tWrongs++;
                else tCorrect++;
                if(tCorrect==eCorrect || tWrongs>=7) break;
            }
            out.append("Round "+round+"\n");
            if(tCorrect==eCorrect) out.append("You win.\n");
            else if(tWrongs>=7) out.append("You lose.\n");
            else out.append("You chickened out.\n");
            round = sc.nextInt();
        }
        System.out.print(out);
    }
}