

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UVa_10487 {
    public static void main(String[] args) throws IOException{
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int nC = 1;
        StringBuilder out = new StringBuilder();
        while(true){
            int setLength = Integer.parseInt(sc.readLine());
            if(setLength==0) break;
            int[] set = new int[setLength];
            for(int i=0; i<setLength; i++) set[i] = Integer.parseInt(sc.readLine());
            Set<Integer> sumset = new HashSet<>();
            for(int i=0; i<setLength; i++){
                for(int j=0; j<setLength; j++){
                    if(i!=j){
                        sumset.add(set[i]+set[j]);
                    }
                }
            }
            List<Integer> sums = new ArrayList<>(sumset);
            Collections.sort(sums);
            out.append("Case "+nC+++":\n");
            int nQueries = Integer.parseInt(sc.readLine());
            for(int x=0; x<nQueries; x++){
                int q = Integer.parseInt(sc.readLine());
                int closestDiff = Integer.MAX_VALUE;
                int closest = 0;
                boolean willBreak = false;
                for(int i: sums){
                    if(willBreak) break;
                    if(Math.abs(i-q)<closestDiff){
                        closestDiff = Math.abs(i-q);
                        closest = i;
                    }
                    if(i>q) willBreak = true;
                }
                out.append("Closest sum to "+q+" is "+closest+".\n");
            }
        }
        System.out.print(out);
    }
}
