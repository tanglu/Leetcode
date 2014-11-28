public class Solution {
	
    public String addBinary(String a, String b) {
         StringBuffer result = a.length()>=b.length()? new StringBuffer(a):new StringBuffer(b);
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		int index = 0;
		int acurrent = 0;
		int bcurrent = 0;
		
		for(;i>=0||j>=0;i--,j--) {
			acurrent = i>=0? a.charAt(i) - '0' : 0;
			bcurrent = j>=0? b.charAt(j) - '0' : 0;
			int current = (acurrent + bcurrent + carry)%2;
			carry = (acurrent + bcurrent + carry)/2;
			//result = result.insert(0, current);
			if(i>=j) {
				result.setCharAt(i, (char)(current + '0'));
			} else {
				result.setCharAt(j, (char)(current + '0'));
			}
		}
		
		if(carry==1)  {  
			result.insert(0, '1');  
		}  
		
        return result.toString();
    }
}
