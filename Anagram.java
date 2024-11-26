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
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
			// Preprocess both strings
			str1 = preProcess(str1);
			str2 = preProcess(str2);
	
			if (str1.isEmpty() && str2.isEmpty()) {
				return true;
			}

			// If the lengths are different, they can't be anagrams
			if (str1.length() != str2.length()) {
				return false;
			}
	
			// Check if each character in str1 exists in str2 with the same count
			for (int i = 0; i < str1.length(); i++) {
				char currentChar = str1.charAt(i);
				int countInStr1 = occurrences(str1, currentChar);
				int countInStr2 = occurrences(str2, currentChar);
	
				if (countInStr1 != countInStr2) {
					return false;  // If counts don't match, not an anagram
				}
			}
	
			return true;  // All characters match in both strings
		}	

		public static int occurrences(String str, char c) {
			int count = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == c) {
					count++;
				}
			}
			return count;
		}

		public static String preProcess(String str) {
			String newString = str.toLowerCase();
			String finalString = "";
			for (int i = 0; i < newString.length(); i++) {
				char c = newString.charAt(i);
				if (((c >= 'a') && (c <= 'z')) || (c == ' ')) {
					finalString = finalString + c;
				}
			}
			return finalString;
		}
	
		// Returns a random anagram of the given string. The random anagram consists of the same
		// characters as the given string, re-arranged in a random order.
		public static String randomAnagram(String str) {
			str = preProcess(str); // Preprocess the string first
			String newSt = "";      // This will hold the new string (anagram)
			int len = str.length(); // Get the length of the processed string
	
			while (len > 0) {
				// Generate a random index between 0 and len - 1
				int ran = (int)(Math.random() * len);
	
				// Add the character at the random index to newSt
				newSt += str.charAt(ran);
	
				// Remove the character from the original string
				str = str.substring(0, ran) + str.substring(ran + 1);
	
				// Decrease the length of the string after removing one character
				len--;
			}
	
			return newSt;
		}
}

