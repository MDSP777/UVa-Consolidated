

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* Egypt */
public class UVa_11854 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            List<Integer> terms = new ArrayList<Integer>();
            terms.add(sc.nextInt());
            terms.add(sc.nextInt());
            terms.add(sc.nextInt());
            if(terms.get(0)==0&&terms.get(1)==0&&terms.get(2)==0) break;
            Collections.sort(terms);
            if(Math.pow(terms.get(0), 2)+Math.pow(terms.get(1), 2)==Math.pow(terms.get(2), 2))
                System.out.println("right");
            else System.out.println("wrong");
        }
    }
}
