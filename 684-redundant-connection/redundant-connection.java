class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);

        ArrayList<Integer> arr = new ArrayList<>();
             
        for(int i = 0; i<n; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(ds.findUPar(u)!= ds.findUPar(v)){
                ds.UnionBySize(u,v);
            }
            else{
            arr.add(u);
            arr.add(v);
            }
        }  

        int[] result = new int[2];
        result[0] = arr.get(arr.size()-2);
        result[1] = arr.get(arr.size()-1);

        return result; 
    }
}

class DisjointSet{
    int[] parent;
    int[] size;


    public DisjointSet(int n){
        parent = new int[n+1];
        size = new int[n+1];

        for(int i = 0; i<=n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }


    public int findUPar(int node){
        if( node == parent[node] ) return node;
        return parent[node] = findUPar(parent[node]);
    }

    public void UnionBySize(int u , int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;

        if(size[ulp_u] > size[ulp_v]){
            size[ulp_u] += size[ulp_v];
            parent[ulp_v] = ulp_u;
        }
        
        else{
            
            size[ulp_v] += size[ulp_u];
            parent[ulp_u] = ulp_v;
        } 
        
    }
}