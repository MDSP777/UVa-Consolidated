import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_10249 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int t = sc.nextInt();
			int k = sc.nextInt();
			if(t==0 && k==0) break;
			
			ArrayList<Table> teams = new ArrayList<>();
			for(int i=0; i<t; i++) teams.add(new Table(sc.nextInt(), i));
			ArrayList<Table> tables = new ArrayList<>();
			for(int i=0; i<k; i++) tables.add(new Table(sc.nextInt(), i+1));
			Collections.sort(teams, Collections.reverseOrder());
			Collections.sort(tables, Collections.reverseOrder());
			
			StringBuilder[] ans = new StringBuilder[t];
			for(int i=0; i<t; i++) ans[i] = new StringBuilder();
			boolean fail = false;
			for(int i=0; !fail && i<t; i++){
				int toAssign = teams.get(i).size;
				for(int j=0; toAssign>0 && j<k; j++)
					if(tables.get(j).size>0){
						toAssign--;
						ans[teams.get(i).id].append(tables.get(j).id).append(" ");
						tables.get(j).size--;
					}
				if(toAssign>0) fail = true;
				Collections.sort(tables, Collections.reverseOrder());
			}
			
			if(fail) System.out.println(0);
			else {
				System.out.println(1);
				for(int i=0; i<t; i++) System.out.println(ans[i].toString().trim());
			}
		}
	}
	
	static class Table implements Comparable<Table>{
		int size, id;
		
		Table(int a, int b){
			size = a;
			id = b;
		}

		@Override
		public int compareTo(Table o) {
			return size-o.size;
		}
	}
}
