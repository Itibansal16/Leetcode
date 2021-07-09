class Solution {
    private int count(int[] nums, int sum){
        //sliding window
        int start = 0, end = 0, ans = 0;
        int currSum = 0;
        while(end < nums.length){
            currSum += nums[end];
            while(start <= end && currSum > sum){
                currSum -= nums[start++];
            }
            ans = ans + (end - start + 1);//add all subarrays ending at 'end'
            end++;
        }
        return ans;
    }
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int left = 1, right = Arrays.stream(nums).sum(), ans = 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            //Find the number of subarrays which has sum less than mid
            int count = count(nums, mid);
            if(count >= k){
               right = mid;
            } 
            else left = mid + 1;
        }
        return left;
    }
}