class Solution {
  //finds the length of longest substring with unique characters using Sliding Window algorithm
   public int lengthOfLongestSubstring(String s) {
       if (s == null || s.length() == 0 ) return 0;
       
       int i = 0, j = 0, max = 0;
       HashSet<Character> set = new HashSet<>();
       
       while (i < s.length()){
            char ch = s.charAt(i);
            if (!set.contains(ch)){
                set.add(ch);
                i++;
                max = Math.max(set.size(), max);
            }
            else {
                set.remove(s.charAt(j));
                j++;
            }
        }
        return max;
   }
}
