//Find the transpose of the matrix and then reverse all the rows
class Solution {
    private void transpose(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    private void reverseRows(int[][] matrix){
        for(int[] rows : matrix){
            int left = 0, right = rows.length-1;
            while(left < right){
                int temp = rows[left];
                rows[left] = rows[right];
                rows[right] = temp;
                left++; right--;
            }
        }
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);
    }
}