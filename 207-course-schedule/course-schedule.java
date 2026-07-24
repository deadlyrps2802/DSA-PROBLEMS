class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for(int i = 0 ; i<numCourses; i++){
            arr.add(new ArrayList<Integer>());
        }

        for(int[] p : prerequisites){
            int u = p[0];
            int v =  p[1];
            arr.get(u).add(v);
        }
          
         for(int i = 0; i<numCourses; i++){
            for(int it: arr.get(i)){
                indegree[it]++;
            }
         }
        Queue<Integer> q = new LinkedList<>();
           for(int i =0 ; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
           }

           int count = 0;

           while(!q.isEmpty()){
            int node = q.poll();
            count++;

            for(int j : arr.get(node)){
                indegree[j]--;

                if(indegree[j] == 0) q.add(j);
            }
           }

           if(count == numCourses) return true;
           else return false;
    }
}