

import java.util.Scanner;


public class UVa_10363 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            int tX=0, tO=0;
            String[] grid = new String[3];
            sc.nextLine();
            grid[0] = sc.nextLine();
            grid[1] = sc.nextLine();
            grid[2] = sc.nextLine();
            for(int i=0; i<3; i++){
                if(grid[0].charAt(i)=='X') tX++;
                if(grid[1].charAt(i)=='X') tX++;
                if(grid[2].charAt(i)=='X') tX++;

                if(grid[0].charAt(i)=='O') tO++;
                if(grid[1].charAt(i)=='O') tO++;
                if(grid[2].charAt(i)=='O') tO++;
            }

            if(Math.abs(tX-tO)>=2 || tO>tX){
                System.out.println("no");
            }
            else{
                int nwx = checkX(grid);
                int nwo = checkO(grid);
                if(nwx>=1&&nwo>=1)
                    System.out.println("no");
                else if(nwx==2&&tX==5)
                    System.out.println("yes");
                else if(nwx==1 && tX>tO)
                    System.out.println("yes");
                else if(nwx==1 && tX==tO)
                    System.out.println("no");
                else if(nwx>1)
                    System.out.println("no");
                else if(nwo==1 && tO==tX)
                    System.out.println("yes");
                else if(nwo==1 && tO<tX)
                    System.out.println("no");
                else if(nwo>1)
                    System.out.println("no");
                else if(checkDraw(grid)){
                    System.out.println("yes");
                }
                else{
                    System.out.println("yes");
                }
            }
        }
    }

    public static boolean checkDraw(String[] grid){
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                if(grid[i].charAt(j)=='.')
                    return false;
        return true;
    }

    public static int checkX(String[] grid){
        int nWins = 0;
        //check rows
        if(grid[0].equals("XXX")){
            nWins++;
        }
        if(grid[1].equals("XXX")){
            nWins++;
        }
        if(grid[2].equals("XXX")){
            nWins++;
        }

        //check cols
        if(grid[0].charAt(0)=='X'&&grid[1].charAt(0)=='X'&&grid[2].charAt(0)=='X'){
            nWins++;
        }
        if(grid[0].charAt(1)=='X'&&grid[1].charAt(1)=='X'&&grid[2].charAt(1)=='X'){
            nWins++;
        }
        if(grid[0].charAt(2)=='X'&&grid[1].charAt(2)=='X'&&grid[2].charAt(2)=='X'){
            nWins++;
        }

        //check diags
        if(grid[0].charAt(0)=='X'&&grid[1].charAt(1)=='X'&&grid[2].charAt(2)=='X'){
            nWins++;
        }
        if(grid[0].charAt(2)=='X'&&grid[1].charAt(1)=='X'&&grid[2].charAt(0)=='X'){
            nWins++;
        }

        return nWins;
    }

    public static int checkO(String[] grid){
        int nWins = 0;
        //check rows
        if(grid[0].equals("OOO")){
            nWins++;
        }
        if(grid[1].equals("OOO")){
            nWins++;
        }
        if(grid[2].equals("OOO")){
            nWins++;
        }

        //check cols
        if(grid[0].charAt(0)=='O'&&grid[1].charAt(0)=='O'&&grid[2].charAt(0)=='O'){
            nWins++;
        }
        if(grid[0].charAt(1)=='O'&&grid[1].charAt(1)=='O'&&grid[2].charAt(1)=='O'){
            nWins++;
        }
        if(grid[0].charAt(2)=='O'&&grid[1].charAt(2)=='O'&&grid[2].charAt(2)=='O'){
            nWins++;
        }

        //check diags
        if(grid[0].charAt(0)=='O'&&grid[1].charAt(1)=='O'&&grid[2].charAt(2)=='O'){
            nWins++;
        }
        if(grid[0].charAt(2)=='O'&&grid[1].charAt(1)=='O'&&grid[2].charAt(0)=='O'){
            nWins++;
        }

        return nWins;
    }
}
