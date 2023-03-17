import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class UVa_152 {
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		ArrayList<Point> points = new ArrayList<>();
		while(true){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a==0 && b==0 && c==0) break;
			points.add(new Point(a, b, c));
		}
		double[] minDist = new double[points.size()];
		Arrays.fill(minDist, 1000000000);
		for(int i=0; i<points.size(); i++)
			for(int j=i+1; j<points.size(); j++){
				double dist = points.get(i).distanceTo(points.get(j));
				minDist[i] = Math.min(minDist[i], dist);
				minDist[j] = Math.min(minDist[j], dist);
			}
		int[] distances = new int[10];
		for(int i=0; i<points.size(); i++)
			if(minDist[i]<10){
				distances[(int)minDist[i]]++;
			}
		for(int i=0; i<10; i++) System.out.printf("%4d", distances[i]);
		System.out.println();
	}
	
	static class Point {
		int x, y, z;
		
		Point(int a, int b, int c){
			x = a;
			y = b;
			z = c;
		}
		
		double distanceTo(Point o){
			double xdiff = x-o.x;
			double ydiff = y-o.y;
			double zdiff = z-o.z;
			return Math.sqrt(xdiff*xdiff + ydiff*ydiff + zdiff*zdiff);
		}
	}
}
