

import java.util.Arrays;
import java.util.Scanner;

public class UVa_11158 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nc = sc.nextInt();
        for(int x=0; x<nc; x++){
            int s = sc.nextInt();
            boolean isEven = true;
            if(s==1){
                System.out.println("0");
                continue;
            } // if list contains only one element
            int[] nums = new int[s];
            for(int i=0; i<nums.length; i++)
                nums[i] = sc.nextInt();
            Arrays.sort(nums);
            int temp = -99;
            int len = nums.length;
            if(nums.length%2==1){
                isEven = false;
                temp = nums[nums.length/2];
                for(int i=nums.length/2; i<nums.length-1; i++)
                    nums[i] = nums[i+1];
                len--;
            } // if odd, remove the middle element and then update the array
            int[] outArr = new int[len];
            int amount = 0;
            boolean flag = true;
            for(int i=1; i<=len; i++){ 
                if(i%2==0){
                    outArr[i-1] = nums[len-i/2]; 
                } // for manipulations on the upper half of the original array
                else{
                   if(flag){
                       outArr[i-1] = nums[len/2-amount-1];
                   } 
                   else{
                       outArr[i-1] = nums[amount];
                       amount++;
                   }
                   flag = !flag;
                }
            } // I used the flag to keep track of the bottom half of the array, 
			  // to alternate between starting at the front and starting at the end
			  
//            for(int i=0; i<outArr.length; i++)
//                System.out.print(outArr[i]+" ");
//            System.out.println("");
            int total = 0;
            for(int i=1; i<outArr.length; i++)
            total+=Math.abs(outArr[i]-outArr[i-1]); // sum up all absolute differences
            if(!isEven){
                total = Math.max(total+(Math.abs(temp-outArr[0])), total+(Math.abs(temp-outArr[outArr.length-1])));
            } // if odd, try adding the middle value to either the first or last element
            System.out.println("Case "+(x+1)+": "+total);
        }
    }
}
