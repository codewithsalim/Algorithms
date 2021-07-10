/*
Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value. Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible. Return a list of ids of selected elements. If no pair is possible, return an empty list.

Example 1:

Input:
a = [[1, 2], [2, 4], [3, 6]]
b = [[1, 2]]
target = 7

Output: [[2, 1]]
*/

public List<int[]> findPairs(int[][] a, int[][] b, int target) {
        
    // a = [[1, 8], [3, 9 ], [2, 15]] <-- j
    // b = [[1, 8], [2, 11], [3, 12]] <-- i
        Arrays.sort(a, (int[] o1, int[] o2) -> o1[1] - o1[1]);
        Arrays.sort(b, (int[] o1, int[] o2) -> o1[1] - o1[1]);

        List<int[]> res = new ArrayList<>();
        int i = 0, j = a.length - 1;
        int max = 0;
        while (i < b.length && j >= 0) {
            if (a[j][1] + b[i][1] > target) {
                j--;
            } else {
                if (a[j][1] + b[i][1] > max) {
                    max = a[j][1] + b[i][1];
                    res.clear();
                    res.add(new int[]{a[j][0], b[i][0]});
                } else if (a[j][1] + b[i][1] == max) {
                    res.add(new int[]{a[j][0], b[i][0]});
                }
                i++;
            }
        }      
        return res;
    }
