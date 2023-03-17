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
public class UVa_11498 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt(), xpos, ypos;
        while(nC!=0){
            xpos = sc.nextInt();
            ypos = sc.nextInt();
            for(int i=0; i<nC; i++){
                doShit(xpos, ypos, sc.nextInt(), sc.nextInt());
            }
            nC = sc.nextInt();
        }
    }
    
    public static void doShit(int xpos, int ypos, int x, int y){
        if(x==xpos||y==ypos){
            System.out.println("divisa");
            return;
        }
        if(x>xpos)
            if(y>ypos){
                System.out.println("NE");
                return;
            }
            else{
                System.out.println("SE");
                return;
            }
        if(x<xpos)
            if(y>ypos){
                System.out.println("NO");
                return;
            }
            else{
                System.out.println("SO");
                return;
            }
        System.out.println("hiii");
    }
}
