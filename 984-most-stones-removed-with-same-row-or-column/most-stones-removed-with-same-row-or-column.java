class Solution {
    public int removeStones(int[][] stones) {
      int n = stones.length;
       int maxr = 0; 
       int maxc = 0; 

       for(int i = 0; i<n; i++){
        maxr = Math.max(maxr, stones[i][0]);
        maxc = Math.max(maxc, stones[i][1]);
       }        

       DisjointSet ds = new DisjointSet(maxr + maxc + 2);
       HashMap<Integer, Integer> map = new HashMap<>();

       for(int i = 0; i<n; i++){
        int noderowno = stones[i][0];
        int nodecolno = stones[i][1] + maxr + 1;

        ds.UnionBysize(noderowno,nodecolno);

        map.put(noderowno , 1);
        map.put(nodecolno , 1);
       }

       int cnt = 0;
       for(Map.Entry<Integer,Integer> it : map.entrySet()){
            if( ds.findUPar(it.getKey()) == it.getKey()){
                cnt++;
            }
       }

       return n-cnt;
    }
}

class DisjointSet{
    int parent[] ;
    int size[];

    public DisjointSet(int n){
        parent= new int[n+1];
        size = new int[n+1];

        for(int i = 0; i<=n; i++){
            parent[i] = i;
            size[i] = 1;

        }
    }

    public int findUPar(int node){
        if(parent[node] == node) return node;
        return parent[node] = findUPar(parent[node]);
    }

    public void UnionBysize(int u , int v){
          int ulp_u = findUPar(u);
          int ulp_v = findUPar(v);

          if(ulp_u == ulp_v) return;
          else if(size[ulp_u] > size [ulp_v]){
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
            
          }
          else{
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
          }
    }
}