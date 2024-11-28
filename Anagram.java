/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) 
		{
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		String tempStr1 = "";
		String tempStr2 = "";
		for (int i = 0; i < str1.length(); i++)
		{
			if (str1.charAt(i) != ' ')
			{
				tempStr1 += str1.charAt(i);
			}
		}
		for (int i = 0; i < str2.length(); i++)
		{
			if (str2.charAt(i) != ' ')
			{
				tempStr2 += str2.charAt(i);
			}
		}
		str1 = tempStr1;
		str2 = tempStr2;
		if (str1.length() != str2.length())
		{
			return false;
		}

		while (str1 != "")
		{
			char tempChar = str1.charAt(0);
			String tempStr = String.valueOf(tempChar);
			str1 = str1.replace(tempStr, "");
			str2 = str2.replace(tempStr, "");
			if (str1.length() != str2.length())
			{
				return false;
			}
		}
		return true;
	}
		

	public static String preProcess(String str) {
		String newString = str.toLowerCase();
		String finalString = "";
		for (int i = 0; i < newString.length(); i++) 
		{
			char c = newString.charAt(i);
			if (((c >= 'a') && (c <= 'z')) || (c == ' '))
			{
				finalString = finalString + c;
			}
		}
			return finalString;
	}
	
		
	public static String randomAnagram(String str) {
		str = preProcess(str); 
		String newSt = "";      
		int len = str.length(); 
	
		while (len > 0) 
		{
			int ran = (int)(Math.random() * len);
			newSt += str.charAt(ran);
			str = str.substring(0, ran) + str.substring(ran + 1);
			len--;
			}
	
			return newSt;
		}
}

