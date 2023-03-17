import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class UVa_11056 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		do{
			int n = sc.nextInt();
			sc.nextLine();
			ArrayList<Racer> l = new ArrayList<>();
			while(n-->0){
				String[] split = sc.nextLine().split(" : ");
				String name = split[0];
				split = split[1].split(" min ");
				int time = Integer.parseInt(split[0])*60*1000;
				split = split[1].split(" sec ");
				time+=Integer.parseInt(split[0])*1000;
				split = split[1].split(" ");
				time+=Integer.parseInt(split[0]);
				l.add(new Racer(name, time));
			}
			Collections.sort(l);
			int r = 1;
			for(int i=0; i<l.size(); i++){
				System.out.println("Row "+r++);
				System.out.println(l.get(i).name);
				if(i<l.size()-1) System.out.println(l.get(++i).name);
			}
			System.out.println();
		}while(sc.hasNext());
	}
	
	static class Racer implements Comparable<Racer>{
		String name;
		int time;
		
		public Racer(String n, int t){
			name = n;
			time = t;
		}

		@Override
		public int compareTo(Racer o) {
			if(time==o.time) return name.toLowerCase().compareTo(o.name.toLowerCase());
			return Integer.compare(time, o.time);
		}
	}
}
