// Online Java Compiler (Editor)
// Write and run Java online using this editor.

class Main {
    public static void main(String[] args) {
        // System.out.println("Try clicking the Run button.");
        // maximum continuous sum subarray
        //arr =[2,1,5,1,3,2]
        //k=3
        int[]arr ={2,1,5,1,3,2};
        int k =3;
        if(k<=0|| k>arr.length){
            System.out.println("Invalid k");
            return;
        }
        int windowSum=0;
        for(int i = 0; i<k; i++){
            windowSum +=arr[i];
        }
        int maxSum = windowSum;
        for(int i =k; i<arr.length;i++){
            windowSum += arr[i];
            windowSum-=arr[i-k];
            maxSum = Math.max(maxSum, windowSum);
        }
        System.out.println("maximum sum: "+ maxSum);
        
    }
}
