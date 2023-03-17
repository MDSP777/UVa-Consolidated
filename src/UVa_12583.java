

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_12583 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=1; x<=nC; x++){
            int l = sc.nextInt();
            int window = sc.nextInt();
            ArrayList<Person> p = new ArrayList();
            String w = sc.next();
            int total = 0;
            for(int i=0; i<l; i++){
                for(int j=0; j<p.size(); j++){
                    p.get(j).days++;
                    if(p.get(j).days>window){
                        p.remove(j);
                        j--;
                    }
                }
                char c = w.charAt(i);
                if(!has(p, c)){
                    p.add(new Person(c));
                }
                else{
                    for(int j=0; j<p.size(); j++)
                        if(p.get(j).name==c){
                            p.get(j).days=0;
                            break;
                        }
                    total++;
                }
            }
            System.out.println("Case "+x+": "+total);
        }
    }

    private static boolean has(ArrayList<Person> p, char c) {
        for(int i=0; i<p.size(); i++)
            if(p.get(i).name==c) return true;
        return false;
    }
    
    static class Person{
        char name;
        int days;
        
        public Person(char c){
            name = c;
            days = 0;
        }
    }
}
