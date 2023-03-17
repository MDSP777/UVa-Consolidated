

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UVa_10004 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            int nNodes = sc.nextInt();
            if(nNodes==0) break;
            
            ArrayList<Node> nodes = new ArrayList<>();
            for(int i=0; i<nNodes; i++) nodes.add(new Node(i));
            int nEdges = sc.nextInt();
            for(int i=0; i<nEdges; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                nodes.get(a).addNeighbor(nodes.get(b));
                nodes.get(b).addNeighbor(nodes.get(a));
            }
            
            if(checkColor(nodes)) System.out.println("BICOLORABLE.");
            else System.out.println("NOT BICOLORABLE.");
        }
    }
    
    static void resetColors(ArrayList<Node> nodes){
        int s = nodes.size();
        for(int i=0; i<s; i++){
            nodes.get(i).color = 0;
        }
    }

    private static boolean checkColor(ArrayList<Node> nodes) {
        boolean[] visited = new boolean[nodes.size()];
        Queue<Node> next = new LinkedList<>();
        int curColor = 1;
        Node cur = nodes.get(0);
        cur.color = 1;
        ArrayList<Node> n = cur.neighbors;
        int nNeighs = n.size();
        for(int j=0; j<nNeighs; j++){
            Node curNeighbor = n.get(j);
            curNeighbor.color = 2;
            next.add(curNeighbor);
            visited[j] = true;
        }
        visited[0] = true;
        int nNodes = nodes.size();
        curColor = 2;
        while(!next.isEmpty()){
            cur = next.remove();
            int newColor;
            curColor = cur.color;
            if(curColor==1){
                newColor = 2;
            }
            else{
                newColor = 1;
            }
            n = cur.neighbors;
            nNeighs = n.size();
            for(int j=0; j<nNeighs; j++){
                Node curNeighbor = n.get(j);
                if(curNeighbor.color==curColor){
                    return false;
                }
                curNeighbor.color = newColor;
                int asdf = curNeighbor.val;
                if(!visited[asdf]){
                    visited[asdf] = true;
                    next.add(curNeighbor);
                }
            }
            if(curColor==1){
                curColor = 2;
            }
            else{
                curColor = 1;
            }
        }
        
        return true;
    }
    
    static class Node {
        int val;
        int color; // 0 == no color yet, 1 == white, 2 == black
        ArrayList<Node> neighbors;
        
        public Node(int val){
            this.val = val;
            color = 0;
            neighbors = new ArrayList<>();
        }
        
        public void addNeighbor(Node n){
            this.neighbors.add(n);
        }
    }
}
