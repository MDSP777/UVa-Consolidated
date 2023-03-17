

import java.util.Scanner;

public class UVa_10200 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        boolean[] sieve = new boolean[10005];
        sieve[0] = true;
        for(int i=1; i<10005; i++){
            int a = i*i+i+41;
            if(isPrime(a)) sieve[i] = true;
        }
//        boolean[] sieve = new boolean[100010050];
//        for(int i=0; i<100010050; i++) sieve[i] = true;
//        for(int i=2; i<100010050; i++){
//            if(!sieve[i]) continue;
//            int temp = 2*i;
//            for(int j=temp; j<100010050; j+=i){
//                sieve[j] = false;
//            }
//        }
//        System.out.println("let's do this shit");
//        FileWriter fw = new FileWriter("scores.txt");
//        fw.write("{");
//        for(int i=0; i<100010049; i++)
//            fw.write(sieve[i]+", ");
//        fw.write(sieve[100010049]+"}");
//        fw.close();
//        System.out.println("hello");
        do{
            int a = sc.nextInt();
            int b = sc.nextInt();
            double m = 0;
            double n = b-a+1;
            for(int i=a; i<=b; i++){
                //int ans = i*i+i+41;
                if(sieve[i]) m++;
            }
            double ans = m/n;
            //System.out.println(m+" "+n);
            System.out.printf("%.2f\n", ans*100+1e-9);
        }while(sc.hasNext());
    }
    
    static boolean isPrime(int a){
        for(int i=2; i<Math.sqrt(a)+1; i++)
            if(a%i==0) return false;
        return true;
    }
}
