/**
 * Day 4 - Move Zeroes
 * 
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 * 
 * Example: Input: [0,1,0,3,12], Output: [1,3,12,0,0]
 * 
 * Note: do in-place without making a copy of the array. Minimize the total number of operations.
 * 
 * Tip: Two pointers
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 1;
       while(i<nums.length && j<nums.length){
           if(nums[i] == 0 && nums[j] != 0){
               nums[i] = nums[j];
               nums[j] = 0;
               i++;
               j++;
           }else if(nums[i] == 0 && nums[j] == 0){
               j++;
           }else if(nums[i] != 0){
               i++;
               j++;
           }
       }
    }
}