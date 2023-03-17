import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class UVa_10698 {
	static int total;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean first = true;
		while(true){
			String[] split = br.readLine().split(" ");
			int t = Integer.parseInt(split[0]);
			int g = Integer.parseInt(split[1]);
			if(t==0 && g==0) break;
			if(first) first = false;
			else System.out.println();
			HashMap<String, Integer> map = new HashMap<>();
			ArrayList<Team> teams = new ArrayList<>();
			for(int i=0; i<t; i++) {
				teams.add(new Team(br.readLine()));
				map.put(teams.get(i).name, i);
			}
			total = 0;
			for(int i=0; i<g; i++){
				split = br.readLine().split(" - ");
				String[] l = split[0].split(" ");
				String[] r = split[1].split(" ");
				Team t1 = teams.get(map.get(l[0]));
				Team t2 = teams.get(map.get(r[1]));
				int score1 = Integer.parseInt(l[1]);
				int score2 = Integer.parseInt(r[0]);
				t1.gPlayed++;
				t2.gPlayed++;
				t1.gScored+=score1;
				t2.gScored+=score2;
				t1.gSuffered+=score2;
				t2.gSuffered+=score1;
				if(score1>score2) {
					t1.points+=3;
					total+=3;
				}
				else if(score2>score1) {
					t2.points+=3;
					total+=3;
				}
				else{
					t1.points++;
					t2.points++;
					total+=2;
				}
			}
			Collections.sort(teams);
			int curPos = 0;
			Team curBest = null;
			for(Team cur: teams) {
				boolean changed = false;
				curPos++;
				if(curBest==null || !cur.equals(curBest)){
					curBest = cur;
					changed = true;
				}
				String pad = changed ? curPos+". " : " ";
				if(pad.length()<4) pad = " "+pad;
				while(pad.length()<4) pad+=" ";
				System.out.print(pad);
				System.out.printf("%15s %3s %3s %3s %3s %3s", cur.name, cur.points, cur.gPlayed, cur.gScored, cur.gSuffered, cur.goalDiff());
				double p = cur.percentage();
				if(p==-1) System.out.println("    N/A");
				else System.out.printf("%7.2f\n", p);
			}
		}
	}
	
	static class Team implements Comparable<Team> {
		String name;
		int points;
		int gPlayed;
		int gScored;
		int gSuffered;
		
		Team(String n){
			name = n;
			points = gPlayed = gScored = gSuffered = 0;
		}
		
		int goalDiff(){
			return gScored-gSuffered;
		}

		@Override
		public int compareTo(Team o) {
			if(points==o.points){
				if(goalDiff()==o.goalDiff()){
					if(gScored==o.gScored) return name.toLowerCase().compareTo(o.name.toLowerCase());
					return Integer.compare(o.gScored, gScored);
				}
				return Integer.compare(o.goalDiff(), goalDiff());
			}
			return Integer.compare(o.points, points);
		}
		
		boolean equals(Team o){
			if(points==o.points){
				if(goalDiff()==o.goalDiff()){
					if(gScored==o.gScored) return true;
				}
			}
			return false;
		}
		
		double percentage(){
			return gPlayed==0 ? -1 : points*100.0/(gPlayed*3.0);
		}
	}
}
