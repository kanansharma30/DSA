class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if(m>n){
            return res;
        }
        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        for(int i =0; i<m; i++){
            pCount[p.charAt(i)- 'a']++;
        }

        for(int i = 0; i<m; i++){
            windowCount[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(pCount, windowCount)){
            res.add(0);
        }
        for(int i =m; i<n; i++){
            char remove = s.charAt(i-m);
            windowCount[remove - 'a']--;
            char add = s.charAt(i);
            windowCount[add - 'a']++;
            if(Arrays.equals(pCount, windowCount)){
                res.add(i-m+1);
            }
        }
        return res;
    }
}
