

import java.util.Scanner;

public class UVa_573 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            double wellHeight = sc.nextDouble();
            if(wellHeight==0) break;
            double climbableDist = sc.nextDouble();
            double slideDist = sc.nextDouble();
            double fatigue = sc.nextDouble()/100;
            fatigue *= climbableDist;
            int day = 1;
            double total = 0;
            while(true){
                total += climbableDist;
                if(total>wellHeight){
                    System.out.println("success on day "+day);
                    break;
                }
                total -= slideDist;
                if(total<0){
                    System.out.println("failure on day "+day);
                    break;
                }
                climbableDist -= fatigue;
                if(climbableDist<0) climbableDist = 0;
                day++;
            }
        }

    }
}
