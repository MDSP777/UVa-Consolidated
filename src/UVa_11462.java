import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_11462 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        int n = sc.nextInt();
        while(n!=0){
            ArrayList<Integer> a = new ArrayList();
            for(int i=0; i<n; i++)
                a.add(sc.nextInt());
            Collections.sort(a);
            for(int i=0; i<n; i++){
                out.append(a.get(i)+" ");
            }
            out.deleteCharAt(out.length()-1);
            out.append("\n");
            n = sc.nextInt();
        }
        System.out.print(out);
    }
}
