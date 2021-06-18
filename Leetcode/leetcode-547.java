class Solution {
     void helper(int node, boolean[] vis, int[][] isConnected, int size)
    {
        if(vis[node]==false){
                vis[node] = true;
            }
        for(int i =0;i<size;i++){
            if((isConnected[node][i] == 1) && !(vis[i])){
                    helper(i,vis, isConnected, size);
                }
            
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int ans=0;
        int n=isConnected.length;
         boolean[] vis=new boolean[n+1];
        for(int i=0;i<n;i++){
            if(vis[i] == false){
                ans++;
                helper(i,vis,isConnected, n);
            }
        }
        return ans;
    }
}