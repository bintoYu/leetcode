package 图形;
import javafx.scene.layout.Border;

public class Word_Search_79
{
    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for(int y = 0; y < board.length; y++)
        {
        	for(int x = 0; x < board[0].length; x++)
        	{
        		if(search(board, word, y, x, 0,isVisited)) return true;
        	}
        }
        return false;
    }
    
    public boolean search(char[][] board,String word,int row,int column,int index,boolean[][] isVisited)
    {
    	//失败条件
    	if(row < 0 || row >= board.length 
    			|| column < 0 || column >= board[0].length 
    			|| isVisited[row][column] || board[row][column] != word.charAt(index))
    		return false;
    	
    	//成功条件
    	if(word.length() -1 == index)	return true;
    	
    	isVisited[row][column] = true;
    	
    	//移动：下，右，上，左
    	if(search(board, word, row+1, column, index+1,isVisited) ||
    		search(board, word, row, column+1, index+1, isVisited) ||
    		search(board, word, row-1, column,index+1, isVisited) ||
    		search(board, word, row, column-1, index+1, isVisited))
    	{
    		return true;
    	}
    	
    	isVisited[row][column] = false;
    	
    	return false;
    }
    
    public static void main(String[] args)
	{
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		boolean exist = new Word_Search_79().exist(board, word);
		System.out.println(exist);
	}
}
