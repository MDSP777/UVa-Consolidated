import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;


public class UVa_12662 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String LEFT = "left of ";
		String RIGHT = "right of ";
		String MIDDLE = "middle of ";
		
		int n = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split(" ");
		TreeMap<Integer, String> map = new TreeMap<>();
		for(int i=0; i<n; i++)
			if(!split[i].equals("?")) map.put(i, split[i]);
		
		int q = Integer.parseInt(br.readLine());
		while(q-->0){
			int x = Integer.parseInt(br.readLine())-1;
			Integer lKey = map.floorKey(x);
			Integer rKey = map.ceilingKey(x);
			if((lKey!=null && lKey==x) || (rKey!=null && rKey==x)) sb.append(map.get(lKey)).append("\n");
			else {
				if(lKey==null) {
					int diff = rKey-x;
					while(diff-->0) sb.append(LEFT);
					sb.append(map.get(rKey)).append("\n");
				} else if(rKey==null) {
					int diff = x-lKey;
					while(diff-->0) sb.append(RIGHT);
					sb.append(map.get(lKey)).append("\n");
				} else {
					int lDiff = x-lKey;
					int rDiff = rKey-x;
					if(lDiff==rDiff) 
						sb.append(MIDDLE).append(map.get(lKey)).append(" and ").append(map.get(rKey)).append("\n");
					else if(lDiff<rDiff) {
						while(lDiff-->0) sb.append(RIGHT);
						sb.append(map.get(lKey)).append("\n");
					} else {
						while(rDiff-->0) sb.append(LEFT);
						sb.append(map.get(rKey)).append("\n");
					}
				}
			}
		}
		
		System.out.print(sb);
	}
}
