import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class UVa_755 {
	static int[] numVals = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			br.readLine();
			int nNums = Integer.parseInt(br.readLine());
			TreeMap<String, Integer> nums = new TreeMap<>();
			boolean hasDup = false;
			for(int i=0; i<nNums; i++) {
				String s = convert(br.readLine());
				if(!nums.containsKey(s)) nums.put(s, 1);
				else {
					nums.put(s, nums.get(s)+1);
					hasDup = true;
				}
			}
			if(!hasDup) System.out.println("No duplicates.");
			else for(String s : nums.keySet()) if(nums.get(s)>1) System.out.println(s.substring(0, 3)+"-"+s.substring(3)+" "+nums.get(s));
			if(nC>0) System.out.println();
		}
	}

	private static String convert(String s) {
		s = s.replaceAll("-", "");
		char[] arr = s.toCharArray();
		for(int i=0; i<arr.length; i++)
			if(arr[i]>='A' && arr[i]<='Z')
				if(arr[i]>'Q') arr[i] = (char) ('0'+numVals[arr[i]-'A'-1]);
				else arr[i] = (char) ('0'+numVals[arr[i]-'A']);
		return new String(arr);
	}
}
