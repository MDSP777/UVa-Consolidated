

import java.util.Scanner;

public class UVa_12157 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=1; x<=nC; x++){
            int nCalls = sc.nextInt();
            int mile = 0;
            int juice = 0;
            for(int i=0; i<nCalls; i++){
                int cur = sc.nextInt();
                int cur2 = cur;
                while(cur>29){
                    mile+=10;
                    cur-=30;
                }
                while(cur2>59){
                    juice+=15;
                    cur2-=60;
                }
                mile+=10;
                juice+=15;
            }
            if(mile>juice)
                System.out.println("Case "+x+": Juice "+juice);
            else if(mile<juice)
                System.out.println("Case "+x+": Mile "+mile);
            else System.out.println("Case "+x+": Mile Juice "+mile);
        }
    }
}
