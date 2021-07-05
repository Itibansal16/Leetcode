class Solution {
    int[] dp; //Memoization
    private int helper(int[] arr, int d, int i){
        if(dp[i] != -1){
            return dp[i];
        }
        //Explore all the left indices, while left is smaller and in the bound of d we can make a jump to that node. Try all the possibilities
        int left = i-1;
        dp[i] = 1;
        while(i - left <= d && left >= 0 && arr[left] < arr[i]){
            dp[i] = Math.max(dp[i], 1 + helper(arr, d, left));
            left--;
        }
        //Similarly explore all the right indices
        int right = i+1;
        while(right - i <= d && right < arr.length && arr[right] < arr[i]){
            dp[i] = Math.max(dp[i], 1 + helper(arr, d, right)); 
            right++;
        }
        
        return dp[i];
    }
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        //It will store maximum jumps that can be made from any index
        dp = new int[n]; 
        int maxVisit = 0;
        Arrays.fill(dp, -1);
        for(int i = 0; i < n; i++){
            if(dp[i] == -1){
                dp[i] = helper(arr, d, i);
            }
        }
        for(int t : dp) maxVisit = Math.max(maxVisit, t);
        return maxVisit;
    }
}