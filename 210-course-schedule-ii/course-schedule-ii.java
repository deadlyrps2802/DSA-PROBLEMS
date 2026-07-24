class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for(int i = 0 ; i<numCourses; i++){
            arr.add(new ArrayList<Integer>());
        }

        for(int[] p : prerequisites){
            int u = p[1];
            int v =  p[0];
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
            
        int[] ans = new int[numCourses];
        int index = 0;
           int count = 0;

           while(!q.isEmpty()){
            int node = q.poll();
            ans[index++] = node;
            count++;

            for(int j : arr.get(node)){
                indegree[j]--;

                if(indegree[j] == 0) q.add(j);
            }
           }

           if(count == numCourses) return ans;
           else return new int[0];
    }
}
 