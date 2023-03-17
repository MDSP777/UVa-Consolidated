

import java.util.Arrays;
import java.util.Scanner;

public class UVa_920 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            double total = 0;
            int nPoints = sc.nextInt();
            Point[] points = new Point[nPoints];
            int highestPointIndex = 0;
            Point highestPoint = new Point(0,0);
            for(int i=0; i<nPoints; i++){
                points[i] = new Point(sc.nextInt(), sc.nextInt());
            }
            Arrays.sort(points);
            for(int i=0; i<nPoints; i++){
                if(points[i].y > highestPoint.y){
                    highestPoint = points[i];
                    highestPointIndex = i;
                }
            }
            while(highestPointIndex < nPoints-1){
                Point nextHighest = points[highestPointIndex+1];
                int nextHighestIndex = highestPointIndex+1;
                for(int i=nextHighestIndex; i<nPoints; i++){
                    if(points[i].y > nextHighest.y){
                        nextHighest = points[i];
                        nextHighestIndex = i;
                    }
                }
                Point endPoint = new Point(0, nextHighest.y);
                double slope = getSlope(highestPoint, points[highestPointIndex+1]);
                double newX = getX(slope, highestPoint, nextHighest.y);
                endPoint.x = newX;
                
                total+=getDistance(highestPoint, endPoint);
                
                highestPoint = nextHighest;
                highestPointIndex = nextHighestIndex;
            }
            
            System.out.printf("%.2f\n", total);
        }
    }

    private static class Point implements Comparable<Point>{
        double x;
        double y;
        
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return Double.compare(this.x, o.x);
        }
    }
    
    static double getDistance(Point a, Point b){
        return Math.hypot(Math.abs(a.x-b.x), Math.abs(a.y-b.y));
    }
    
    static double getSlope(Point a, Point b){
        return Math.abs(a.y-b.y)/Math.abs(a.x-b.x);
    }
    
    static double getX(double slope, Point b, double y){
        return -1*((y-b.y)/slope - b.x);
    }
}
