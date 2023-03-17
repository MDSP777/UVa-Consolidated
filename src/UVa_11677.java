

import java.util.Scanner;

public class UVa_11677 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int h1 = sc.nextInt(), m1 = sc.nextInt(), h2 = sc.nextInt(), m2 = sc.nextInt();
            int total = 0;
            if(h1==0&&m1==0&&h2==0&&m2==0)
                break;
            if(m2>=m1){
                if(h2>=h1) total = (h2-h1)*60+m2-m1;
                else total = (24-h1+h2)*60+m2-m1;
            }
            else{
                if(h2>h1) total = (h2-h1-1)*60+(60-m1+m2);
                else total = (23-h1+h2)*60+(60-m1+m2);
            }
            System.out.println(total);
        }
    }
}
