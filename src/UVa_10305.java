import java.util.ArrayList;
import java.util.Scanner;

public class UVa_10305 {
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 while(true) {
			 int nJobs = sc.nextInt();
			 int m = sc.nextInt();
			 if(nJobs==0 && m==0) break;
			 ArrayList<Integer>[] prereqs = new ArrayList[nJobs];
			 for(int i=0; i<nJobs; i++) prereqs[i] = new ArrayList<>();
			 for(int i=0; i<m; i++) {
				 int a = sc.nextInt()-1;
				 int b = sc.nextInt()-1;
				 prereqs[b].add(a);
			 }
			 ArrayList<Integer> order = new ArrayList<>();
			 boolean[] completed = new boolean[nJobs];
			 while(!allCompleted(completed)) {
				 for(int i=0; i<nJobs; i++) {
					 if(!completed[i] && completedPrereqs(prereqs[i], completed)) {
						 completed[i] = true;
						 order.add(i+1);
					 }
				 }
			 }
			 System.out.print(order.get(0));
			 for(int i=1; i<order.size(); i++) System.out.print(" "+order.get(i));
			 System.out.println();
		 }
	 }
	 
	 private static boolean completedPrereqs(ArrayList<Integer> prereqs, boolean[] completed) {
		for(int i=0; i<prereqs.size(); i++) if(!completed[prereqs.get(i)]) return false;
		 return true;
	}

	static boolean allCompleted(boolean[] b) {
		 for(int i=0; i<b.length; i++) if(!b[i]) return false;
		 return true;
	 }
}
