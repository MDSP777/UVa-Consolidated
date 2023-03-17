

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_11729 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = 1;
        while(true){
            int n = sc.nextInt();
            if(n==0) break;
            ArrayList<Soldier> soldiers = new ArrayList<>();
            int totalDeliveryTime = 0;
            for(int i=0; i<n; i++){
                soldiers.add(new Soldier(sc.nextInt(), sc.nextInt()));
                totalDeliveryTime+=soldiers.get(i).deliveryTime;
            }
            Collections.sort(soldiers);
//            System.out.println(soldiers);
            int totalTime = 0;
            int extra = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                Soldier cur = soldiers.get(i);
                totalTime+=cur.deliveryTime;
                totalDeliveryTime-=cur.deliveryTime;
                int newExtra = cur.executionTime-totalDeliveryTime;
                if(extra<0) extra = 0;
                extra = Math.max(extra, newExtra);
            }
            totalTime+=extra;
            System.out.println("Case "+nC+++": "+totalTime);
        }

    }
    
    static class Soldier implements Comparable<Soldier> {
        int deliveryTime;
        int executionTime;
        
        public Soldier(int d, int e){
            deliveryTime = d;
            executionTime = e;
        }

        @Override
        public int compareTo(Soldier o) {
            return Integer.compare(o.executionTime, this.executionTime);
        }
        
        public String toString(){
            return "("+deliveryTime+", "+executionTime+")";
        }
    }
}
