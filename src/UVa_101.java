/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author MarcDominic
 */
public class UVa_101 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nB = sc.nextInt();
        sc.nextLine();
        Stack<Integer>[] bWorld = new Stack[nB];
        for(int i=0; i<nB; i++){
            bWorld[i] = new Stack();
            bWorld[i].push(i);
        }
        String com = sc.nextLine();
        while(!com.equals("quit")){
            String[] c = com.split(" ");
            int a=0, b=0;
            for(int i=0; i<nB; i++){
                if(bWorld[i].search(Integer.parseInt(c[1]))!=-1){
                    a=i;
                    break;
                }
            }
            for(int i=0; i<nB; i++){
                if(bWorld[i].search(Integer.parseInt(c[3]))!=-1){
                    b=i;
                    break;
                }
            }
            if(a!=b){
                if(c[0].equals("move")){
                    while(bWorld[a].peek()!=Integer.parseInt(c[1])){
                        int temp = bWorld[a].pop();
                        bWorld[temp].push(temp);
                    }
                    if(c[2].equals("onto")){
                        while(bWorld[b].peek()!=Integer.parseInt(c[3])){
                            int temp = bWorld[b].pop();
                            bWorld[temp].push(temp);
                        } 
                    }
                    bWorld[b].push(bWorld[a].pop());
                }
                else if(c[0].equals("pile")){
                    Stack<Integer> temp = new Stack();
                    while(bWorld[a].peek()!=Integer.parseInt(c[1])){
                        temp.push(bWorld[a].pop());
                    }
                    temp.push(bWorld[a].pop());
                    if(c[2].equals("onto")){
                        while(bWorld[b].peek()!=Integer.parseInt(c[3])){
                            int lol = bWorld[b].pop();
                            bWorld[lol].push(lol);
                        } 
                    }
                    while(!temp.empty()){
                        bWorld[b].push(temp.pop());
                    }
                }
                //display(bWorld);
            }
            com = sc.nextLine();
        }
        display(bWorld);
    }
    
    public static void display(Stack<Integer>[] a){
        StringBuilder out = new StringBuilder();
        for(int i=0; i<a.length; i++){
            out.append(i+":");
            Stack<Integer> temp = new Stack();
            while(!a[i].empty()){
                temp.push(a[i].pop());
            }
            while(!temp.empty()){
                int s = temp.pop();
                a[i].push(s);
                out.append(" "+s);
            }
            out.append("\n");
        }
        System.out.print(out);
    }
}
