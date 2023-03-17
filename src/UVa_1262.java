import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class UVa_1262 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			int k = Integer.parseInt(br.readLine())-1;
			char[][] grid1 = new char[6][];
			char[][] grid2 = new char[6][];
			for(int i=0; i<6; i++) grid1[i] = br.readLine().toCharArray();
			for(int i=0; i<6; i++) grid2[i] = br.readLine().toCharArray();
			HashSet<String> w1 = obtain(grid1);
			HashSet<String> w2 = obtain(grid2);
			ArrayList<String> inter = new ArrayList<>();
			for(String s : w1) if(w2.contains(s)) inter.add(s);
			if(k>=inter.size()){
				System.out.println("NO");
			} else {
				Collections.sort(inter);
				System.out.println(inter.get(k));
			}
		}
	}
	
	static HashSet<String> obtain(char[][] grid){
		HashSet<String> res = new HashSet<>();
		for(int i=0; i<6; i++)
			for(int j=0; j<6; j++)
				for(int k=0; k<6; k++)
					for(int l=0; l<6; l++)
						for(int m=0; m<6; m++)
							res.add(""+grid[i][0]+grid[j][1]+grid[k][2]+grid[l][3]+grid[m][4]);
		return res;
	}
}
