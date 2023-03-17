/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author MarcDominic
 */
import java.util.Scanner;

public class UVa_11661{
	public static void main(String[] ags){
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		String road, dump;
		while(l!=0){
                   dump = sc.nextLine();
		   road = sc.nextLine();
		   find(road);
                   l = sc.nextInt();
		}
	}
	
	public static void find(String road){
		char curr = 'H';
		int a = 0, dist = 2000005, distTemp;
		for(int i=0; i<road.length(); i++){
			if(road.charAt(i)=='Z'){
				dist = 0;
				break;
			}
			else if(road.charAt(i)!='.'){
				if(curr=='H'){
					curr = road.charAt(i);
					a = i;
				}
				else{
					if(curr==road.charAt(i))
						a = i;
					else{
						distTemp = Math.abs(a-i);
						if(distTemp<dist)
							dist = distTemp;
						curr = road.charAt(i);
						a = i;
					}
				}
			}
	   }
	   System.out.println(dist);
	}
}
