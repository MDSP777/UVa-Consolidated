

import java.util.Scanner;

public class UVa_661 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cn = 0;
        while(true){
            cn++;
            int n, m, c;
            n = sc.nextInt();
            m = sc.nextInt();
            c = sc.nextInt();
            boolean blown = false;
            if(n==0 && m==0 && c==0) break;
            int total = 0;
            int max = 0;
            Device[] d = new Device[n];
            for(int i=0; i<n; i++)
                d[i] = new Device(sc.nextInt());
            for(int i=0; i<m; i++){
                int cur = sc.nextInt()-1;
                total+=d[cur].getPower();
                if(total>c) blown = true;
                if(total>max) max = total;
            }
            System.out.println("Sequence "+cn);
            if(blown) System.out.println("Fuse was blown.");
            else System.out.println("Fuse was not blown.\n" +
            "Maximal power consumption was "+max+" amperes.");
            System.out.println("");
        }

    }
    
    static class Device{
        int power;
        boolean on;
        
        public Device(int power){
            this.power = power;
            on = false;
        }
        
        public int getPower(){
            on = !on;
            if(!on) return -1*power;
            else return power;
        }
    }
}
