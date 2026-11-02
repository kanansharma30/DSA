class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        // in normal arrays like nums = [5,-3,5]
        // [5]
        // but for circular we get [5,5] as our output subarray

    int totalSum = 0;
    int currentMax = 0;
    int maxSum = Integer.MIN_VALUE;
    int currentMin = 0;
    int minSum= Integer.MAX_VALUE;
    for(int num:nums){
        currentMax=Math.max(num, currentMax+num);
        maxSum=Math.max(maxSum,currentMax);
        currentMin=Math.min(num,currentMin+num);
        minSum=Math.min(minSum,currentMin);
        totalSum+=num;
        }
        if(maxSum<0){
        return maxSum;
    }
    int circularSum = totalSum - minSum;
    return Math.max(maxSum,circularSum);
}
}
