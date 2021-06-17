class Solution {
    public boolean dfs(int node,int parent,boolean vis[],HashMap<Integer,List<Integer>> m){
        vis[node]=true;
        for(Integer j:m.get(node)){
            if(vis[j]==false){
                if(dfs(j,node,vis,m)){return true;}
            }
            else if(j!=parent){
                return true;
            }
        }
        return false;
        
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        boolean[] vis=new boolean[n+1];
        int[] res=new int[2];      
        HashMap<Integer,List<Integer>> m=new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
            int f = edges[i][0];
            int s = edges[i][1];
            if(m.containsKey(f)&&m.containsKey(s)){
                m.get(f).add(s);
                m.get(s).add(f);}
            else if(m.containsKey(f)&&!m.containsKey(s)){
                m.get(f).add(s);
                m.put(s,new ArrayList<>(){{
                    add(f);
                }});
            }
            else if(!m.containsKey(f)&&m.containsKey(s)){
                m.get(s).add(f);
                m.put(f,new ArrayList<>(){{
                    add(s);
                }});
            }
            else{
                 m.put(f,new ArrayList<>(){{
                    add(s);
                }});
                 m.put(s,new ArrayList<>(){{
                    add(f);
                }});
                
            }
            if(dfs(f,-1,vis,m))        
            {
              res[0]=f;
                res[1]=s;
                return res;
            }
            Arrays.fill(vis,false);
        }
        
        return res;
    }
}