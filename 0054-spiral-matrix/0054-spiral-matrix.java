class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int length= matrix.length * matrix[0].length;
        int top=0;
        int bottom = matrix.length-1;
        int left=0;
        int right =matrix[0].length-1;
        while(list.size()<length){

            for(int h= left; h<=right && list.size()<length;h++){
                list.add(matrix[top][h]);
            }
            top++;
            for(int i =top ; i <= bottom && list.size()<length; i++){
                list.add(matrix[i][right]);
            }
            right--;
            for(int j=right;j>=left && list.size()<length;j--){
                list.add(matrix[bottom][j]);
            }
            bottom--;
            for(int k=bottom;k>=top && list.size()<length;k--){
                list.add(matrix[k][left]);
            }
             left++;

        }
        return list;
    }
}