

import java.util.Scanner;

public class UVa_10127 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            int n = sc.nextInt();
            System.out.println(getDigitCount(n));
        }while(sc.hasNext());

    }
    
    public static int getDigitCount(int n) {
        int current = 1;
        int digitCount = 1;

        while (current % n != 0) {
            current = (current * 10 + 1) % n;
            digitCount++;
        }

        return digitCount;
    }
}
