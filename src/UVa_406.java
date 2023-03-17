

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_406 {
    public static void main(String[] args){
        StringBuilder out = new StringBuilder("");
        Scanner sc = new Scanner(System.in);
        boolean[] isPrime = new boolean[1001];
        for(int i=0; i<=1000; i++) isPrime[i] = true;
        for(int i=2; i<=1000; i++)
            if(isPrime[i]){
                for(int j=i*2; j<=1000; j+=i)
                    isPrime[j] = false;
            }
        do{
            int n = sc.nextInt();
            int c = sc.nextInt();
            int cout = c;
            c*=2;
            ArrayList<Integer> primes = new ArrayList();
            for(int i=1; i<=n; i++)
                if(isPrime[i])
                    primes.add(i);
            int s = primes.size();
            if(s%2==1) c--;
            if(c>s){
                out.append(n+" "+cout+":");
                for(int i=0; i<primes.size(); i++)
                    out.append(" "+primes.get(i));
                out.append("\n");
            } else{
                int bound = (s-c)/2;
                out.append(n+" "+cout+":");
                for(int i=bound; i<bound+c; i++)
                    out.append(" "+primes.get(i));
                out.append("\n");
            }
            out.append("\n");
        }while(sc.hasNext());
        System.out.print(out);
    }
}
