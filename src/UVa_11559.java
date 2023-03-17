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
public class UVa_11559 {
    public  static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nPeople, budget, nHotels, weeks;
        Hotel[] hArr;
        int min, temp;
        do{
            min = Integer.MAX_VALUE;
            nPeople = sc.nextInt();
            budget = sc.nextInt();
            nHotels = sc.nextInt();
            weeks = sc.nextInt();
            hArr = new Hotel[nHotels];
            for(int i=0; i<nHotels; i++){
                hArr[i] = new Hotel(sc.nextInt(), weeks);
                for(int j=0; j<weeks; j++){
                    hArr[i].weeks[j] = sc.nextInt();
                    if(hArr[i].weeks[j]>=nPeople){
                        temp = nPeople*hArr[i].price;
                        if(temp<min && temp <= budget)
                            min = temp;
                    }
                }
            }
            if(min==Integer.MAX_VALUE)
                System.out.println("stay home");
            else System.out.println(min);
        }while(sc.hasNext());
    }
    
    public static class Hotel{
        int price;
        int[] weeks;
        
        public Hotel(int price, int weeks){
            this.price = price;
            this.weeks = new int[weeks];
        }
    }
}
