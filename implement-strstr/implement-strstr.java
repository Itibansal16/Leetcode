class Solution {
    private void fillLPS(int[] lps, String pattern){
        lps[0] = 0;
        int j = 0, i = 1;
        while(i < pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            }
            else{
                if(j != 0) j = lps[j-1];
                else i++;
            }
        }
    }
    public int strStr(String text, String pattern) {
        int m = text.length(), n = pattern.length();
        if(n == 0) return 0;
        
        int[] lps = new int[n];
        fillLPS(lps, pattern);
        
        //KMP
        int i = 0, j = 0;
        while(i < text.length() && j < pattern.length()){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            else{
                if(j == 0) i++;
                else j = lps[j-1];
            }
        }
        if(j != pattern.length()) return -1;
        return i - pattern.length();
    }
}