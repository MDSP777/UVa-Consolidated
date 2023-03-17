

import java.util.Scanner;


public class UVa_11494 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Point p1 = new Point(sc.nextInt(), sc.nextInt());
        Point p2 = new Point(sc.nextInt(), sc.nextInt());
        while(!(p1.x==0 && p1.y==0 && p2.x==0 && p2.y==0)){
            if(p1.zeroMoves(p2)) System.out.println("0");
            else if(p1.oneMove(p2)) System.out.println("1");
            else System.out.println("2");
            p1 = new Point(sc.nextInt(), sc.nextInt());
            p2 = new Point(sc.nextInt(), sc.nextInt());
        }
    }
    
    public static class Point{
        int x, y;
        
        public Point(int a, int b){
            x=a;
            y=b;
        }
        
        public boolean zeroMoves(Point p2){
            if(this.x==p2.x && this.y==p2.y) return true;
            return false;
        }
        
        public boolean oneMove(Point p2){
            if(this.x==p2.x || this.y==p2.y)
                return true;
            if(Math.abs(this.x-p2.x)==Math.abs(this.y-p2.y))
                return true;
            return false;
        }
    }
}
