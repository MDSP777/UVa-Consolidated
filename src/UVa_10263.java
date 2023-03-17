

import java.util.Scanner;

public class UVa_10263 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            boolean isStart = true;
            double mX = sc.nextDouble();
            double mY = sc.nextDouble();
            double finalX = -24601;
            double finalY = -24601;
            int nSegments = sc.nextInt();
            
            Segment[] segments = new Segment[nSegments];
            double startX = sc.nextDouble();
            double startY = sc.nextDouble();
            for(int i=0; i<nSegments; i++){
                double endX = sc.nextDouble();
                double endY = sc.nextDouble();
                segments[i] = new Segment(startX, startY, endX, endY);
                startX = endX;
                startY = endY;
            }
            
            double best = Double.MAX_VALUE;
            for(int i=0; i<nSegments; i++){
                boolean withinBounds = true;
                double curDist = straightLineDist(mX, mY, segments[i]);
                double xOffset;
                double yOffset;
                boolean onSameLine = segments[i].findYAt(mX)==mY;
                boolean isAbove = segments[i].findYAt(mX)<mY;
                double curSlope;
                if(Double.isInfinite(segments[i].slope)) curSlope = 0;
                else curSlope = -1.0/segments[i].slope;
                if(onSameLine){
                    if(Double.isInfinite(curSlope)){
                        xOffset = 0;
                        if(mY<Math.min(segments[i].startY, segments[i].endY)){
                            yOffset = Math.min(Math.abs(mY-segments[i].startY), Math.abs(mY-segments[i].endY));
                        } else if(mY>Math.max(segments[i].startY, segments[i].endY)){
                            yOffset = -Math.min(Math.abs(mY-segments[i].startY), Math.abs(mY-segments[i].endY));
                        } else {
                            yOffset = 0;
                        }
                    } else if(curSlope==0){
                        yOffset = 0;
                        if(mX<Math.min(segments[i].startX, segments[i].endX)){
                            xOffset = Math.min(Math.abs(mX-segments[i].startX), Math.abs(mX-segments[i].endX));
                        } else if(mX>Math.max(segments[i].startX, segments[i].endX)){
                            xOffset = -Math.min(Math.abs(mX-segments[i].startX), Math.abs(mX-segments[i].endX));
                        } else {
                            xOffset = 0;
                        }
                    } else {
                        if(mX<Math.min(segments[i].startX, segments[i].endX)){
                            xOffset = Math.min(Math.abs(mX-segments[i].startX), Math.abs(mX-segments[i].endX));
                            yOffset = Math.min(Math.abs(mY-segments[i].startY), Math.abs(mY-segments[i].endY));
                            if(curSlope<0){
                                xOffset*=-1;
                                yOffset*=-1;
                            }
                        } else if(mX>Math.max(segments[i].startX, segments[i].endX)){
                            xOffset = -Math.min(Math.abs(mX-segments[i].startX), Math.abs(mX-segments[i].endX));
                            yOffset = -Math.min(Math.abs(mY-segments[i].startY), Math.abs(mY-segments[i].endY));
                            if(curSlope>0){
                                xOffset*=-1;
                                yOffset*=-1;
                            }
                        } else {
                            xOffset = 0;
                            yOffset = 0;
                        }
                    }
                }
                else {
                    double k = curDist/Math.sqrt(1+curSlope*curSlope);
                    if(isAbove) k*=-1;
                    if(curSlope<0) k*=-1;
                    xOffset = k;
                    yOffset = k*curSlope;
                    
                    if(Double.isInfinite(curSlope)){
                        xOffset = 0;
                        yOffset = Math.abs(mY-segments[i].startY);
                        if(isAbove) yOffset*=-1;
                    }
                }
                double maxX = Math.max(segments[i].startX, segments[i].endX);
                double minX = Math.min(segments[i].startX, segments[i].endX);
                double maxY = Math.max(segments[i].startY, segments[i].endY);
                double minY = Math.min(segments[i].startY, segments[i].endY);
                if(mX+xOffset>maxX || mX+xOffset<minX || mY+yOffset>maxY || mY+yOffset<minY){
                    double dist1 = Math.hypot(mX-segments[i].startX, mY-segments[i].startY);
                    double dist2 = Math.hypot(mX-segments[i].endX, mY-segments[i].endY);
                    isStart = dist1<dist2;
                    curDist = Math.min(dist1, dist2);
                    withinBounds = false;
                }
                if(curDist<best){
                    best = curDist;
                    if(withinBounds){
                        finalX = mX+xOffset;
                        finalY = mY+yOffset;
                    } else {
                        if(isStart){
                            finalX = segments[i].startX;
                            finalY = segments[i].startY;
                        } else {
                            finalX = segments[i].endX;
                            finalY = segments[i].endY;
                        }
                    }
                }
            }
            System.out.printf("%.4f\n", finalX);
            System.out.printf("%.4f\n", finalY);
        }while(sc.hasNext());
    }
    
    static double straightLineDist(double mX, double mY, Segment s){
        double ans = Math.min(Math.hypot(mX-s.startX, mY-s.startY),
                Math.hypot(mX-s.endX, mY-s.endY));
        if((mX>=Math.max(s.startX, s.endX) && mY>=Math.max(s.startY, s.endY))||
                (mX<=Math.min(s.startX, s.endX) && mY<=Math.min(s.startY, s.endY))) return ans;
        ans = Math.min(ans, Math.abs((s.endY-s.startY)*mX-(s.endX-s.startX)*mY+s.endX*s.startY-s.endY*s.startX)/
            Math.sqrt(Math.pow(s.endY-s.startY, 2)+Math.pow(s.endX-s.startX, 2)));
        return ans;
    }
    
    static class Segment {
        double startX;
        double startY;
        double endX;
        double endY;
        double slope;
        
        public Segment(double sx, double sy, double ex, double ey){
            startX = sx;
            startY = sy;
            endX = ex;
            endY = ey;
            
            slope = (double)(endY-startY)/(double)(endX-startX);
        }
        
        public double findYAt(double x){
            return slope*(x-startX)+startY;
        }
        
        public String toString(){
            return "["+startX+", "+startY+"] ["+endX+", "+endY+"]";
        }
    }
}
