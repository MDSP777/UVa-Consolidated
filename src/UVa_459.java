

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_459 {
    static boolean[] visited;
    static ArrayList<Edge> edges;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        sc.nextLine();
        sc.nextLine();
        for(int x=0; x<nC; x++){
            char maxLetter = sc.nextLine().charAt(0);
            visited = new boolean[maxLetter+1];
            edges = new ArrayList();
            while(true){
                String cur = sc.nextLine();
                if(/*!sc.hasNext() || */cur.equals("")) break;
                edges.add(new Edge(cur.charAt(0), cur.charAt(1)));
            }
            int total = 0;
            for(int i='A'; i<=maxLetter; i++){
                if(!visited[i]){
                    total++;
                    clean((char)i);
                }
            }
            System.out.println(total);
            if(x<nC-1) System.out.println();
        }
    }
    
    // idea of clean() is to remove all edges containing the given node from list
    private static void clean(char c) {
        for(int i=0; i<edges.size(); i++){
            Edge cur = edges.get(i);
            if(cur.src==c || cur.dest==c){
                visited[cur.src] = true;
                visited[cur.dest] = true;
                edges.remove(i);
                i--;
                clean(cur.src);
                clean(cur.dest);
            }
        }
    }
    
    static class Edge{
        char src;
        char dest;
        
        public Edge(char s, char d){
            src = s;
            dest = d;
        }
    }
}
