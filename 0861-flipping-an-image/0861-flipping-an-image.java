
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] result=new int[image.length][image.length];
        for(int i=0;i<image.length;i++){
            int start=0;
            int end=image[i].length-1;
            for(int j=0;j<image[i].length;j++){
                while(start<end){
                swap(image[i],start,end);
                start++;
                end--;
                }
            }
        }
        for(int k=0;k<image.length;k++ ){
            for(int l=0;l<image[k].length;l++){
                result[k][l]=image[k][l]^1;
                
            }
             
        
            
        }
        return result;

        
    }
    static void swap(int[]arr,int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}