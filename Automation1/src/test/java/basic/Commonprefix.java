package basic;

public class Commonprefix {

	public static String longestCommonPrefix (String[] strs)
	{
		if (strs.length == 1)
		{
	     	return strs [0];
		}
		
		int firstlen = strs[0].length();
		
		for (int prefixlen=0 ; prefixlen < firstlen ; prefixlen++)
		{
			char ch = strs[0].charAt(prefixlen);
			
			for (int i= 1 ; i < strs.length ; i++)
			{
				if (strs[i].length() <= prefixlen || ch != strs[i].charAt(prefixlen))
				{
					return strs[i].substring(0 , prefixlen);
				}
			}
		}
			
		return strs[0];

	}
	
	public static void main(String[] args) {
		
		String lcp = longestCommonPrefix (new String[] {"apple", "application", "appetite"});
		System.out.println(lcp);
		
		String lcp1 = longestCommonPrefix (new String[] {"car", "card", "cartoon"});
		System.out.println(lcp1);
		
		String lcp2 = longestCommonPrefix (new String[] {"java", "javascript", "javadoc"});
		System.out.println(lcp2);
		
		String lcp3 = longestCommonPrefix (new String[] {"ab", "abc", "abcd" , "abcdefg"});
		System.out.println(lcp3);
		
		String lcp4 = longestCommonPrefix (new String[] {"code", "coder", "coding", "codex"});
		System.out.println(lcp4);
		
		String lcp5 = longestCommonPrefix (new String[] {"hello", "hell", "he"});
		System.out.println(lcp5);
	}
}

