package 自己构造类;

import sun.net.www.content.image.png;

public class Trie
{
	private TrieNode root;
	
    /** Initialize your data structure here. */
    public Trie() {
    	root = new TrieNode();
    }
    
    /**
     * 插入：
     * 依次向下遍历,没有就插入
     * @param word
     */
    public void insert(String word) {
    	char[] chars = word.toCharArray();
    	TrieNode pNode = root;
    	for (char c : chars)
		{
    		int num = c - 'a';
			if(pNode.son[num] == null)
			{
				pNode.son[num] = new TrieNode();
			}

			pNode = pNode.son[num];
		}
    	pNode.isWord = true;
    }
    
    /**
     * 查找：
     * 依次向下遍历,直到最底，查看
     * @param word
     */
    public boolean search(String word) {
    	char[] chars = word.toCharArray();
    	TrieNode pNode = root;
    	for (char c : chars)
		{
    		int num = c - 'a';
    		if(pNode.son[num] == null)
    		{
    			return false;
    		}
    		
    		pNode = pNode.son[num];
		}
    	return pNode.isWord;
    }
    
    /**
     * 查找前缀：
     * 和查找一样，只是不需要看pNode.isWord，只要能遍历完，就是true
     * @param word
     */
    public boolean startsWith(String prefix) {
    	char[] chars = prefix.toCharArray();
    	TrieNode pNode = root;
    	for (char c : chars)
		{
    		int num = c - 'a';
    		if(pNode.son[num] == null)
    		{
    			return false;
    		}
    		
    		pNode = pNode.son[num];
		}
    	return true;
    }
    
    public static void main(String[] args)
	{
    	Trie obj = new Trie();
    	obj.insert("apple");
    	System.out.println(obj.search("apple"));
    	System.out.println(obj.search("app"));
    	System.out.println(obj.startsWith("app"));
    	obj.insert("app");
    	System.out.println(obj.search("app"));
	}
}

class TrieNode
{
	public TrieNode[] son;
	public boolean isWord;
	
	public TrieNode()
	{
		son = new TrieNode[26];
		isWord = false;
	}
}