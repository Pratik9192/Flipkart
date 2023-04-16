package basic;

public class Toremovespace {

	public static void main(String[] args) {
		
		
		
		String s = "hello\t world\n";
		String ch = s.replace("a-z", "");
		String p = ch.replaceAll("\\s", "");
		System.out.println(p);
		
		
		
		String str = "This is a test";
		String result [] = str.split(" ");
		for (int i = 0 ; i < result.length; i++)
		{
			System.out.print(result[i]);
		}
		System.out.println();
//		OR
//		String str1 = str.replaceAll("\\s", "");
//		System.out.println(str1);
		
		
		String m = " The quick brown fox jumps over the lazy dog ";
		String s1 = m.replaceAll("\\s", "");
		System.out.println(s1);
		
		
	}
}
