// Online Java Compiler (Editor)
// Write and run Java online using this editor.
import java.util.*;
class Main {
    public static void main(String[] args) {
       // subarray sum equals to k
        // [1,2,3]
        // k =3
        // output = 2
        // always maintain orefix sum in such questions
        // we have to use hashmap to store the prefix sum
        // agar currrent prefeixSum hai toh sum-k pehle kinni baar aaya
        int[] arr={1,2,3};
        int k =3;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum =0;
        int count = 0;
        for(int num:arr){
            sum+=num;
            count+=map.getOrDefault(sum-k,0);
            map.put(sum, map.getOrDefault(sum,0)+1);
            
        }
        System.out.println("count: "+ count);
    }
}
