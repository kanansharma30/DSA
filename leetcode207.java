class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // course hai 0,1,2,3
        // prerequisites= [[1,0], [2,1], [3,2]]
        // [1,0] = 0 then 1 
        //[2,1] = 1 then 2
        // [3,2] = 2 then 3

        // cycle detection
        // prerequisites
        // agar cyclic graph mai cycle hai toh hum first ocurse kabhi kr hi ni paayenge

        //Kahn's Algorithm:
        // 1) Adjancency list:to represent graph
        //2) indegree array: ahr node to incoming edges ka count lene ko
        // 3)queue:


        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0; i< numCourses; i++){
            graph.add(new ArrayList<>());

        }
        int[] indegree = new int[numCourses];
        for(int[] p: prerequisites){
            int course = p[0];
            int pre = p[1];
            graph.get(pre).add(course);
            indegree[course]++;

        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<numCourses; i++){
            if(indegree [i] ==0){
                q.offer(i);
            }
        }
        int comp =0;
        while(!q.isEmpty()){
            int curr = q.poll();
            comp++;
            for(int neigh: graph.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.offer(neigh);
                }
            }
        }
        return comp == numCourses;
    }
}
