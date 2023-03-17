import java.util.Scanner;


public class UVa_1588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do{
			char[] a = sc.next().toCharArray();
			char[] b = sc.next().toCharArray();
			if(a.length>b.length){
				char[] temp = a;
				a = b;
				b = temp;
			}
			for(int i=0; i<a.length; i++) a[i]-='1';
			for(int i=0; i<b.length; i++) b[i]-='1';
			int ans = a.length+b.length, best = b.length;
			for(int i=a.length-1; i>=0; i--){
				int nOverlap = a.length-i;
				boolean isValid = true;
				for(int j=0; j<b.length && j<nOverlap && isValid; j++){
					isValid&=(a[i+j]&b[j])==0;
				}
				if(isValid){
					ans = Math.min(ans, a.length+b.length-nOverlap);
					if(ans==best) break;
				}
			}
			for(int i=1; i<b.length; i++){
				int nOverlap = Math.min(b.length-i, a.length);
				boolean isValid = true;
				for(int j=0; j<a.length && j<b.length && j<nOverlap && isValid; j++){
					isValid&=(a[j]&b[i+j])==0;
				}
				if(isValid){
					ans = Math.min(ans, a.length+b.length-nOverlap);
					if(ans==best) break;
				}
			}
			System.out.println(ans);
		}while(sc.hasNext());
	}
}
