

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_11727 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=1; x<=nC; x++){
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(sc.nextInt());
            arr.add(sc.nextInt());
            arr.add(sc.nextInt());
            Collections.sort(arr);
            System.out.println("Case "+x+": "+arr.get(1));
        }
    }
}