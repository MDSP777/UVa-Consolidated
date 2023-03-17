

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class UVa_10789 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        boolean[] primes = new boolean[2001];
        for (int i = 2; i < 2001; i++) {
            primes[i] = true;
        }
        for(int i=2; i<2001; i++){
            if(primes[i]){
                for(int j=i*2; j<2001; j+=i){
                    primes[j] = false;
                }
            }
        }
        
        int nC = sc.nextInt();
        sc.nextLine();
        for(int x=1; x<=nC; x++){
            String in = sc.nextLine();
            HashMap<Character, Ctr> map = new HashMap<>();
            int l = in.length();
            for(int i=0; i<l; i++){
                char c = in.charAt(i);
                Ctr ctr = map.get(c);
                if(ctr==null){
                    Ctr newCtr = new Ctr(c);
                    newCtr.count++;
                    map.put(c, newCtr);
                } else {
                    ctr.count++;
                }
            }
            StringBuilder out = new StringBuilder();
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if(primes[((Ctr)pair.getValue()).count]){
                    out.append(pair.getKey());
                }
            }
            char[] arr = out.toString().toCharArray();
            Arrays.sort(arr);
            if(arr.length==0){
                System.out.println("Case "+x+": empty");
            } else {
                System.out.print("Case "+x+": ");
                for(int i=0; i<arr.length; i++){
                    System.out.print(arr[i]);
                }
                System.out.println("");
            }
        }
    }
    
    static class Ctr{
        char c;
        int count;
        
        public Ctr(char c){
            this.c = c;
        }
    }
}
