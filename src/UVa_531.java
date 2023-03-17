import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class UVa_531 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		do {
			ArrayList<String> s1 = new ArrayList<>();
			ArrayList<String> s2 = new ArrayList<>();
			while(true) {
				String s = sc.next();
				if(s.equals("#")) break;
				s1.add(s);
			}
			while(true) {
				String s = sc.next();
				if(s.equals("#")) break;
				s2.add(s);
			}
			int[][] memo = new int[s1.size()+1][s2.size()+1];
			for(int i=0; i<=s1.size(); i++) memo[i][0] = 0;
			for(int i=0; i<=s2.size(); i++) memo[0][i] = 0;
			for(int i=1; i<=s1.size(); i++)
				for(int j=1; j<=s2.size(); j++)
					if(s1.get(i-1).equals(s2.get(j-1))) memo[i][j] = 1+memo[i-1][j-1];
					else memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
			Stack<String> s = new Stack<>();
			int curS1 = s1.size();
			int curS2 = s2.size();
			while(memo[curS1][curS2]>0) {
				if(memo[curS1-1][curS2-1]==memo[curS1][curS2]-1 && memo[curS1-1][curS2-1]>=memo[curS1-1][curS2] && memo[curS1-1][curS2-1]>=memo[curS1][curS2-1]) {
					s.push(s1.get(curS1-1));
					curS1--;
					curS2--;
				} else {
					if(memo[curS1-1][curS2]>memo[curS1][curS2-1]) curS1--;
					else curS2--;
				}
			}
			StringBuilder sb = new StringBuilder();
			while(!s.isEmpty()) sb.append(s.pop()).append(" ");
			System.out.println(sb.toString().trim());
		} while(sc.hasNext());
	}
}
