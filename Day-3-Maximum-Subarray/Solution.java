/**
 * Day 3 - Maximum Subarray
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * 
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 *  which is more subtle.
 * 
 * Example: Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * Tip: Divide and conquer
 */

class Solution { 
    private int maxCrossing(int[] nums, int start, int end, int mid){
        int sum = 0;
        int lsum = Integer.MIN_VALUE;
        for(int i = mid; i >= start; i--) { 
            sum += nums[i]; 
            if (sum > lsum) lsum = sum; 
        } 
        sum = 0; 
        int rsum = Integer.MIN_VALUE; 
        for(int i = mid + 1; i <= end; i++){ 
            sum += nums[i]; 
            if (sum > rsum) rsum = sum; 
        } 
        return lsum + rsum; 
    }
    
    private int maxSubArraySum(int[] nums, int start, int end) {
        if(start == end) return nums[start];
        int mid = (start + end) / 2;
        return Math.max(
            Math.max(maxSubArraySum(nums, start, mid), 
                     maxSubArraySum(nums, mid+1, end)), 
            maxCrossing(nums, start, end, mid));
    }
    
    public int maxSubArray(int[] nums) {
        return maxSubArraySum(nums, 0, nums.length-1);
    }
}