import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_12667 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int t = Integer.parseInt(split[1]);
		int m = Integer.parseInt(split[2]);
		
		boolean[][] hasSolved = new boolean[t][n];
		int[] lastToSolve = new int[n];
		int[] lastSolveTime = new int[n];
		
		while(m-->0){
			split = br.readLine().split(" ");
			int time = Integer.parseInt(split[0]);
			int team = Integer.parseInt(split[1])-1;
			int pId = split[2].charAt(0)-'A';
			boolean solved = split[3].equals("Yes");
			if(solved && !hasSolved[team][pId]){
				hasSolved[team][pId] = true;
				lastToSolve[pId] = team+1;
				lastSolveTime[pId] = time;
			}
		}
		
		for(int i=0; i<n; i++)
			System.out.printf("%c %s %s\n", 'A'+i, 
					lastToSolve[i]==0 ? "-" : lastSolveTime[i], 
					lastToSolve[i]==0 ? "-" : lastToSolve[i]);
	}
}
