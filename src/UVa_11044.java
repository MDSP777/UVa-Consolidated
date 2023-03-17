

import java.util.Scanner;

public class UVa_11044 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int i=0; i<nC; i++)
            System.out.println((sc.nextInt()/3)*(sc.nextInt()/3));
    }
}
