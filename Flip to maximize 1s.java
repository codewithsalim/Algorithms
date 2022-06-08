/*
You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.
You aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.
*/
class Solution {
    public static void main(String[] args) {
        int[] result = getFlipRange("010");
        for(int elem: result)
            System.out.println(elem+" ");
    }
    
    public static int[] getFlipRange(String str) {
        if (str.length() == 0) return new int[]{};   
        boolean containsZero = false;
        int gain[] = new int[str.length()];
        //gain is 1 for 0, and -1 for 0
        for (int i = 0; i< str.length(); i++) {   
            char ch = str.charAt(i); 
            gain[i] = ( ch == '0') ? 1 : -1;
            if (str.charAt(i) == '0') {
                   containsZero = true; 
            }
        }
        
        if(!containsZero)
            return new int[]{};  
            
        int maxL = 0;
        int maxR = str.length() - 1;
        int maxSum = 0;
        
        int curSum = 0;
        int currL = 0;
        int currR = 0;
        //Kadane's algorithm
        for (int i =  0; i < gain.length; i++) {
            if (curSum + gain[i] >= 0) {
                curSum += gain[i];
                currR = i;
            }else {
                curSum = 0; 
                currL = i + 1;
            }
            
            if (curSum > maxSum) {
                maxSum = curSum; 
                maxL = currL;
                maxR = currR;
            }         
        }
        return new int[]{maxL + 1, maxR + 1};
    }
}
