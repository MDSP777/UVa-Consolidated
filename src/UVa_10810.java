import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_10810 {
	static long total;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			total = 0;
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			arr = new int[n];
			for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
			mergeSort(0, n-1);
			sb.append(total).append("\n");
		}
		System.out.print(sb);
	}

	private static void mergeSort(int l, int r) {
		if(l<r) {
			int m = (l+r)/2;
			mergeSort(l, m);
			mergeSort(m+1, r);
			merge(l, m, r);
		}
	}

	private static void merge(int l, int m, int r) {
		int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int [n1];
        int R[] = new int [n2];
        for (int i=0; i<n1; i++) L[i] = arr[l + i];
        for (int j=0; j<n2; j++) R[j] = arr[m + 1+ j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else {
            	arr[k++] = R[j++];
            	total += n1-i;
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
	}
}
