class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // + num moves in right direction
        // - ve in left dir
        // absolute value of number tells the size
        // if two asteroid collide, smaller will explode
        // if size same then both destroy on collision
        // asteroid moving in same direction will never collide
        // asteroids = [5,10,-5]
        // 5, 10 move in right direction
        // -5 moves in left

        //logic: stack
        // in stack: hum woh asteroid rakhenge jo survie kr rhe hai
        // fir for each asteroid we check, ki agar wo +ve hai toh hum usse stack mai push kr denge
        // agar woh negative hai, so check ki stack ke top pe +ve hai ya ni hai 
        // if both in opposite so they will collide
        // chota aestroid destroy krenge
        // agar -ve aestroid 

        Stack <Integer> st = new Stack<>();
        for (int a : asteroids) {
            boolean alive = true;

            while (alive&& a< 0 && !st.isEmpty() && st.peek() > 0) {
                if (st.peek()< -a) {
                    st.pop();
                } else if (st.peek()== -a) {
                    st.pop();
                    alive = false;
                } else {
                    alive = false;
                }
            }
            if (alive) {
                st.push(a);
            }
        }
        int[] result = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            result[i] = st.get(i);
        }
        return result;
    }
}
