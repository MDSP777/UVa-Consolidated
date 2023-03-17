import java.util.Scanner;

public class UVa_467 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 1;
		do {
			String[] split = sc.nextLine().split(" ");
			TrafficLight[] lights = new TrafficLight[split.length];
			for(int i=0; i<split.length; i++) lights[i] = new TrafficLight(Integer.parseInt(split[i]));
			int total = 0;
			while(allGreen(lights)) {
				total++;
				for(TrafficLight t : lights) t.inc();
			}
			while(total<3600 && !allGreen(lights)) {
				total++;
				for(TrafficLight t : lights) t.inc();
			}
			if(!allGreen(lights)) System.out.println("Set "+n+++" is unable to synch after one hour.");
			else System.out.println("Set "+n+++" synchs again at "+total/60+" minute(s) and "+total%60+" second(s) after all turning green.");
		} while(sc.hasNext());
	}
	
	static boolean allGreen(TrafficLight[] lights) {
		for(TrafficLight t : lights)
			if(!t.isGreen()) return false;
		return true;
	}
	
	static class TrafficLight {
		int cycleLength;
		int time = 0;
		
		public TrafficLight(int c) {
			cycleLength = c;
			time = cycleLength+1;
		}
		
		void inc() {
			time++;
			if(time>cycleLength*2) time = 1;
		}
		
		boolean isGreen() {
			return time>cycleLength && time-cycleLength+5<=cycleLength;
		}
	}
}
