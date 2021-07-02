//Not efficient
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        if(n <= 1) return -1;
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int[] prefixSum = new int[n]; 
        Arrays.fill(prefixSum, n+1);
        int currSum = arr[0];
        map.put(currSum, 0);
        if(arr[0] == target) prefixSum[0] = 1;
        for(int i = 1; i < arr.length; i++){
           currSum += arr[i];
            if(map.containsKey(currSum - target)){
                prefixSum[i] = Math.min(prefixSum[i-1], i - map.get(currSum - target));
            }
            else prefixSum[i] = prefixSum[i-1];
            map.put(currSum, i);
        } 
        int[] suffixSum = new int[n]; 
        Arrays.fill(suffixSum, n+1);
        currSum = arr[n-1]; map.clear();
        map.put(0, n);
        map.put(currSum, n-1);
        if(arr[n-1] == target) suffixSum[n-1] = 1;
        for(int i = n-2; i >= 0; i--){
           currSum += arr[i];
            if(map.containsKey(currSum - target)){
                suffixSum[i] = Math.min(suffixSum[i+1], map.get(currSum - target) - i);
            }
            else suffixSum[i] = suffixSum[i+1];
            map.put(currSum, i);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n-1; i++){
            min = Math.min(min, prefixSum[i-1] + suffixSum[i]);
            min = Math.min(min, prefixSum[i] + suffixSum[i+1]);
        }
        return min >= n+1 ? -1 : min;
    }
}