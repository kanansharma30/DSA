class Solution {
    public int[] productExceptSelf(int[] nums) {
        //nums = [1,2,3,4]
        //ans = [24,12,8,6]
        // index 0 = 24
        //index 1 = 12
        // index 2 = 8
        // index 3 = 6
       // logic:
       //left product 
       //right product

       int n = nums.length;
       int [] ans = new int[n];
       int leftProduct = 1;
       for(int i =0; i<n; i++){
        ans[i] = leftProduct;
        leftProduct *=nums[i];
       }
       int rightProduct = 1;
       for(int i = n-1; i>=0; i--){
        ans[i] *= rightProduct;
        rightProduct *=nums[i];
       }
       return ans;
    }
}
