import java.util.Scanner;


public class UVa_191 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			Point lineStart = new Point(sc.nextInt(), sc.nextInt());
			Point lineEnd = new Point(sc.nextInt(), sc.nextInt());
			Point rectTL = new Point(sc.nextInt(), sc.nextInt());
			Point rectBR = new Point(sc.nextInt(), sc.nextInt());
			if(rectBR.x<rectTL.x){
				double temp = rectBR.x;
				rectBR.x = rectTL.x;
				rectTL.x = temp;
			}
			if(rectBR.y>rectTL.y){
				double temp = rectBR.y;
				rectBR.y = rectTL.y;
				rectTL.y = temp;
			}
			
			if(lineStart.x==lineEnd.x && lineStart.y==lineEnd.y){
				System.out.println((rectTL.x <= lineStart.x && lineStart.x <= rectBR.x) 
						&& (rectTL.y >= lineStart.y && lineStart.y >= rectBR.y) ? "T" : "F");
			} else if(lineStart.x==lineEnd.x){
				System.out.println(rectTL.x <= lineStart.x && lineStart.x <= rectBR.x ? "T" : "F");
			} else if(lineStart.y==lineEnd.y){
				System.out.println(rectTL.y >= lineStart.y && lineStart.y >= rectBR.y ? "T" : "F");
			} else {
				double slope = (lineStart.y-lineEnd.y)/(lineStart.x-lineEnd.x);
				boolean intersects = false;
				double ans = solveGivenX(lineStart, slope, rectTL.x);
				intersects |= rectTL.y>=ans && ans>=rectBR.y;
				ans = solveGivenX(lineStart, slope, rectBR.x);
				intersects |= rectTL.y>=ans && ans>=rectBR.y;
				ans = solveGivenY(lineStart, slope, rectTL.y);
				intersects |= rectTL.x<=ans && ans<=rectBR.x;
				ans = solveGivenY(lineStart, slope, rectBR.y);
				intersects |= rectTL.x<=ans && ans<=rectBR.x;
				System.out.println(intersects ? "T" : "F");
			}
		}
	}
	
	static double solveGivenX(Point point, double slope, double x){
		return slope*(x-point.x)+point.y;
	}
	

	static double solveGivenY(Point point, double slope, double y){
		return (y- point.y + slope*point.x)/slope;
	}
	
	static class Point {
		double x, y;
		
		Point(int a, int b){
			x = a;
			y = b;
		}
	}
}
