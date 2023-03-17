

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_11455 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            ArrayList<Long> arr = new ArrayList<>();
            arr.add(sc.nextLong());
            arr.add(sc.nextLong());
            arr.add(sc.nextLong());
            arr.add(sc.nextLong());
            Collections.sort(arr);
            if(arr.get(0)==0 || arr.get(1)==0 || arr.get(2)==0 || arr.get(3)==0){
                System.out.println("banana");
            } else if(arr.get(0).equals(arr.get(1)) && arr.get(1).equals(arr.get(2)) && arr.get(2).equals(arr.get(3))){
                System.out.println("square");
            } else if(arr.get(0).equals(arr.get(1)) && arr.get(2).equals(arr.get(3)) && arr.get(0)+arr.get(1)+arr.get(2)>arr.get(3)){
                System.out.println("rectangle");
            } else if(arr.get(0)+arr.get(1)+arr.get(2)>arr.get(3)){
                System.out.println("quadrangle");
            } else {
                System.out.println("banana");
            }
        }

    }

    private static long sum(ArrayList<Long> arr) {
        long total = 0;
        for(int i=0; i<arr.size(); i++){
            total+=arr.get(i);
        }
        return total;
    }
}
