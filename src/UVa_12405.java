

import java.util.Scanner;

public class UVa_12405 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=1; x<=nC; x++){
            int l = sc.nextInt();
            sc.nextLine();
            int total = 0;
            char[] field = sc.nextLine().toCharArray();
            for(int i=1; i<l; i++){
                if(field[i-1]=='.'){
                    total++;
                    field[i-1] = field[i] = '#';
                    if(i<l-1)
                        field[i+1] = '#';
                } else if(i==l-1 && field[i]=='.')
                    total++;
            }
            System.out.println("Case "+x+": "+total);
        }

    }
}
