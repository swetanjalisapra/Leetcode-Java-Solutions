class Solution {
    void helper(char[][] grid,int x,int y,int r,int c){
        if(x<0||x>=r||y<0||y>=c||grid[x][y]!='1'){
            return;
        }
        grid[x][y]='2';
        helper(grid,x+1,y,r,c);
        helper(grid,x,y+1,r,c);
        helper(grid,x-1,y,r,c);
        helper(grid,x,y-1,r,c);  
    }
    public int numIslands(char[][] grid) {
        int ans=0;
        int rows=grid.length;
        int columns=grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j]=='1'){
                   ans++;
                    helper(grid,i,j,rows,columns);
                }
            }
        }
        return ans;
    }
}