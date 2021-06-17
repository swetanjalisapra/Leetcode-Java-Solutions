class Solution {
    public boolean dfsCheck(int[][] graph,int node,int[] color){
        if(color[node]==-1){
            color[node]=1;
        }
       for(int j=0;j<graph[node].length;j++){
           int k=graph[node][j];
           if(color[k]==-1){
               color[k]=1-color[node];
               if(!dfsCheck(graph,k,color)){
                   return false;
               }}
               else if(color[k]==color[node]){
                   return false;
               }
           }
       
        return true;
        
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n];
        for(int i=0;i<n;i++){
            color[i]=-1;
        }
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!dfsCheck(graph,i,color)){
                    return false;
                }
            }
        }
        return true;
    }
}