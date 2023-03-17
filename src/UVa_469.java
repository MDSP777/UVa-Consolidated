/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MarcDominic
 */
public class UVa_469 {
    static int total;
    static boolean[][] visited = new boolean[100][100];
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        sc.nextLine(); sc.nextLine();
        ArrayList<String> map;
        
        for(int i=0; i<nC; i++){
            map = new ArrayList();
            for(int x=0; x<100; x++)
                for(int y=0; y<100; y++) visited[x][y] = false;
            boolean cond = true;
            String n;
            do{
                n = sc.nextLine();
                if(n.charAt(0)=='W'||n.charAt(0)=='L'){
                    map.add(n);
                }
                else cond = false;
            }while(cond);
            cond = true;
            while(cond){
                for(int x=0; x<100; x++)
                    for(int y=0; y<100; y++) visited[x][y] = false;
                int x, y;
                String[] arr = n.split(" ");
                y = Integer.parseInt(arr[0])-1;
                x = Integer.parseInt(arr[1])-1;
                n = sc.nextLine();
                if(n.length()<2) cond = false;
                total = 0;
                if(x>=0 && x<map.get(0).length() && y>=0 && y<map.size()){
                    computeW(map, x, y);
                }
                System.out.println(total);
                if(!sc.hasNext()){
                    arr = n.split(" ");
                    y = Integer.parseInt(arr[0])-1;
                    x = Integer.parseInt(arr[1])-1;
                    total = 0;
                    if(x>=0 && x<map.get(0).length() && y>=0 && y<map.size()){
                        computeW(map, x, y);
                    }
                    System.out.println(total);
                    cond=false;
                }
            }
            if(i<nC-1)System.out.println();
        }
    }
   
    public static void computeW(ArrayList<String> map, int x, int y){
        if(map.get(y).charAt(x)=='W'){
            total++;
            visited[x][y] = true;
        }
        else return;
        if(x>0 && map.get(y).charAt(x-1)=='W' && !visited[x-1][y]) computeW(map, x-1, y);
        if(x<map.get(0).length()-1 && map.get(y).charAt(x+1)=='W' && !visited[x+1][y])computeW(map, x+1, y);
        if(y>0 && map.get(y-1).charAt(x)=='W' && !visited[x][y-1])computeW(map, x, y-1);
        if(y<map.size()-1 && map.get(y+1).charAt(x)=='W' && !visited[x][y+1])computeW(map, x, y+1);
        if(x>0 && y>0 && map.get(y-1).charAt(x-1)=='W' && !visited[x-1][y-1])computeW(map, x-1, y-1);
        if(x>0 && y<map.size()-1 && map.get(y+1).charAt(x-1)=='W' && !visited[x-1][y+1])computeW(map, x-1, y+1);
        if(x<map.get(0).length()-1 && y>0 && map.get(y-1).charAt(x+1)=='W' && !visited[x+1][y-1])computeW(map, x+1, y-1);
        if(x<map.get(0).length()-1 && y<map.size()-1 && map.get(y+1).charAt(x+1)=='W' && !visited[x+1][y+1])computeW(map, x+1, y+1);
    }
}
