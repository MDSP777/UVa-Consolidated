

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UVa_10041 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            int nInput = sc.nextInt();
            List<Integer> houses = new ArrayList<>();
            for(int i=0; i<nInput; i++){
                int newH = sc.nextInt();
                houses.add(newH);
            }
            Collections.sort(houses);
            int mid = getMid(houses);
            int opt = 0;
            for(int h: houses){
                opt += Math.abs(h-mid);
            }
            System.out.println(opt);
        }

    }

    private static int getMid(List<Integer> houses) {
        return houses.get(houses.size()/2);
    }
}
