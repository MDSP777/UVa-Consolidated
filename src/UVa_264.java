

import java.util.Scanner;

public class UVa_264 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            int in = sc.nextInt();
            int i=0;
            int n = 0;
            int d = 0;
            int cur = 1;
            boolean flag = true;
            while(i<in){
                if(flag){
                    n = cur;
                    d = 1;
                }else{
                    n = 1;
                    d = cur;
                }
                boolean something = true;
                while(something){
                    if(flag){
                        n--;
                        d++;
                        if(n==0) something = false;
                    }else{
                        n++;
                        d--;
                        if(d==0) something = false;
                    }
                    i++;
                    if(i==in) break;
                }
                cur++;
                flag = !flag;
            }
            if(flag){
                n--;
                d++;
            }else{
                n++;
                d--;
            }
            System.out.println("TERM "+in+" IS "+n+"/"+d);
        }while(sc.hasNext());
    }
}
