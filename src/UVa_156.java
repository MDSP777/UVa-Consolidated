

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class UVa_156 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> dict = new ArrayList<>();
        ArrayList<String> sort = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        while(true){
            String cur = sc.next();
            if(cur.equals("#")) break;
            dict.add(cur);
            char[] l = cur.toLowerCase().toCharArray();
            Arrays.sort(l);
            String low = new String(l);
            if(map.containsKey(low)){
                map.put(low, map.get(low)+1);
            } else {
                map.put(low, 1);
            }
            sort.add(low);
        }
        int l = sort.size();
        for(int i=0; i<l; i++){
            if(map.get(sort.get(i))==1) ans.add(dict.get(i));
        }
        Collections.sort(ans);
        l = ans.size();
        for(int i=0; i<l; i++){
            System.out.println(ans.get(i));
        }
    }
}
