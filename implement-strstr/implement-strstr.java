class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int n = needle.length(), hash = 0, mod = 100003;
        int pow = 1;
        //compute hash of needle
        for(int i = 0; i < needle.length(); i++){
            hash = (hash*26 + needle.charAt(i)) % mod;
            pow = (pow*26) % mod;
        }

        //Check hash of every window of size n in haystack
        int curr_hash = 0;
        for(int i = 0; i < haystack.length(); i++){
            curr_hash = (curr_hash*26 + haystack.charAt(i)) % mod;
            if(i + 1 < n) continue;
            if(i >= n){
                curr_hash = curr_hash - (pow*(haystack.charAt(i - n)))% mod;
                if(curr_hash < 0) curr_hash += mod;
            }
            if(curr_hash == hash){
                if(haystack.substring(i - n + 1, i+1).equals(needle)){
                   return i - n + 1;  
                }  
            }
        }
        
        return -1;
    }
}