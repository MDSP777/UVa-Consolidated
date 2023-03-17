import java.util.ArrayList;
import java.util.Scanner;

public class UVa_476 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Rectangle> r = new ArrayList<>();
		while(true) {
			char c = sc.next().charAt(0);
			if(c=='*') break;
			r.add(new Rectangle(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble()));
		}
		int ctr = 1;
		while(true) {
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			boolean isContained = false;
			if(x==9999.9 && y==9999.9) break;
			for(int i=0; i<r.size(); i++)
				if(r.get(i).contains(x, y)) {
					System.out.println("Point "+ctr+" is contained in figure "+(i+1));
					isContained = true;
				}
			if(!isContained) System.out.println("Point "+ctr+" is not contained in any figure");
			ctr++;
		}
	}
	
	static class Rectangle {
		double x1, x2;
		double y1, y2;
		
		public Rectangle(double x1, double y1, double x2, double y2) {
			this.x1 = x1;
			this.y1 = y2;
			this.x2 = x2;
			this.y2 = y1;
		}
		
		boolean contains(double x, double y) {
			return x>x1 && x<x2 && y>y1 && y<y2;
		}
	}
}
