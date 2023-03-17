

import java.util.Scanner;

public class UVa_10205 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            Deck d = new Deck();
            int nShufs = sc.nextInt();
            int[][] shufs = new int[nShufs][52];
            for(int i=0; i<nShufs; i++)
                for(int j=0; j<52; j++)
                    shufs[i][j] = sc.nextInt();
            sc.nextLine();
            String in = sc.nextLine();
            while(!in.equals("")){
                d.shuffle(shufs[Integer.parseInt(in)-1]);
                if(!sc.hasNext()) break;
                in = sc.nextLine();
            }
            for(int i=0; i<52; i++)
                System.out.println(d.cards[i]);
            if(x<nC-1) System.out.println("");
        }
    }
    
    static class Deck{
        String[] cards;
        String[] vals = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        
        public Deck(){
            cards = new String[52];
            int in = 0;
            for(int i=0; i<4; i++)
                for(int j=0; j<13; j++){
                    cards[in] = vals[j] + " of " + suits[i];
                    in++;
                }
        }
        
        public void shuffle(int[] shuf){
            Deck d = new Deck();
            for(int i=0; i<shuf.length; i++)
                d.cards[i] = cards[shuf[i]-1];
            this.cards = d.cards;
        }
    }
}
