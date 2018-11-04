package 图形;

public class Number_of_Islands_200
{
	/**
	 * 从起点开始遍历，遇到一个岛屿的条件就是：“遇到值为1并且没有访问过”。
	 * 遇到后，递归把该岛屿的所有点全部访问并标记，这就算遇到了一个岛屿。
	 * 遍历完毕即可。
	 * @param grid
	 * @return
	 */
    public int numIslands(char[][] grid) {
    	if(grid==null || grid.length==0 || grid[0].length==0) return 0;
    	
    	int res = 0;
    	int[][] visited = new int[grid.length][grid[0].length];
    	//遍历
    	for(int i = 0; i < grid.length; i++)
    	{
    		for(int j = 0; j < grid[0].length; j++)
    		{
    			//遇到一个岛屿的条件
    			if(grid[i][j] == '1' && visited[i][j] ==0)
    			{
    				numIslandsDFS(grid, visited, i, j);
    				res++;
    			}
    		}
    	}
    	return res;
    }
    
    private void numIslandsDFS(char[][] grid,int[][] visited,int x,int y)
    {
    	//不是陆地的都直接返回
    	if(x<0 || x>grid.length-1) return;
    	if(y<0 || y>grid[0].length-1) return;
    	if(grid[x][y]=='0' || visited[x][y]==1) return;
    	
    	visited[x][y] = 1;
    	numIslandsDFS(grid, visited, x-1, y);
    	numIslandsDFS(grid, visited, x, y+1);
    	numIslandsDFS(grid, visited, x+1, y);
    	numIslandsDFS(grid, visited, x, y-1);
    }
    
    public static void main(String[] args)
	{
//    	char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
    	char[][] grid ={{'1'},{'1'}};
    	int numIslands = new Number_of_Islands_200().numIslands(grid);
    	System.out.println(numIslands);
	}
}
