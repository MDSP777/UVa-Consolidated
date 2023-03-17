import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_468 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			String key = sc.next();
			String toDecode = sc.next();
			int[] keyFreq = new int[150];
			for(int i=0; i<key.length(); i++) {
				char c = key.charAt(i);
				if((c>='a' && c<='z') || (c>='A' && c<='Z')) keyFreq[c]++;
			}
			int[] decodeFreq = new int[150];
			for(int i=0; i<toDecode.length(); i++) {
				char c = toDecode.charAt(i);
				if((c>='a' && c<='z') || (c>='A' && c<='Z')) decodeFreq[c]++;
			}
			ArrayList<Freq> keyFreqs = new ArrayList<>();
			ArrayList<Freq> decodeFreqs = new ArrayList<>();
			for(int i=0; i<150; i++) {
				if((i>='a' && i<='z') || (i>='A' && i<='Z')) {
					if(keyFreq[i]>=1) keyFreqs.add(new Freq((char)i, keyFreq[i]));
					if(decodeFreq[i]>=1) decodeFreqs.add(new Freq((char)i, decodeFreq[i]));
				}
			}
			Collections.sort(keyFreqs);
			Collections.sort(decodeFreqs);
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<toDecode.length(); i++) {
				char c = toDecode.charAt(i);
				if((c>='a' && c<='z') || (c>='A' && c<='Z')) 
				sb.append(match(c, keyFreqs, decodeFreqs));
			}
			System.out.println(sb);
			if(nC>=1) System.out.println();
		}
	}

	private static char match(char c, ArrayList<Freq> keyFreq, ArrayList<Freq> decodeFreq) {
		int index = 0;
		for(int i=0; i<decodeFreq.size(); i++) 
			if(decodeFreq.get(i).c==c) {
				index = i;
				break;
			}
		return keyFreq.get(index).c;
	}
	
	static class Freq implements Comparable<Freq> {
		char c;
		int freq;
		
		public Freq(char c, int freq) {
			this.c = c;
			this.freq = freq;
		}

		@Override
		public int compareTo(Freq o) {
			return Integer.compare(o.freq, this.freq);
		}
	}
}
