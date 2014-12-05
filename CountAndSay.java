public class Solution {
    public String countAndSay(int n) {
        String result = "1";
		    StringBuffer newString = new StringBuffer("");
        int i = 1;
		    while(i<n) {
        	char tmp = result.charAt(0);
        	int  num = 1;
        	for(int k=1;k<result.length();k++) {
        	  if(result.charAt(k)==tmp) {
        		  num++;
        		  continue;
        	  }
        	  newString.append(Integer.toString(num) + tmp);
        	  tmp = result.charAt(k);
        	  num = 1;
          }
          newString.append(Integer.toString(num) + tmp);
    		  result = newString.toString();
    		  newString.setLength(0);
    		  i++;
      }
		  return result;
  }
}
