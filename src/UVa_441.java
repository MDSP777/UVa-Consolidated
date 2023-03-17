import java.util.Scanner;

public class UVa_441 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		while(true) {
			int nTerms = sc.nextInt();
			if(nTerms==0) break;
			if(first) first = false;
			else sb.append("\n");
			int[] arr = new int[nTerms];
			for(int i=0; i<nTerms; i++) arr[i] = sc.nextInt();
			for(int i=0; i<nTerms-5; i++) 
				for(int j=i+1; j<nTerms-4; j++)
					for(int k=j+1; k<nTerms-3; k++)
						for(int l=k+1; l<nTerms-2; l++)
							for(int m=l+1; m<nTerms-1; m++)
								for(int n=m+1; n<nTerms; n++)
									sb.append(arr[i]).append(" ").append(arr[j]).append(" ").append(arr[k]).append(" ").append(arr[l]).append(" ").append(arr[m]).append(" ").append(arr[n]).append("\n");	
		}
		System.out.print(sb);
	}
}
