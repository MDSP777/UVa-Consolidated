

import java.util.Scanner;

public class UVa_10327 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            int n = sc.nextInt();
            int[] terms = new int[n];
            for(int i=0; i<n; i++)
                terms[i] = sc.nextInt();
            System.out.println("Minimum exchange operations : "+sort(terms));
        }while(sc.hasNext());
    }

    private static int sort(int[] terms) {
        int total = 0;
        for(int i=0; i<terms.length; i++)
            for(int j=0; j<terms.length-i-1; j++)
                if(terms[j]>terms[j+1]){
                    int temp = terms[j];
                    terms[j] = terms[j+1];
                    terms[j+1] = temp;
                    total++;
                }
        return total;
    }
}
