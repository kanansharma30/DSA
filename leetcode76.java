class Solution {
    public String minWindow(String s, String t) {
        // variable size sliding window//String s = "ADOBENCODEBANC"
        //String t = "ABC"
        //LOGIC?
        //WINDOW SIZE IS NOT FIXED HERE 
        // WE WILL USE TWO POINTERS HERE
        // Initially both pointers are at 0 index (this is rule for variable size sliding window)
        //right pointer ko aage badhao or new characters ko window mai include krte jao jabh tak saare required charcaters ni milte
        //check krenge validity ko(ki hai ya ni h)
        //we need smallest window so we need to shrink it from left side.
        //jabh substring mil gya tabh shrink krna hai coz hume dekhna hai ki min size kya hoga
        
        if(s.length()<t.length()){
            return "";
        }
        //we will keep 2 pointers now
        //left:window ki staring pe
        //right: ending point pe 
        //frequency count: int[128]
        
        int[] n = new int[128];
        int[] window = new int[128];
        for(int i =0; i<t.length(); i++){
            n[t.charAt(i)]++;
        }

        int req = 0;
        for(int i =0; i<128; i++){
            if(n[i]>0){
                req++;
            }
        }
        int formed = 0;
        int left = 0;
        int min = Integer.MAX_VALUE;
        int sI = 0;
        for(int right = 0; right<s.length(); right++){
            char c = s.charAt(right);
            window[c]++;
            if(n[c]>0 && window[c]==n[c]){
                formed++;
            }
            while(formed==req){
                int length= right - left + 1;
                if(length<min){
                    min = length;
                    sI = left;
                }
                char leftChar = s.charAt(left);
                window[leftChar]--;
                if(n[leftChar] >0 && window[leftChar]<n[leftChar]){
                    formed--;
                }
                left++;
            }
        }
        if(min == Integer.MAX_VALUE){
            return "";

        }
        return s.substring(sI, sI+min);
    }
}
