

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class UVa_11286 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        while(true){
            int n = new Integer(br.readLine());
            int best = 0;
            int total = 0;
            HashMap<String, Integer> map = new HashMap();
            if(n==0) break;
            for(int i=0; i<n; i++){
                int[] courses = new int[5];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<5; j++) courses[j] = Integer.parseInt(st.nextToken());
                Arrays.sort(courses);
                String newKey = convertToString(courses);
                if(map.containsKey(newKey)) map.put(newKey, map.get(newKey)+1);
                else map.put(newKey, 1);
                best = Math.max(best, map.get(newKey));
            }
            
            for(Map.Entry<String, Integer> entry: map.entrySet()){
                if(entry.getValue()==best) total+=best;
            }
            out.append(total).append("\n");
        }
        System.out.print(out);
    }

    private static String convertToString(int[] courses) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<5; i++) sb.append(courses[i]).append(" ");
        return sb.toString();
    }
}
