/**
 * 
 */

/**
 * @author ybt
 *
 * @date 2018年9月6日  
 * @version 1.0  
 */
public class Palindrome_Number_9
{
    public boolean isPalindrome(int x) {
        if(x< 0)
        	return false;
        else if(x <10)
        	return true;
        boolean result = true;
        int i = 0;
        String tmp = x + "";
        char[] charArray = tmp.toCharArray();
        int j = tmp.length() - 1;
        while(i < j)
        {
        	if(charArray[i] != charArray[j])
        		result = false;
        	i++;j--;
        }
        
        return result;
    }
    
    public static void main(String[] args)
	{
		boolean palindrome = new Palindrome_Number_9().isPalindrome(121);
		System.out.println(palindrome);
	}
}
