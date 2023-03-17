/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Scanner;

/**
 *
 * @author MarcDominic
 */
public class UVa_10196 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[8][8];
        boolean checker = false, whee, whee2;
        int cas=1;
        for(int i=0; i<8; i++)
            board[i] = sc.nextLine().toCharArray();
        checker = checkEmpty(board);
        
        while(!checker){
            whee = whee2 = false;
            System.out.print("Game #"+cas+": ");
            cas++;
            for(int i=0; i<8; i++)
                for(int j=0; j<8; j++){
                    if(board[i][j] == 'K'){
                        if(checkForCheckW(board, i, j)){
                            whee = true;
                            System.out.println("white king is in check.");
                        }
                    }
                    else if(board[i][j]== 'k'){
                        if(checkForCheckB(board, i, j)){
                            whee2 = true;
                            System.out.println("black king is in check.");
                        }
                    }
                    
                            
                }
            if(!whee && !whee2) System.out.println("no king is in check.");
            sc.nextLine();
            for(int i=0; i<8; i++)
                board[i] = sc.nextLine().toCharArray();
            checker = checkEmpty(board);
        }
    }
    
    public static boolean checkEmpty(char[][] a){
        for(int i=0; i<8; i++)
            for(int j=0; j<8; j++)
                if(a[i][j] != '.') return false;
        return true;
    }
    
    public static boolean checkForCheckW(char[][] board, int x, int y){
        for(int i=x-1; i>=0; i--)
            if(board[i][y]=='r'||board[i][y]=='q'){
                return true;
            }
            else if(board[i][y]!='.') break;
        for(int i=x+1; i<8; i++)
            if(board[i][y]=='r'||board[i][y]=='q'){
                return true;
            }
            else if(board[i][y]!='.') break;
        for(int i=y-1; i>=0; i--)
            if(board[x][i]=='r'||board[x][i]=='q'){
                return true;
            }
            else if(board[x][i]!='.') break;
        for(int i=y+1; i<8; i++)
            if(board[x][i]=='r'||board[x][i]=='q'){
                return true;
            }
            else if(board[x][i]!='.') break;
        
        try{
            if(board[x-1][y-1]=='p'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        try{
            if(board[x-1][y+1]=='p'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        int xx = x-1, yy=y-1;
        while(xx>=0&&yy>=0){
            if(board[xx][yy]=='b'||board[xx][yy]=='q'){
                return true;
            }
            else if(board[xx][yy]!='.') break;
            xx--;
            yy--;
        }
        xx = x+1;
        yy=y+1;
        while(xx<8&&yy<8){
            if(board[xx][yy]=='b'||board[xx][yy]=='q'){
                return true;
            }
            else if(board[xx][yy]!='.') break;
            xx++;
            yy++;
        }
        xx = x-1;
        yy = y+1;
        while(xx>=0&&yy<8){
            if(board[xx][yy]=='b'||board[xx][yy]=='q'){
                return true;
            }
            else if(board[xx][yy]!='.') break;
            xx--;
            yy++;
        }
        xx = x+1;
        yy = y-1;
        while(xx<8&&yy>=0){
            if(board[xx][yy]=='b'||board[xx][yy]=='q'){
                return true;
            }
            else if(board[xx][yy]!='.') break;
            xx++;
            yy--;
        }
        try{
            if(board[x-1][y-2]=='n'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        try{
            if(board[x-2][y-1]=='n'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        try{
            if(board[x+1][y+2]=='n'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        try{
            if(board[x+2][y+1]=='n'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        
        try{
            if(board[x-1][y+2]=='n'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        try{
            if(board[x-2][y+1]=='n'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        try{
            if(board[x+1][y-2]=='n'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        try{
            if(board[x+2][y-1]=='n'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        return false;
    }
    
    public static boolean checkForCheckB(char[][] board, int x, int y){
        for(int i=x-1; i>=0; i--)
            if(board[i][y]=='R'||board[i][y]=='Q'){
                return true;
            }
            else if(board[i][y]!='.') break;
        for(int i=x+1; i<8; i++)
            if(board[i][y]=='R'||board[i][y]=='Q'){
                return true;
            }
            else if(board[i][y]!='.') break;
        for(int i=y-1; i>=0; i--)
            if(board[x][i]=='R'||board[x][i]=='Q'){
                return true;
            }
            else if(board[x][i]!='.') break;
        for(int i=y+1; i<8; i++)
            if(board[x][i]=='R'||board[x][i]=='Q'){
                return true;
            }
            else if(board[x][i]!='.') break;
        
        try{
            if(board[x+1][y-1]=='P'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        try{
            if(board[x+1][y+1]=='P'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        int xx = x-1, yy=y-1;
        while(xx>=0&&yy>=0){
            if(board[xx][yy]=='B'||board[xx][yy]=='Q'){
                return true;
            }
            else if(board[xx][yy]!='.') break;
            xx--;
            yy--;
        }
        xx = x+1;
        yy=y+1;
        while(xx<8&&yy<8){
            if(board[xx][yy]=='B'||board[xx][yy]=='Q'){
                return true;
            }
            else if(board[xx][yy]!='.') break;
            xx++;
            yy++;
        }
        xx = x-1;
        yy = y+1;
        while(xx>=0&&yy<8){
            if(board[xx][yy]=='B'||board[xx][yy]=='Q'){
                return true;
            }
            else if(board[xx][yy]!='.') break;
            xx--;
            yy++;
        }
        xx = x+1;
        yy = y-1;
        while(xx<8&&yy>=0){
            if(board[xx][yy]=='B'||board[xx][yy]=='Q'){
                return true;
            }
            else if(board[xx][yy]!='.') break;
            xx++;
            yy--;
        }
        try{
            if(board[x-1][y-2]=='N'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        try{
            if(board[x-2][y-1]=='N'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        try{
            if(board[x+1][y+2]=='N'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        try{
            if(board[x+2][y+1]=='N'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        
        try{
            if(board[x-1][y+2]=='N'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        try{
            if(board[x-2][y+1]=='N'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        try{
            if(board[x+1][y-2]=='N'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        try{
            if(board[x+2][y-1]=='N'){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
        return false;
    }
}
