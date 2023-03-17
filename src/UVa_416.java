import java.util.Scanner;

public class UVa_416 {
	static int n;
	static String[] lights;
	static boolean[] busted;
	static String[] patterns = {
		"YYYYYYN",
		"NYYNNNN",
		"YYNYYNY",
		"YYYYNNY",
		"NYYNNYY",
		"YNYYNYY",
		"YNYYYYY",
		"YYYNNNN",
		"YYYYYYY",
		"YYYYNYY"
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			if(n==0) break;
			lights = new String[n];
			for(int i=0; i<n; i++) lights[i] = sc.next();
			boolean match = false;
			for(int i=9; !match && i>=n-1; i--) {
				busted = new boolean[7];
				match|=backtrack(0, i);
			}
			System.out.println(match ? "MATCH" : "MISMATCH");
		}
	}

	
	static boolean backtrack(int index, int curNum){
		if(index==n) return true;
		if(curNum==0) {
			if(index<n-1) return false;
			return isPossible(lights[index], curNum);
		}
		if(isPossible(lights[index], curNum)) return backtrack(index+1, curNum-1);
		return false;
	}
	
	static boolean isPossible(String light, int val){
		boolean wrong = false;
		for(int i=0; !wrong && i<7; i++)
			wrong|=(light.charAt(i)=='Y' && patterns[val].charAt(i)=='N') || 
					(busted[i] && light.charAt(i)=='Y');
		if(wrong) return false;
		for(int i=0; i<7; i++)
			if(patterns[val].charAt(i)=='Y' && light.charAt(i)=='N') busted[i] = true;
		return true;
	}
}
