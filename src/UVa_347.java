

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UVa_347 {
    public static void main(String[] args) throws IOException{
        StringBuilder out = new StringBuilder();
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int nC = 1;
        boolean[] isR = new boolean[10000000];
        for(int i=10; i<10000000; i++)
            isR[i] = isRound(i+"");
        while(true){
            int n = Integer.parseInt(sc.readLine());
            if(n==0) break;
            while(true){
                if(isR[n]){
                    out.append("Case "+nC+++": "+n+"\n");
                    break;
                }
                n++;
            }
        }
        System.out.print(out);
    }

    private static boolean isRound(String n) {
        int len = n.length();
        int[] dCount = new int[10];
        for(int i=0; i<len; i++){
            dCount[n.charAt(i)-'0']++;
            if(dCount[n.charAt(i)-'0']>1) return false;
        }
        
        boolean[] visited = new boolean[len];
        int curIndex = 0;
        for(int i=0; i<len; i++){
            int newNo = n.charAt(curIndex)-'0';
            visited[curIndex] = true;
            curIndex = (curIndex+newNo)%len;
            if(visited[curIndex]==true && i!=len-1){
                return false;
            } else if(i==len-1 && curIndex!=0){
                return false;
            }
        }
        return true;
    }
}
