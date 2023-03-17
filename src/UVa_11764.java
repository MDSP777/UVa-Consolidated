

import java.util.Scanner;

public class UVa_11764 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int i=1; i<=nC; i++){
            int nW = sc.nextInt();
            nW--;
            int h=0, l=0;
            int a = sc.nextInt();
            for(int j=0; j<nW; j++){
                int b = sc.nextInt();
                if(b>a) h++;
                else if(b<a) l++;
                a = b;
            }
            System.out.println("Case "+i+": "+h+" "+l);
        }
    }
}
