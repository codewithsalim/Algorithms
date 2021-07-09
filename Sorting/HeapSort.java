class Solution {
    public int[] swap (int[] nums, int a, int b){
        int temp;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        
        return nums;
    }
    
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int temp;
        //build max heap
        for (int i = (n/2-1); i>=0; i-- ){
            heapify(nums, n, i);
        }
        
        for (int i = n-1; i>0; i--){
            nums = swap(nums, i, 0);
            heapify(nums, i, 0);
        }
        
        return nums;
    }
    
    public void heapify(int[] nums, int n, int i){
        int temp;
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        
        if (left < n && nums[left] > nums[largest]){
            largest = left;
        }
        if (right < n && nums[right] > nums[largest]){
            largest = right;
        }
        if (largest != i){
            nums = swap(nums, i, largest);
            heapify(nums, n, largest);
        }
        
    }
}
