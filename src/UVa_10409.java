

import java.util.Scanner;

public class UVa_10409 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int i = sc.nextInt();
            if(i==0) break;
            Die d = new Die();
            sc.nextLine();
            for(int j=0; j<i; j++){
                d.move(sc.nextLine());
            }
            System.out.println(d.top);
        }
    }
    
    static class Die{
        int top, bottom, n, e, s, w;
        
        public Die(){
            top = 1;
            bottom = 6;
            n = 2;
            s = 5;
            w = 3;
            e = 4;
        }
        
        public void move(String dir){
            if(dir.equals("north")){
                int temp = n;
                n = top;
                top = s;
                s = bottom;
                bottom = temp;
                return;
            }
            if(dir.equals("south")){
                int temp = n;
                n = bottom;
                bottom = s;
                s = top;
                top = temp;
                return;
            }
            if(dir.equals("east")){
                int temp = bottom;
                bottom = e;
                e = top;
                top = w;
                w = temp;
                return;
            }
            if(dir.equals("west")){
                int temp = bottom;
                bottom = w;
                w = top;
                top = e;
                e = temp;
            }
        }
    }
}
