import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Sum 0 exists before starting
        map.put(0, -1);

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            
            // Convert 0 to -1
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            // Same sum found -> equal 0s and 1s
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } 
            else {
                // Store first occurrence only
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}