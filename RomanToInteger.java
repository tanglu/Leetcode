public class Solution {
HashMap<Character, Integer> romanToIntMap = new HashMap<Character, Integer>() {
		{
			put('I', new Integer(1));
			put('V', new Integer(5));
			put('X', new Integer(10));
			put('L', new Integer(50));
			put('C', new Integer(100));
			put('D', new Integer(500));
			put('M', new Integer(1000));
		}
	};

	public int romanToInt(String s) {
		int ret = 0;
		int i = 0;
		while(i<s.length()) {
			if(s.charAt(i)=='I'||s.charAt(i)=='X'||s.charAt(i)=='C') {
				if((i+1)<=(s.length()-1)&&romanToIntMap.get(s.charAt(i))<romanToIntMap.get(s.charAt(i+1))) {
					ret += romanToIntMap.get(s.charAt(i+1)) - romanToIntMap.get(s.charAt(i));
					i = i + 2;
					continue;
				}
			} 
			ret += romanToIntMap.get(s.charAt(i));
			i++;
		}
		return ret;
	}
}
