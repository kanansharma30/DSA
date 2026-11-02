class Solution {
    public boolean isPalindrome(String s) {
        
        //isLetterOrDigit checks ki woh letter or digit hai ya nhi 
        //jese agar space hai ya comma ya kuch ahi toh woh leftt++ ya right__ kr skte hai apne according
        
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left))!= Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
