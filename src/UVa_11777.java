

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_11777 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1; i<=t; i++){
            int grade = 0;
            grade+=sc.nextInt();
            grade+=sc.nextInt();
            grade+=sc.nextInt();
            grade+=sc.nextInt();
            ArrayList<Integer> q = new ArrayList();
            q.add(sc.nextInt());
            q.add(sc.nextInt());
            q.add(sc.nextInt());
            Collections.sort(q);
            grade+= (q.get(1)+q.get(2))/2;
            if(grade<60) System.out.println("Case " + i + ": F");
            else if(grade<70) System.out.println("Case " + i + ": D");
            else if(grade<80) System.out.println("Case " + i + ": C");
            else if(grade<90) System.out.println("Case " + i + ": B");
            else System.out.println("Case " + i + ": A");
        }
    }
}
