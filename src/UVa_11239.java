import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class UVa_11239 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			HashSet<String> names = new HashSet<>();
			ArrayList<Project> projects = new ArrayList<>();
			while(true) {
				if(s.equals("1")) break;
				if(s.equals("0")) return;
				String projName = s;
				Project p = new Project(projName);
				while(true) {
					s = br.readLine();
					if(s.equals(s.toUpperCase()) || s.equals("1")) break;
					p.members.add(s);
					names.add(s);
				}
				projects.add(p);
			}
			HashSet<String> moreThanOneProj = new HashSet<>();
			for(String n: names) {
				int t = 0;
				for(Project p: projects) if(p.members.contains(n)) t++;
				if(t>1) moreThanOneProj.add(n);
			}
			for(String n: moreThanOneProj)
				for(Project p: projects) if(p.members.contains(n)) p.members.remove(n);
			Collections.sort(projects);
			for(Project p: projects) System.out.println(p);
		}
	}
	
	static class Project implements Comparable<Project> {
		String name;
		HashSet<String> members;
		
		public Project(String n) {
			name = n;
			members = new HashSet<>();
		}

		@Override
		public int compareTo(Project o) {
			if(this.members.size()==o.members.size()) return this.name.compareTo(o.name);
			return Integer.compare(o.members.size(), this.members.size());
		}
		
		public String toString() {
			return name+" "+members.size();
		}
	}
}
