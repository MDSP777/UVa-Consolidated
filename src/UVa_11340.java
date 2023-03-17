import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_11340 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			int nChars = Integer.parseInt(br.readLine());
			double[] prices = new double[1000];
			for(int i=0; i<nChars; i++) {
				String s = br.readLine();
				prices[s.charAt(0)] = Double.parseDouble(s.substring(2));
			}
			long total = 0;
			double nLines = Integer.parseInt(br.readLine());
			for(int i=0; i<nLines; i++) {
				String line = br.readLine();
				for(int j=0; j<line.length(); j++) total+=prices[line.charAt(j)];
			}
			System.out.printf("%.2f$\n", total*1.0/100);
		}
	}
}

/*
Note: RTE with current implementation. Not sure why. Yet for some reason the code below is AC

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class UVa_11340 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();
            for (int i = 0; i <= 255; i++) {
                map.put((byte) i, 0);
            }
            String s;
            for (int i = 0; i < K; i++) {
                s = br.readLine();
                map.put((byte) s.charAt(0), Integer.parseInt(s.substring(2)));
            }
            int n = Integer.parseInt(br.readLine());
            double ans = 0;
            byte x;
            for (int i = 0; i < n; i++) {
                while ((x = (byte) br.read()) != '\n') {
                    ans += map.get(x);
                }
            }
            System.out.format("%.2f$\n", ans / 100);
        }
    }

}

*/