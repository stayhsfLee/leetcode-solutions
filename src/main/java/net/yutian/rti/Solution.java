package main.java.RomanToInteger;

public class Solution {

	char[] romans = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};

	public int romanToInt(String s) {

		int classLevel = 0;
		int result = 0;
		s = new StringBuilder(s).reverse().toString();

		while (s.length() > 0) {
			if(classLevel > romans.length - 2){
				if(romans.length / 2 == 1){
					int end=0;
					char[] cs = s.toCharArray();
					while(s.length()> end){
						if(cs[end] == romans[classLevel]){
							result += Math.pow(10, classLevel);
							end++;
						}
					}
					s = s.substring(end);
				}else {
					int end=0;
					char[] cs = s.toCharArray();
					while(s.length()> end){
						if(cs[end] == romans[classLevel]){
							result += Math.pow(10, classLevel/2);
							end++;
						}else if(cs[end] == romans[classLevel + 1]){
							result += Math.pow(10, classLevel/2) * 5;
							end++;
						}else {
							break;
						}
					}
					s = s.substring(end);
				}
			}
			if (s.length() >= 2 && s
				.startsWith(romans[classLevel + 1] + "" + romans[classLevel] )) {
				s = s.substring(2);
				result += Math.pow(10, classLevel/2) * 4;
				classLevel = classLevel + 2;
			} else if (s.length() >= 2 && s
				.startsWith(romans[classLevel + 2] + "" + romans[classLevel])) {
				result += Math.pow(10, classLevel/2) * 9;
				s = s.substring(2);
				classLevel = classLevel + 2;
			}else {
				int end=0;
				char[] cs = s.toCharArray();
				while(cs.length > end){
					if(s.startsWith(String.valueOf(romans[classLevel + 2])))		{
						break;
					}
					if(cs[end] == romans[classLevel]){
						result += Math.pow(10, classLevel/2);
						end++;
					}else if(cs[end] == romans[classLevel + 1]){
						result += Math.pow(10, classLevel/2) * 5;
						end++;
					}else {
						break;
					}
				}
				s = s.substring(end);
				classLevel = classLevel + 2;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.romanToInt("III"));
		System.out.println(s.romanToInt("IV"));
		System.out.println(s.romanToInt("MCMXCIV"));
		System.out.println(s.romanToInt("MCDLXXVI"));
	}
}
