import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class UVa_10194 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			String tName = br.readLine();
			int nTeams = Integer.parseInt(br.readLine());
			ArrayList<Team> teams = new ArrayList<>();
			HashMap<String, Team> map = new HashMap<>();
			while(nTeams-->0) {
				Team t = new Team(br.readLine());
				map.put(t.name, t);
				teams.add(t);
			}
			int nGames = Integer.parseInt(br.readLine());
			while(nGames-->0) {
				String[] split = br.readLine().split("[#@]");
				Team t1 = map.get(split[0]);
				Team t2 = map.get(split[3]);
				int g1 = Integer.parseInt(split[1]);
				int g2 = Integer.parseInt(split[2]);
				if(g1==g2) {
					t1.d++;
					t2.d++;
				} else if(g1>g2) {
					t1.w++;
					t2.l++;
				} else {
					t1.l++;
					t2.w++;
				}
				t1.goalsFor+=g1;
				t2.goalsFor+=g2;
				t1.goalsAgainst+=g2;
				t2.goalsAgainst+=g1;
			}
			for(Team t: teams) t.calcStats();
			Collections.sort(teams);
			out.println(tName);
			for(int i=0; i<teams.size(); i++) out.println((i+1)+") "+teams.get(i).toString());
			if(nC>0) out.println();
		}
		out.flush();
	}
	
	static class Team implements Comparable<Team> {
		String name;
		int points;
		int goalsFor;
		int goalsAgainst;
		int goalDiff;
		int w;
		int l;
		int d;
		int gamesPlayed;
		
		public Team(String name) {
			this.name = name;
			points = goalsFor = goalsAgainst = goalDiff = w = l = d = gamesPlayed = 0;
		}
		
		void calcStats() {
			points = w*3+d;
			goalDiff = goalsFor-goalsAgainst;
			gamesPlayed = w+l+d;
		}

		@Override
		public int compareTo(Team o) {
			if(this.points==o.points) {
				if(this.w==o.w) {
					if(this.goalDiff==o.goalDiff) {
						if(this.goalsFor==o.goalsFor) {
							if(this.gamesPlayed==o.gamesPlayed) return this.name.toLowerCase().compareTo(o.name.toLowerCase());
							return Integer.compare(this.gamesPlayed, o.gamesPlayed);
						}
						return Integer.compare(o.goalsFor, this.goalsFor);
					}
					return Integer.compare(o.goalDiff, this.goalDiff);
				}
				return Integer.compare(o.w, this.w);
			}
			return Integer.compare(o.points, this.points);
		}
		
		public String toString() {
			return name+" "+points+"p, "+gamesPlayed+"g ("+w+"-"+d+"-"+l+"), "+goalDiff+"gd ("+goalsFor+"-"+goalsAgainst+")";
		}
	}
}
