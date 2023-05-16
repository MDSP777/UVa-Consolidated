import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class UVa_11474 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			double t = Double.parseDouble(split[2]);
			double d = Double.parseDouble(split[3]);
			
			Point[] doctors = new Point[m];
			for(int i=0; i<m; i++){
				split = br.readLine().split(" ");
				doctors[i] = new Point(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
			}

			Point[][] trees = new Point[n][];
			for(int i=0; i<n; i++){
				int l = Integer.parseInt(br.readLine());
				trees[i] = new Point[l];
				for(int j=0; j<l; j++){
					split = br.readLine().split(" ");
					trees[i][j] = new Point(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
				}
			}
			
			boolean[] canReachDoctor = new boolean[n];
			for(int i=0; i<n; i++)
				for(int j=0; j<trees[i].length; j++)
					for(int k=0; k<m; k++)
						if(dist(trees[i][j], doctors[k])<=d)
							canReachDoctor[i] = true;
			
			ArrayList<Integer>[] e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			
			for(int i=0; i<n; i++)
				for(int j=i+1; j<n; j++){
					boolean matched = false;
					for(int k=0; !matched && k<trees[i].length; k++)
						for(int l=0; !matched && l<trees[j].length; l++)
							if(dist(trees[i][k], trees[j][l])<=t){
								matched = true;
								e[i].add(j);
								e[j].add(i);
								break;
							}
				}
			
			boolean can = false;
			boolean[] visited = new boolean[n];
			visited[0] = true;
			LinkedList<Integer> q = new LinkedList<>();
			q.add(0);
			while(!q.isEmpty() && !can){
				int cur = q.poll();
				if(canReachDoctor[cur]){
					can = true;
					break;
				}
				
				for(int next : e[cur])
					if(!visited[next]){
						visited[next] = true;
						q.add(next);
						if(canReachDoctor[next]){
							can = true;
							break;
						}
					}
			}
			System.out.println(can ? "Tree can be saved :)" : "Tree can't be saved :(");
		}
	}
	
	static double dist(Point a, Point b){
		return Math.hypot(a.x-b.x, a.y-b.y);
	}
	
	static class Point{
		double x, y;
		
		Point(double a, double b){
			x = a;
			y = b;
		}
	}
}
