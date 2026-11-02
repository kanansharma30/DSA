class Solution {
    public boolean isAnagram(String s, String t) {
        
        //best way is maps but we can do it with strings too
        //in anagram the frequency of characters is same

        // create array : int[26] as we have 26 charcters
        // a = index 0
        // b = index 1
        //...
        // z = index 25

        if(s.length () != t.length()){
            return false;
        }
        int[] count = new int[26];
        for(int i =0; i<s.length(); i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;

        }
        for(int i = 0; i<26; i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
}
