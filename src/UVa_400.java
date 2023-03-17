import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_400 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s==null) break;
			int n = Integer.parseInt(s);
			ArrayList<String> l = new ArrayList<>();
			int longest = 0;
			while(n-->0) {
				String cur = br.readLine();
				l.add(cur);
				longest = Math.max(longest, cur.length());
			}
			Collections.sort(l);
			int nCols = 1;
			int rem = 60-longest-(longest+2);
			while(rem>=0) {
				nCols++;
				rem-=longest+2;
			}
			int nRows = l.size()/nCols;
			if(l.size()%nCols>0) nRows++;
			StringBuilder sb = new StringBuilder("------------------------------------------------------------\n");
			for(int i=0; i<nRows; i++) {
				for(int j=0; j<nCols; j++) {
					if(j*nRows+i>=l.size()) break;
					sb.append(l.get(j*nRows+i));
					if(j!=nCols-1) 
						for(int k=l.get(j*nRows+i).length(); k<longest+2; k++) sb.append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
			
		}
	}
}
