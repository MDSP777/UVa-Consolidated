

import java.util.Scanner;

public class UVa_1585 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        sc.nextLine();
        for(int x=0; x<nC; x++){
            String in = sc.nextLine();
            int total = 0;
            int buffer = 0;
            for(int i=0; i<in.length(); i++){
                char c = in.charAt(i);
                if(c=='O'){
                    total++;
                    total+=buffer;
                    buffer++;
                }
                else buffer = 0;
            }
            System.out.println(total);
        }
    }
}
