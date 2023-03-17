import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class UVa_10730 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] split = br.readLine().split("\\s+");
			if(split.length==1) break;
			int[] arr = new int[split.length-1];
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int i=1; i<split.length; i++) {
				arr[i-1] = Integer.parseInt(split[i]);
				map.put(arr[i-1], i-1);
			}
			System.out.println(check(arr, map) ? "yes" : "no");
		}
	}

	private static boolean check(int[] arr, HashMap<Integer, Integer> map) {
		for(int i=0; i<arr.length-2; i++)
			for(int j=i+1; j<arr.length-1; j++) {
				int mean = arr[i]-arr[j];
				if(map.containsKey(arr[j]-mean)) if(map.get(arr[j]-mean)>j) return false;
			}
		return true;
	}
}
