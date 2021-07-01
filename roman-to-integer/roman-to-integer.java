class Solution {
    private int mapToInteger(char c){
        switch(c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;    
        }
        return -1;
    }
    public int romanToInt(String s) {
        int ans = 0, i = 0;
        while(i < s.length()-1){
            int c1 = mapToInteger(s.charAt(i));
            int c2 = mapToInteger(s.charAt(i+1));
            if(c1 >= c2){
                ans += c1;
                i++;
            }
            else{
                ans += c2 - c1;
                i += 2;
            }
        }
        if(i == s.length() - 1){
            ans += mapToInteger(s.charAt(i));
        }
        return ans;
    }
}