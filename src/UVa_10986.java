

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class UVa_10986 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=1; x<=nC; x++){
            int nVerts = sc.nextInt();
            int nEdges = sc.nextInt();
            int src = sc.nextInt();
            int dest = sc.nextInt();

            ArrayList<Node> nodes = new ArrayList<>();
            final int[] dist = new int[nVerts];
            PriorityQueue<Node> q = new PriorityQueue<>(1, new Comparator<Node>() {

                @Override
                public int compare(Node n1, Node n2) {
                    return Integer.compare(dist[n1.val], dist[n2.val]);
                }
            });
            for(int i=0; i<nVerts; i++){
                if(i!=src) dist[i] = Integer.MAX_VALUE;
                nodes.add(new Node(i));
                q.add(nodes.get(i));
            }

            for(int i=0; i<nEdges; i++){
                int s = sc.nextInt();
                int d = sc.nextInt();
                int weight = sc.nextInt();
                nodes.get(s).edges.add(new Edge(nodes.get(s), nodes.get(d), weight));
                nodes.get(d).edges.add(new Edge(nodes.get(d), nodes.get(s), weight));
            }
            
            boolean found = true;
            while(!q.isEmpty()){
                System.out.println(q);
                Node curNode = q.poll();
                System.out.println(curNode);
                if(dist[curNode.val]==Integer.MAX_VALUE){
                    found = false;
                    break;
                }
                for(Edge e: curNode.edges){
                    int altDist = e.weight+dist[curNode.val];
                    if(altDist<dist[e.dest.val]){
                        dist[e.dest.val] = altDist;
                    }
                }
                if(curNode.val==dest) break;
            }
            if(!found) System.out.println("Case #"+x+": unreachable");
            else System.out.println("Case #"+x+": "+dist[dest]);
        }
    }

    static class Node {
        int val;
        ArrayList<Edge> edges = new ArrayList<>();

        public Node(int val){
            this.val = val;
            edges = new ArrayList<>();
        }
        
        public String toString(){
            return "Node "+val;
        }
    }

    static class Edge {
        int weight;
        Node src;
        Node dest;

        public Edge(Node src, Node dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
}
