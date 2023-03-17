import java.util.Scanner;
import java.util.TreeSet;

public class UVa_11222 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int nC = sc.nextInt();
		for(int x=1; x<=nC; x++) {
			TreeSet<Integer> a = new TreeSet<>();
			TreeSet<Integer> b = new TreeSet<>();
			TreeSet<Integer> c = new TreeSet<>();
			int nA = sc.nextInt();
			while(nA-->0) a.add(sc.nextInt());
			nA = sc.nextInt();
			while(nA-->0) b.add(sc.nextInt());
			nA = sc.nextInt();
			while(nA-->0) c.add(sc.nextInt());
			int t1 = 0;
			int t2 = 0;
			int t3 = 0;
			for(int i: a) if(!b.contains(i) && !c.contains(i)) t1++;
			for(int i: b) if(!a.contains(i) && !c.contains(i)) t2++;
			for(int i: c) if(!b.contains(i) && !a.contains(i)) t3++;
			int max = Math.max(t1, Math.max(t2, t3));
			sb.append("Case #").append(x).append(":\n");
			if(t1==max) {
				sb.append("1 ").append(t1);
				for(int i: a) if(!b.contains(i) && !c.contains(i)) sb.append(" ").append(i);
				sb.append("\n");
			}
			if(t2==max) {
				sb.append("2 ").append(t2);
				for(int i: b) if(!a.contains(i) && !c.contains(i)) sb.append(" ").append(i);
				sb.append("\n");
			}
			if(t3==max) {
				sb.append("3 ").append(t3);
				for(int i: c) if(!b.contains(i) && !a.contains(i)) sb.append(" ").append(i);
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}

/*

Note: Scanner approach is AC, but seemingly identical BufferedReader approach is WA

WA BufferedReader approach:

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class UVa_11222 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nC = Integer.parseInt(br.readLine());
		for(int x=1; x<=nC; x++) {
			TreeSet<Integer> a = new TreeSet<>();
			TreeSet<Integer> b = new TreeSet<>();
			TreeSet<Integer> c = new TreeSet<>();
			String[] split = br.readLine().split("\\s+");
			for(int i=1; i<split.length; i++) a.add(Integer.parseInt(split[i]));
			split = br.readLine().split("\\s+");
			for(int i=1; i<split.length; i++) b.add(Integer.parseInt(split[i]));
			split = br.readLine().split("\\s+");
			for(int i=1; i<split.length; i++) c.add(Integer.parseInt(split[i]));
			int t1 = 0;
			int t2 = 0;
			int t3 = 0;
			for(int i: a) if(!b.contains(i) && !c.contains(i)) t1++;
			for(int i: b) if(!a.contains(i) && !c.contains(i)) t2++;
			for(int i: c) if(!b.contains(i) && !a.contains(i)) t3++;
			int max = Math.max(t1, Math.max(t2, t3));
			sb.append("Case #").append(x).append(":\n");
			if(t1==max) {
				sb.append("1 ").append(t1);
				for(int i: a) if(!b.contains(i) && !c.contains(i)) sb.append(" ").append(i);
				sb.append("\n");
			}
			if(t2==max) {
				sb.append("2 ").append(t2);
				for(int i: b) if(!a.contains(i) && !c.contains(i)) sb.append(" ").append(i);
				sb.append("\n");
			}
			if(t3==max) {
				sb.append("3 ").append(t3);
				for(int i: c) if(!b.contains(i) && !a.contains(i)) sb.append(" ").append(i);
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}

*/