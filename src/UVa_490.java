

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_490 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> input = new ArrayList();
        int longest = 0;
        do{
            String n = sc.nextLine();
            input.add(n);
            longest = Math.max(longest, n.length());
        }while(sc.hasNext());
//        input.add("Rene Decartes once said,");
//        longest = Math.max(longest, "Rene Decartes once said,".length());
//        input.add("\"I think, therefore I am.\"");
//        longest = Math.max(longest, "\"I think, therefore I am.\"".length());
        int s = input.size();
        char[][] grid = new char[longest][s];
        for(int i=0; i<longest; i++)
            for(int j=0; j<s; j++)
                grid[i][j] = ' ';
        s--;
        for(String str: input){
            int l = str.length();
            for(int i=0; i<l; i++)
                grid[i][s] = str.charAt(i);
            s--;
        }
        for(char[] c: grid)
            System.out.println(c);
    }
}
