

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_12503 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int i=0; i<nC; i++){
            int r = 0;
            int nI = sc.nextInt();
            ArrayList<Integer> coms = new ArrayList();
            sc.nextLine();
            for(int j=0; j<nI; j++){
                String c = sc.nextLine();
                if(c.equals("LEFT")){
                    coms.add(-1);
                    r--;
                }
                else if(c.equals("RIGHT")){
                    coms.add(1);
                    r++;
                }
                else{
                    int n = Integer.parseInt(c.split(" ")[2])-1;
                    coms.add(coms.get(n));
                    r+=coms.get(n);
                }
            }
            System.out.println(r);
        }
    }
}
