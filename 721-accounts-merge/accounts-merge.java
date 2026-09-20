class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<String,Integer> map = new HashMap<>();
        
        DisjointSet ds = new DisjointSet(n);

        for(int i = 0; i<n; i++){
            for(int j = 1; j<accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(map.containsKey(mail) == false){
                    map.put(mail,i);
                }
                else{
                    ds.UnionBySize(i,map.get(mail));
                }
            }
        }

        ArrayList<String>[] merge = new ArrayList[n];

        for(int i = 0; i <n; i++){
            merge[i] = new ArrayList<String>();
        }

        for(Map.Entry<String,Integer> it : map.entrySet()){
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            merge[node].add(mail);
        }

          List<List<String>> ans = new ArrayList<>();

          for(int i = 0; i<n; i++){
            if(merge[i].size() == 0) continue;
            Collections.sort(merge[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // adding name 

            for(String it : merge[i]){
                temp.add(it);
            }

            ans.add(temp);
          }
   
    
      return ans;
    }


}


class DisjointSet{
    int[] parent;
    int[] size;

    public DisjointSet(int n){
        parent = new int[n+1];
        size = new int[n+1];

        for(int i = 0; i<=n ; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUPar(int node){
        if(node == parent[node]) return node;

        return parent[node] = findUPar(parent[node]);
    }

    public void UnionBySize( int u , int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(size[ulp_u] < size[ulp_v]){
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];

        }
        else{
             parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}