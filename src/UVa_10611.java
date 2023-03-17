

import java.util.Scanner;

public class UVa_10611 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] ladies = new int[n];

        for(int i=0; i<n; i++) {
            ladies[i] = sc.nextInt();
            min = Math.min(min, ladies[i]);
            max = Math.max(max, ladies[i]);
        }

        n = sc.nextInt();

        for(int i=0; i<n; i++) {
            int curr = sc.nextInt();

            int index = binarySearch(ladies, 0, ladies.length-1, curr);

            //System.out.println(index);

            if(ladies[index] == curr) {
                if(curr<=min)
                    System.out.print("X ");
                else {
                    int j = index-1;
                    while(j>=0) {
                        if(ladies[j]<curr){
                            System.out.print(ladies[j] + " ");
                            break;
                        }
                        j--;
                    }
                }

                if(curr>=max)
                    System.out.println("X");
                else {
                    int j = index+1;
                    while(j<ladies.length) {
                        if(ladies[j]>curr){
                            System.out.println(ladies[j]);
                            break;
                        }
                        j++;
                    }
                }
            }
            else {
                if(ladies[index] < curr) {
                    System.out.print(ladies[index] + " ");
                }
                else if((index - 1) >= 0) {
                    System.out.print(ladies[index - 1] + " ");
                }
                else {
                    System.out.print("X ");
                }

                if(ladies[index] > curr) {
                    System.out.println(ladies[index]);
                }
                else if((index + 1) < ladies.length) {
                    System.out.println(ladies[index+1]);
                }
                else {
                    System.out.println("X");
                }
            }
        }



    }
	
	
    public static int binarySearch(int[] list, int l, int r, int toFind) {

        int index = -1;

        while(l <= r) {
            int mid = (l + r) / 2;

            if(list[mid] == toFind) {
                    index = mid;
                    break;
            }
            else if(list[mid] > toFind) {
                    //the data is in the lower part
                    r = mid - 1;
                    index = l;
            }
            else if(list[mid] < toFind) {
                    //the data is inn the upper part
                    l = mid + 1;
                    index = mid;
            }
        }

        return index;

    }
}
