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
public class UVa_11956 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        sc.nextLine();
        for(int as=1; as<=nC; as++){
            String n = sc.nextLine();
            int ptr = 0;
            int[] arr = new int[100];
            for(int a=0; a<100; a++)
                arr[a] = 0;
            for(int i=0; i<n.length(); i++){
                if(n.charAt(i)=='>'){
                    ptr++;
                    if(ptr==100) ptr=0;
                }
                else if(n.charAt(i)=='<'){
                    ptr--;
                    if(ptr==-1) ptr=99;
                }
                else if(n.charAt(i)=='+'){
                    arr[ptr]++;
                    if(arr[ptr]==256) arr[ptr]=0;
                }
                else if(n.charAt(i)=='-'){
                    arr[ptr]--;
                    if(arr[ptr]==-1) arr[ptr]=255;
                }
            }
            System.out.print("Case "+as+": ");
            for(int i=0; i<99; i++){
                System.out.printf("%02X ", arr[i]);
            }
            System.out.printf("%02X", arr[99]);
            System.out.println();
        }
    }
}
