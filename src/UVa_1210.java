

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_1210 {
    static boolean[] prime;
    static ArrayList<Integer> primesList;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        prime = new boolean[11000];
        primesList = new ArrayList<>();
        for(int i=2; i<11000; i++) prime[i] = true;
        for(int i=2; i<11000; i++){
            if(prime[i]){
                primesList.add(i);
                for(int j=i*2; j<11000; j+=i){
                    prime[j] = false;
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> sumsUntil = new ArrayList<>();
        sumsUntil.add(new ArrayList<Integer>());
        sumsUntil.get(0).add(primesList.get(0));
        
        for(int i=1; i<primesList.size(); i++){
            ArrayList<Integer> newArr = new ArrayList<>();
            int curPrime = primesList.get(i);
            newArr.add(curPrime);
            ArrayList<Integer> prevArr = sumsUntil.get(i-1);
            for(int j=0; j<prevArr.size(); j++){
                newArr.add(curPrime+prevArr.get(j));
            }
            sumsUntil.add(newArr);
        }
        
        while(true){
            int n = sc.nextInt();
            if(n==0) break;
            int total = 0;
            for(int i=0; i<sumsUntil.size(); i++){
                if(sumsUntil.get(i).contains(n)) total++;
            }
            System.out.println(total);
        }
    }
}
