//Reverse whole array
//reverse each word one by one
class Solution {
    private void reverse(char[] arr, int i, int j){
        while(i < j){
           char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--; 
        }
    }
    public void reverseWords(char[] s) {
        //Reverse the array
        reverse(s, 0, s.length-1);
        
        //Reverse each word
        int start = 0, end = 0;
        while(end < s.length){
            if(s[end] == ' '){
                reverse(s, start, end - 1);
                start = end + 1;
            }
            if(end == s.length-1){
                reverse(s, start, end);
            }
            end++;
        }
    }
}