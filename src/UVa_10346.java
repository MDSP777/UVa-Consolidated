

import java.util.Scanner;

public class UVa_10346 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            int n = sc.nextInt();
            int k = sc.nextInt();
            int total = n;
            int butts = n;
            while(butts>=k){
                int temp = butts/k;
                total+=temp;
                butts %=k;
                butts+=temp;
            }
            
            System.out.println(total);
        }while(sc.hasNext());
    }
}
