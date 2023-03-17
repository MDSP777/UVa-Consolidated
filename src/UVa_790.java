import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class UVa_790 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		br.readLine();
		while(nC-->0){
			HashMap<String, Team> map = new HashMap<>();
			ArrayList<InputLine> input = new ArrayList<>();
			int max = 0;
			while(true){
				String s = br.readLine();
				if(s==null || s.isEmpty()) break;
				String[] split = s.split("\\s+");
				max = Math.max(max, Integer.parseInt(split[0]));
				input.add(new InputLine(split));
			}
			Collections.sort(input);
			for(InputLine i: input){
				if(!map.containsKey(i.tId)) map.put(i.tId, new Team(i.tId));
				Team t = map.get(i.tId);
				if(t.acTime[i.pId]==-1){
					t.submissions[i.pId]++;
					if(i.v.equals("Y")) 
						t.acTime[i.pId] = i.time;
				}
			}
			for(int i=1; i<=max; i++) if(!map.containsKey(i+"")) map.put(i+"", new Team(i+""));
			ArrayList<Team> res = new ArrayList<>();
			for(Team t: map.values()) res.add(t);
			Collections.sort(res);
			StringBuilder sb = new StringBuilder();
			sb.append("RANK TEAM PRO/SOLVED TIME\n");
			int curRank = 1;
			int curAC = res.get(0).totalSolved();
			int curPenalty = res.get(0).totalPenalty();
			for(int i=0; i<res.size(); i++) {
				Team t = res.get(i);
				if(t.totalSolved()<curAC || (t.totalSolved()==curAC && t.totalPenalty()>curPenalty)){
					curRank = i+1;
					curAC = t.totalSolved();
					curPenalty = t.totalPenalty();
				}
				String r = curRank+"";
				for(int j=0; j<4-r.length(); j++) sb.append(" ");
				sb.append(curRank).append(t).append("\n");
			}
			if(nC>0) sb.append("\n");
			System.out.print(sb);
		}
	}
	
	static int compute(String s){
		String[] split = s.split(":");
		return 60*Integer.parseInt(split[0])+Integer.parseInt(split[1]);
	}
	
	static class InputLine implements Comparable<InputLine> {
		String tId;
		int pId;
		int time;
		String v;
		
		public InputLine(String[] split){
			tId = split[0];
			pId = split[1].charAt(0)-'A';
			time = compute(split[2]);
			v = split[3];
		}

		@Override
		public int compareTo(InputLine o) {
			if(time==o.time){
				if(tId.equals(o.tId)){
					if(v.equals("N")) return -1;
					return 1;	
				}
				return tId.compareTo(o.tId);
			}
			return Integer.compare(time, o.time);
		}
		
		public String toString(){
			return tId+" "+((char)(pId+'A'))+" "+time+" "+v;
		}
	}
	
	static class Team implements Comparable<Team> {
		String id;
		int[] acTime;
		int[] submissions;
		
		public Team(String id){
			this.id = id;
			acTime = new int[7];
			for(int i=0; i<7; i++) acTime[i] = -1;
			submissions = new int[7];
		}
		
		public int totalSolved() {
			int total = 0;
			for(int i=0; i<7; i++) if(acTime[i]>-1) total++; 
			return total;
		}
		
		public int totalPenalty() {
			int total = 0;
			for(int i=0; i<7; i++) if(acTime[i]>-1) total += acTime[i] + 20*(submissions[i]-1);
			return total;
		}

		@Override
		public int compareTo(Team o) {
			if(totalSolved()==o.totalSolved())
				if(totalPenalty()==o.totalPenalty()) return Integer.compare(Integer.parseInt(id), Integer.parseInt(o.id));
				else return Integer.compare(totalPenalty(), o.totalPenalty());
			return Integer.compare(o.totalSolved(), totalSolved());
		}
		
		public String toString(){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<5-id.length(); i++) sb.append(" ");
			sb.append(id);
			if(totalSolved()>=1){
				sb.append("    ").append(totalSolved()).append("       ");
				String c = totalPenalty()+"";
				for(int i=0; i<4-c.length(); i++) sb.append(" ");
				sb.append(c);
			}
			return sb.toString();
		}
	}
}
