import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_450 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Person> p = new ArrayList<>();
		while(n-->0) {
			String dept = br.readLine();
			while(true) {
				String s = br.readLine();
				if(s==null || s.isEmpty()) break;
				String[] split = s.split(",");
				p.add(new Person(split[0], split[1], split[2], split[3], dept, split[4], split[5], split[6]));
			}
		}
		Collections.sort(p);
		for(Person x: p) System.out.println(x);
	}
	
	static class Person implements Comparable<Person> {
		String title;
		String fName;
		String lName;
		String address;
		String dept;
		String homePhone;
		String workPhone;
		String box;
		
		public Person(String t, String f, String l, String a, String d, String h, String w, String b) {
			title = t;
			fName = f;
			lName = l;
			address = a;
			dept = d;
			homePhone = h;
			workPhone = w;
			box = b;
		}

		@Override
		public int compareTo(Person o) {
			if(this.lName.equals(o.lName)) return this.fName.compareTo(o.fName);
			return this.lName.compareTo(o.lName);
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder("----------------------------------------\n");
			sb.append(title).append(" ").append(fName).append(" ").append(lName).append("\n");
			sb.append(address).append("\n");
			sb.append("Department: ").append(dept).append("\n");
			sb.append("Home Phone: ").append(homePhone).append("\n");
			sb.append("Work Phone: ").append(workPhone).append("\n");
			sb.append("Campus Box: ").append(box);
			return sb.toString();
		}
	}
}
