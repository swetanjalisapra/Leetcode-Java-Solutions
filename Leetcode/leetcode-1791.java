class Solution {
    public int findCenter(int[][] edges) {
        int x=edges[0][0];
        int y=edges[0][1];
        int w=edges[1][0];
        int z=edges[1][1];
        if(x==w||x==z){
            return x;
        }
        else{
            return y;
        }
    }
}