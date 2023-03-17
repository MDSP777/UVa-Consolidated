

import java.util.Scanner;

public class UVa_10692 {
    static boolean[] prime;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        prime = new boolean[11000];
        for(int i=2; i<11000; i++) prime[i] = true;
        for(int i=2; i<11000; i++){
            if(prime[i]){
                for(int j=i*2; j<11000; j+=i){
                    prime[j] = false;
                }
            }
        }

        int nC = 1;
        while(true){
            String modString = sc.next();
            if(modString.equals("#")) break;
            
            int m = Integer.parseInt(modString);
            int towerSize = sc.nextInt();
            int[] tower = new int[towerSize];
            for(int i=0; i<towerSize; i++) tower[i] = sc.nextInt();
            
            System.out.println("Case #"+nC+++": "+towerPower(0, tower, m));
        }
    }
    
    static int sigma(int x, int y, int mod) {
        int phi = 1;
        while (y!=0) {
                if ((y&1)!= 0)
                        phi = (phi*x)%mod;
                x = (x*x)%mod;
                y = y >> 1;
        }		
        return phi;
    }
    
    static int totient(int n){
        int tot = n; 
        for (int p=2; p*p<=n; p++) {
            if (n%p == 0) {
                tot /= p;
                tot *= (p-1);
                while (n%p == 0) 
                    n /= p;
            }
        }
        if (n > 1) { // now n is the largest prime divisor
            tot /= n;
            tot *= (n-1);
        }
        return tot;
    }
    
    static int towerPower(int x, int[] exponents, int m)  {
            if (x == exponents.length-1)
                return exponents[x]%m;
            int index_2 = towerPower(x+1, exponents, totient(m)) + totient(m);
            return sigma(exponents[x], index_2, m);
    }
}