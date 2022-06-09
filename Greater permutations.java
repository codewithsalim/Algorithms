import java.util.*;
class Solution{

    static void printPermutation(int N){
    	int temp = N, count = 0;
    	while (temp > 0){
        	count++;
        	temp /= 10;
    	}
    	int[] num = new int[count];
    	
    	while (N > 0){
        	num[count-- - 1] = N % 10;
        	N = N / 10;
    	}
    	while (nextPermutation(num)){
    	// Print the current permutation of N
        	for (int i = 0; i < num.length; i++)
        		System.out.print(num[i]);
        	System.out.print("\n");
    	}
    }

    public static boolean nextPermutation(int[] nums) {    
        int i = nums.length - 2;
        while ( i >= 0  && nums[i] >= nums[i+1] ){
            i--;
        }
        int j = nums.length -1;
        if ( i >= 0 ){
            while ( j >= 0 && nums[j] <= nums[i]  ){
                j--;
            }
            swap(nums, i, j);
            reverse(nums, i+1); 
            return true;
        }else{
            return false;
        }
        
    }
    
    static void  reverse (int nums[], int start){
        int end =  nums.length -1;
        while (start<end){
            swap(nums,start, end);
            start++;
            end--;
        }
    }
    
    static void  swap ( int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args){
        int N = 213;
        printPermutation(N);
    }
}

