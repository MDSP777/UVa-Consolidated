

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_617 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nLights = sc.nextInt(), cases=1;
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Light[] lights;
        double mps, time;
        boolean printed, success, first;
        while(nLights != -1){
            first = true;
            printed = false;
            lights = new Light[nLights];
            for(int i=0; i<nLights; i++){
                lights[i] = new Light();
                lights[i].pos = sc.nextDouble();
                lights[i].g = sc.nextInt();
                lights[i].y = sc.nextInt();
                lights[i].r = sc.nextInt();
            }
            System.out.print("Case "+cases+": ");
            for(int i=30; i<61; i++){
                success = true;
                mps = i/3600.0;
                for(int j=0; j<nLights; j++){
                    time = lights[j].pos/mps;
                    if(!lights[j].isGreen(time))
                        success = false;
                }
                if(success){
                    answer.add(i);
                }
            }
            if (answer.size() == 0) {
                System.out.print("No acceptable speeds.");
            }
            else {
                    int start = answer.get(0);
                    System.out.print(start);

                    for (int i = 1; i < answer.size(); i++) {
                            if (answer.get(i) - answer.get(i-1) > 1) {
                                    if (answer.get(i-1) != start) 
                                            System.out.print("-" + answer.get(i-1));
                                    System.out.print(", " + answer.get(i));
                                    start = answer.get(i);
                            }
                    }

                    if (answer.get(answer.size() - 1) != start) 
                            System.out.print("-" + answer.get(answer.size() - 1));
            }
            System.out.println();
            cases++;
            answer.clear();
            nLights = sc.nextInt();
        }
    }
    
    public static class Light{
        public double pos;
        public int g, y, r;
        
        public boolean isGreen(double t){
            double cycleLength = g+y+r;
            while(t>=cycleLength){
                t-= cycleLength;
            }
            if(t>=0 && t <=g+y) 
                return true; 
            else 
                return false;
        }
    }
}
