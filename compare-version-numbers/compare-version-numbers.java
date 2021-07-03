class Solution {
    public int compareVersion(String version1, String version2) {
        String[] c1 = version1.split("\\.");
        String[] c2 = version2.split("\\.");
        int i = 0, j = 0;
        while(i < c1.length || j < c2.length){
            int val1 = i >= c1.length ? 0 : Integer.valueOf(c1[i]);
            int val2 = j >= c2.length ? 0 : Integer.valueOf(c2[j]);
            //System.out.println(val1 + " " + val2);
            if(val1 < val2) return -1;
            if(val1 > val2) return 1;
            i++;
            j++;
        }
        return 0;
    }
}