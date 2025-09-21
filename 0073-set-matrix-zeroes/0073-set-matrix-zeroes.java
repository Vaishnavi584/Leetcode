class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] rowZero = new boolean[matrix.length];
        boolean[] colZero = new boolean[matrix[0].length];
        for(int k=0;k<matrix.length;k++){
            for(int l =0;l<matrix[k].length;l++){
                if(matrix[k][l]==0){
                  rowZero[k]=true;
                  colZero[l]=true;  
                }
            }
        }
       for(int r = 0; r < matrix.length; r++){
            if(rowZero[r]){
                for(int j = 0; j < matrix[0].length; j++){
                    matrix[r][j] = 0;
                }
            }
        }
       for(int c = 0; c < matrix[0].length; c++){
            if(colZero[c]){
                for(int q = 0; q < matrix.length; q++){
                    matrix[q][c] = 0;
                }
            }
        } 
    }
       

}  
    
