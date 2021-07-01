/*APPROACH: We can decide the character to be placed according to the position.
  Ex: 123 -> CXXIII
      1423 -> MCDXXIII
      at ones place, roman numeral for 3 is same in both and for 2 at tens place.
*/
class Solution {
    public String intToRoman(int num) {
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"", "M", "MM", "MMM"};//As per constraints
        int place = 1;
        String ans = "";
        while(num > 0){
           int rem = num % 10;
           num /= 10;
           if(place == 1){
               ans = ones[rem] + ans;
               place = 10;
           } 
            else if(place == 10){
                ans = tens[rem] + ans;
                place = 100;
            }
            else if(place == 100){
                ans = hundreds[rem] + ans;
                place = 1000;
            }
            else{
                ans = thousands[rem] + ans;
            }
        }
        return ans;
    }
}