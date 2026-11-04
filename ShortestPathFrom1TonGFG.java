class Solution {
    public int minimumStep(int n) {
        // code here
        int steps =0;
                while(n>1){
                    if(n%3 == 0){
                        n=n/3;
                    }else{
                        n=n-1;
                    }
                    steps++;
                }
                return steps;
            }
        }
        
        // dry run
        // n = 4
        // n%3 != 0
        // so n = n-1 = 3
        // steps =1,
        
        // n=3
        // n% 3 ==0
        // so n/3 =1
        // step =2
        
        // n=1 loop terminates
        
        
