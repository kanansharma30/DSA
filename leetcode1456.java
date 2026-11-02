class Solution {
    public int maxVowels(String s, int k) {
        // s = "abciiidef", k =3
        // use sliding window only

        //"abc", 1 vowel
        //"bci", 1 vowel
        //"cii", 2 vowel
        //"iii", 3 
        //"iid", 2
        //"ide", 2
        //"def", 1

        int count = 0;
        int max = 0;
        for(int i = 0; i<k; i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
        max = count;

        for(int i =k; i<s.length(); i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
            if(isVowel(s.charAt(i-k))){
                count--;
            }
            max= Math.max(max,count);
        }
        return max;
    }
    private boolean isVowel(char ch){
        return ch == 'a' ||
        ch =='i'||
        ch =='o' ||
        ch == 'e' ||
        ch == 'u';
    }
}
