

import java.math.BigInteger;
import java.util.Scanner;

public class UVa_11664 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            String c = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(n==0 && c.equals("0") && x==0 && y==0) break;
            
            BigInteger b = new BigInteger(c);
            String bin = b.toString(2);
            
            boolean[][] grid = new boolean[n][n];
            while(bin.length()!=n*n) bin = "0"+bin;
            
            for(int i=n-1; i>=0; i--){
                for(int j=0; j<n; j++){
                    grid[i][j] = bin.charAt((n-i-1)*n+j) == '1'; 
                }
            }
            
            x--;
            y = n-y;
            int temp = x;
            x = y;
            y = temp;
            char dir = 'N';
            boolean dead = false;
            
            while(true){
                if(y==n-1 && x==0){
                    dead = false;
                    break;
                }
//                System.out.println(x+" "+y+" "+grid[x][y]+dir);
                if(!grid[x][y]){
                    if(dir=='N'){
                        dir = 'W';
                    } else if(dir=='W'){
                        dir = 'S';
                    } else if(dir=='S'){
                        dir = 'E';
                    } else {
                        dir = 'N';
                    }
                    grid[x][y] = !grid[x][y];
                    if(dir=='N'){
                        if(x==0){
                            dead = true;
                            break;
                        } else {
                            x--;
                        }
                    } else if(dir=='W'){
                        if(y==0){
                            dead = true;
                            break;
                        } else {
                            y--;
                        }
                    } else if(dir=='S'){
                        if(x==n-1){
                            dead = true;
                            break;
                        } else {
                            x++;
                        }
                    } else if(dir=='E'){
                        if(y==n-1){
                            dead = true;
                            break;
                        } else {
                            y++;
                        }
                    }
                } else {
                    if(dir=='N'){
                        dir = 'E';
                    } else if(dir=='W'){
                        dir = 'N';
                    } else if(dir=='S'){
                        dir = 'W';
                    } else {
                        dir = 'S';
                    }
                    grid[x][y] = !grid[x][y];
                    if(dir=='N'){
                        if(x==0){
                            dead = true;
                            break;
                        } else {
                            x--;
                        }
                    } else if(dir=='W'){
                        if(y==0){
                            dead = true;
                            break;
                        } else {
                            y--;
                        }
                    } else if(dir=='S'){
                        if(x==n-1){
                            dead = true;
                            break;
                        } else {
                            x++;
                        }
                    } else if(dir=='E'){
                        if(y==n-1){
                            dead = true;
                            break;
                        } else {
                            y++;
                        }
                    }
                }
                
            }
            System.out.println(dead ? "Kaputt!" : "Yes");
        }

    }
}
