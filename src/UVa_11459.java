

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_11459 {
    static ArrayList<Obstacle> o;
    static boolean gameOver;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            int nPlayers = sc.nextInt();
            int nObs = sc.nextInt();
            gameOver = false;
            int nRolls = sc.nextInt();
            Player[] players = new Player[nPlayers];
            for(int i=0; i<nPlayers; i++) players[i] = new Player();
            o = new ArrayList();
            for(int i=0; i<nObs; i++) o.add(new Obstacle(sc.nextInt(), sc.nextInt()));
            int curIndex = 0;
            for(int i=0; i<nRolls; i++){
                int curRoll = sc.nextInt();
                if(!gameOver){
                    players[curIndex].move(curRoll);
                    curIndex++;
                    if(curIndex==nPlayers) curIndex = 0;
                }
            }
            for(int i=0; i<nPlayers; i++) System.out.println("Position of player "+(i+1)+" is "+players[i].pos+".");
        }
    }
    
    static class Player{
        int pos;
        
        public Player(){
            pos = 1;
        }
        
        public void move(int amount){
            pos += amount;
            if(pos>=100){
                pos = 100;
                gameOver = true;
                return;
            }
            for(Obstacle cur: o)
                if(cur.start==pos){
                    pos = cur.end;
                    if(pos>=100){
                        pos = 100;
                        gameOver = true;
                    }
                    break;
                }
        }
    }
    
    static class Obstacle{
        int start;
        int end;
        
        public Obstacle(int a, int b){
            start = a;
            end = b;
        }
    }
}
