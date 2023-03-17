

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class UVa_604 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean first = true;
        while(true){
            char c1 = sc.next().charAt(0);
            if(c1=='#') break;
            if(!first) System.out.println("");
            if(first) first = false;
            char[][] grid1 = new char[4][4];
            char[][] grid2 = new char[4][4];
            
            grid1[0][0] = c1;
            for(int i=1; i<4; i++) grid1[0][i] = sc.next().charAt(0);
            for(int i=0; i<4; i++) grid2[0][i] = sc.next().charAt(0);
            
            for(int i=1; i<4; i++){
                for(int j=0; j<4; j++) grid1[i][j] = sc.next().charAt(0);
                for(int j=0; j<4; j++) grid2[i][j] = sc.next().charAt(0);
            }
            ArrayList<String> words1 = new ArrayList();
            ArrayList<String> words2 = new ArrayList();
            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    words1.addAll(getWords(grid1, new boolean[4][4], new StringBuilder(), i, j));
                    words2.addAll(getWords(grid2, new boolean[4][4], new StringBuilder(), i, j));
                }
            }
            words1.retainAll(words2);
            HashSet<String> rem = new HashSet<>(words1);
            words1.clear();
            words1.addAll(rem);
            Collections.sort(words1);
            if(words1.isEmpty()) System.out.println("There are no common words for this pair of boggle boards.");
            else
                for(String s: words1) System.out.println(s);
        }

    }

    private static ArrayList<String> getWords(char[][] grid, 
            boolean[][] visited, StringBuilder sb, int i, int j) {
        sb.append(grid[i][j]);
        visited[i][j] = true;
        ArrayList<String> total = new ArrayList<>();
        if(sb.length()==4) {
            String out = sb.toString();
            int ctr = 0;
            for(int ii=0; ii<4; ii++){
                char cur = out.charAt(ii);
                if(cur=='A' || cur=='E' || cur=='I' || cur=='O' || cur=='U' || cur=='Y') ctr++;
            }
            if(ctr==2) total.add(out);
            return total;
        }
        if(i>0 && j>0 && !visited[i-1][j-1]){
            StringBuilder sbCopy = new StringBuilder(sb.toString());
            boolean[][] newVisited = new boolean[4][4];
            for(int ii=0; ii<4; ii++)
                System.arraycopy(visited[ii], 0, newVisited[ii], 0, 4);
            total.addAll(getWords(grid, newVisited, sbCopy, i-1, j-1));
        }
        if(i>0 && !visited[i-1][j]){
            StringBuilder sbCopy = new StringBuilder(sb.toString());
            boolean[][] newVisited = new boolean[4][4];
            for(int ii=0; ii<4; ii++)
                System.arraycopy(visited[ii], 0, newVisited[ii], 0, 4);
            total.addAll(getWords(grid, newVisited, sbCopy, i-1, j));
        }
        if(i>0 && j<3 && !visited[i-1][j+1]){
            StringBuilder sbCopy = new StringBuilder(sb.toString());
            boolean[][] newVisited = new boolean[4][4];
            for(int ii=0; ii<4; ii++)
                System.arraycopy(visited[ii], 0, newVisited[ii], 0, 4);
            total.addAll(getWords(grid, newVisited, sbCopy, i-1, j+1));
        }
        if(j<3 && !visited[i][j+1]){
            StringBuilder sbCopy = new StringBuilder(sb.toString());
            boolean[][] newVisited = new boolean[4][4];
            for(int ii=0; ii<4; ii++)
                System.arraycopy(visited[ii], 0, newVisited[ii], 0, 4);
            total.addAll(getWords(grid, newVisited, sbCopy, i, j+1));
        }
        if(i<3 && j<3 && !visited[i+1][j+1]){
            StringBuilder sbCopy = new StringBuilder(sb.toString());
            boolean[][] newVisited = new boolean[4][4];
            for(int ii=0; ii<4; ii++)
                System.arraycopy(visited[ii], 0, newVisited[ii], 0, 4);
            total.addAll(getWords(grid, newVisited, sbCopy, i+1, j+1));
        }
        if(i<3 && !visited[i+1][j]){
            StringBuilder sbCopy = new StringBuilder(sb.toString());
            boolean[][] newVisited = new boolean[4][4];
            for(int ii=0; ii<4; ii++)
                System.arraycopy(visited[ii], 0, newVisited[ii], 0, 4);
            total.addAll(getWords(grid, newVisited, sbCopy, i+1, j));
        }
        if(i<3 && j>0 && !visited[i+1][j-1]){
            StringBuilder sbCopy = new StringBuilder(sb.toString());
            boolean[][] newVisited = new boolean[4][4];
            for(int ii=0; ii<4; ii++)
                System.arraycopy(visited[ii], 0, newVisited[ii], 0, 4);
            total.addAll(getWords(grid, newVisited, sbCopy, i+1, j-1));
        }
        if(j>0 && !visited[i][j-1]){
            StringBuilder sbCopy = new StringBuilder(sb.toString());
            boolean[][] newVisited = new boolean[4][4];
            for(int ii=0; ii<4; ii++)
                System.arraycopy(visited[ii], 0, newVisited[ii], 0, 4);
            total.addAll(getWords(grid, newVisited, sbCopy, i, j-1));
        }
        return total;
    }
}
