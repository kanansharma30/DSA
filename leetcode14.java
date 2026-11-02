class Solution {
    public String longestCommonPrefix(String[] strs) {
        // first string taken as base case
        // transvere and compare it with other strings given (char by char)
        // if same, ++; else stop
        // now prefix is the common charcter
        // if empty then return ""

        String baseCase = strs[0];
        for(int i=0; i<strs.length; i++){
            int j = 0;

            while(j<baseCase.length() && j< strs[i].length() && baseCase.charAt(j) == strs[i].charAt(j)){
                j++;
            }

            baseCase = baseCase.substring(0,j);

            if(baseCase.length()==0){
                return "";
            }
        }
        return baseCase;
    }
}
