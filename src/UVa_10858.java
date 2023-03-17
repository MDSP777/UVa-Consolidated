import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UVa_10858 {
	static boolean[] sieve;
	static HashMap<Integer, ArrayList<ArrayList<Integer>>> map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sieve = new boolean[2000100];
		for(int i=2; i<=2000000; i++) sieve[i] = true;
		for(int i=2; i<=2000000; i++) 
			if(sieve[i])
				for(int j=i*2; j<=2000000; j+=i) sieve[j] = false;
		map = new HashMap<>();
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			if(n<4) sb.append("0\n");
			else {
				ArrayList<ArrayList<Integer>> ans = generate(n);
				if(ans.size()==1) sb.append("0\n");
				else {
					sb.append(ans.size()-1).append("\n");
					for(int i=0; i<ans.size()-1; i++) {
						sb.append(ans.get(i).get(0));
						for(int j=1; j<ans.get(i).size(); j++) sb.append(" ").append(ans.get(i).get(j));
						sb.append("\n");
					}
				}
			}
		}
		System.out.print(sb);
	}
	
	static ArrayList<ArrayList<Integer>> generate(int i) {
		if(map.containsKey(i)) return map.get(i);
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(!sieve[i]) {
			int sqrt = (int) Math.sqrt(i);
			for(int j=2; j<=sqrt; j++) {
				if(i%j==0) {
					ArrayList<ArrayList<Integer>> right = generate(i/j);
					for(int k=0; k<right.size(); k++) {
						ArrayList<Integer> toAdd = new ArrayList<>();
						toAdd.add(j);
						boolean success = true;
						for(int l=0; l<right.get(k).size(); l++) {
							if(right.get(k).get(l)<toAdd.get(toAdd.size()-1)) {
								success = false;
								break;
							}
							toAdd.add(right.get(k).get(l));
						}
						if(success) res.add(toAdd);
					}
				}
			}
		}
		res.add(new ArrayList<>());
		res.get(res.size()-1).add(i);
		map.put(i, res);
		return res;
	}
}
