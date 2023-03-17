

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_10107 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList();
        do{
            arr.add(sc.nextInt());
            Collections.sort(arr);
            System.out.println(getMedian(arr));
        }while(sc.hasNext());

    }
    
    static int getMedian(ArrayList<Integer> arr){
        int s = arr.size();
        if(s%2==1) return arr.get(s/2);
        else{
            return (arr.get(s/2)+arr.get(s/2-1))/2;
        }
    }
}
