

import java.util.Scanner;

public class UVa_12748 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nc = sc.nextInt();
        for(int x=1; x<=nc; x++){
            int nWifi = sc.nextInt();
            int nLocs = sc.nextInt();
            System.out.println("Case "+x+":");
            Circle[] routers = new Circle[nWifi];
            for(int i=0; i<nWifi; i++)
                routers[i] = new Circle(sc.nextInt(), sc.nextInt(), sc.nextInt());
            for(int i=0; i<nLocs; i++){
                boolean flag = false;
                int curX = sc.nextInt();
                int curY = sc.nextInt();
                for(int j=0; j<nWifi; j++)
                    if(routers[j].inCircle(curX, curY)){
                        System.out.println("Yes");
                        flag = true;
                        break;
                    }
                if(!flag) System.out.println("No");
            }
        }
    }
    
    static class Circle{
        int x, y, r;
        
        public Circle(int x, int y, int r){
            this.x = x;
            this.y = y;
            this.r = r;
        }
        
        public boolean inCircle(int x, int y){
            if(Math.hypot(this.x-x, this.y-y)>r) return false;
            return true;
        }
    }
}
