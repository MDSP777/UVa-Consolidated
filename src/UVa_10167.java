import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

// Solution summary:
// 1. Divide points into 8 groups
//	  4 groups for points in each quadrant
//    4 groups for points along the +/- axes
// 2. Sort the points in each quadrant acc to their angle to (0,0)
// 3. If the x/y axis groups are empty, test validity of horizontal/vertical lines respectively
// 4. Try all coprime pairs between 1 to 500 and check validity of that line
//    First check if the line does not cut through any point (by checking slopes)
//    Each line will split 2 quadrants and keep 2 quadrants intact
//    +ve slope lines will split q1 and q3, -ve slope lines will split q2 and q4
//    Add the total of each unsplit quadrant (along with the axes they border) to 2 buckets
//    Use binary search to find how many points in the split quadrants will go to each bucket
//    Check if both buckets have equal size
//    For each line, also test the version where x is -ve
public class UVa_10167 {
	static double eps = 1e-9;
	static Point origin = new Point(0, 0);
	static HashSet<Double> usedSlopes;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			usedSlopes = new HashSet<>();
			if(n==0) break;
			ArrayList<Point>[] groups = new ArrayList[8];
			for(int i=0; i<8; i++) groups[i] = new ArrayList<>();
			
			for(int i=0; i<2*n; i++) {
				String[] split = br.readLine().split(" ");
				int x = Integer.parseInt(split[0]);
				int y = Integer.parseInt(split[1]);
				Point p = new Point(x, y);
				if(x!=0) usedSlopes.add(p.y/p.x);
				if(y==0) {
					if(x>0) groups[4].add(p);
					else groups[6].add(p);
				} else if(x==0) {
					if(y>0) groups[5].add(p);
					else groups[7].add(p);
				} else {
					if(x>0) {
						if(y>0) groups[0].add(p);
						else groups[3].add(p);
					} else {
						if(y>0) groups[1].add(p);
						else groups[2].add(p);
					}
				}
			}
			
			for(int i=0; i<4; i++) Collections.sort(groups[i]);
			
			// try vertical line
			if(groups[5].isEmpty() && groups[7].isEmpty()) {
				int l = groups[1].size()+groups[6].size()+groups[2].size();
				int r = groups[0].size()+groups[4].size()+groups[3].size();
				if(l==r) {
					System.out.println("1 0");
					continue;
				}
			}
			
			// try horizontal line
			if(groups[4].isEmpty() && groups[6].isEmpty()) {
				int l = groups[0].size()+groups[5].size()+groups[1].size();
				int r = groups[2].size()+groups[7].size()+groups[3].size();
				if(l==r) {
					System.out.println("0 1");
					continue;
				}
			}

			boolean foundAns = false;
			for(int i=1; !foundAns && i<=500; i++)
				for(int j=1; !foundAns && j<=500; j++) {
					if(!coprime(i, j)) continue;
					Point p = new Point(i, j);
					if(!usedSlopes.contains(p.y/p.x)) {
						int l = groups[1].size()+groups[5].size()+groups[6].size();
						int r = groups[3].size()+groups[4].size()+groups[7].size();
						
						// split q1
						int idx = Collections.binarySearch(groups[0], p);
						int ins = -(idx+1);
						r+=ins;
						l+=groups[0].size()-ins;
						
						// split q3
						idx = Collections.binarySearch(groups[2], new Point(-i, -j));
						ins = -(idx+1);
						l+=ins;
						r+=groups[2].size()-ins;
						
						if(l==r) {
							System.out.println((-j)+" "+i);
							foundAns = true;
							break;
						}
						
					}
					
					p = new Point(-i, j);
					if(!usedSlopes.contains(p.y/p.x)) {
						int l = groups[2].size()+groups[6].size()+groups[7].size();
						int r = groups[0].size()+groups[4].size()+groups[5].size();

						// split q2
						int idx = Collections.binarySearch(groups[1], p);
						int ins = -(idx+1);
						r+=ins;
						l+=groups[1].size()-ins;

						// split q4
						idx = Collections.binarySearch(groups[3], new Point(i, -j));
						ins = -(idx+1);
						l+=ins;
						r+=groups[3].size()-ins;
						
						if(l==r) {
							System.out.println((-j)+" "+(-i));
							foundAns = true;
							break;
						}
					}
				}
		}
	}
	
	static boolean coprime(int a, int b) {
		return gcd(a, b)==1;
	}
	
	static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b, a%b);
	}
	
	static class Point implements Comparable<Point>{
		double x;
		double y;
		double theta;
		
		Point(int a, int b){
			x = a;
			y = b;
			theta = Math.atan2(y, x);
		}

		@Override
		public int compareTo(Point o) {
			return Double.compare(theta, o.theta);
		}
		
		public String toString() {
			return "("+x+","+y+")";
		}
	}
}
