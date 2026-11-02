class Solution {
    private String [] mapping = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0){
        return res;
        }
        backtrack(digits, 0 , new StringBuilder(), res);
        return res;
    }
    private void backtrack(String digits, int index, StringBuilder current, List<String> res){
        if(index == digits.length()){
            res.add(current.toString());
            return;
        }
        String letters = mapping[digits.charAt(index)-'0'];
        for(int i = 0; i< letters.length(); i++){
            current.append(letters.charAt(i));
            backtrack(digits, index+1, current, res);
            current.deleteCharAt(current.length()-1);
        }
    }
}
// 2 = abc
// input = "23"
// digit 2 ke liye 3 choice a,b,c hai
// digit 3 ki choice d e f hai
// and so on...
//["ad", "ae", "af", "bd", "be","bf", "cd", "ce","cf"];
// total combinations: 3*3 =9

//logic:
//create backtrack(index, current) named function 
// index: abhi konsa digit process kr rhe hai
// current: abh tak humne konsa combination banaya h
// if index == digit.length(): means combination complete hai and add it to answer
//current digit ke saare possible letters uspe loop chalana hai
// and add every letter to current
// next digit recursive call


// dry run of code:
// input digits = "23"
// index = 0, current""
// index =1, current = "a"
// a+d = ad
// a+e = ae
// a+f = af
