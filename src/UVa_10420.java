

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_10420 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Country> list = new ArrayList();
        for(int i=0; i<n; i++){
            inc(list, sc.next());
            sc.nextLine();
        }
        Collections.sort(list);
        int l = list.size();
        for(int i=0; i<l; i++)
            System.out.println(list.get(i).name+" "+list.get(i).score);
    }
    
    static class Country implements Comparable<Country>{
        String name;
        int score;
        
        public Country(String s, int n){
            name = s;
            score = n;
        }
        
        public int compareTo(Country other) {
            return name.compareTo(other.name);
        }
    }
    
    static void inc(ArrayList<Country> list, String n){
        int l = list.size();
        for(int i=0; i<l; i++)
            if(list.get(i).name.equals(n)){
                list.get(i).score++;
                return;
            }
        list.add(new Country(n, 1));
    }
}
