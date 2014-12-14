public class Solution {
    public String convert(String s, int nRows) {
       if(s.length()==1||nRows==1) {
			return s;
		}
		
		StringBuffer[] matrix = new StringBuffer[nRows];
		int i = 0, end = nRows - 2, index = 0;
		for(i=0;i<nRows;i++) {
			matrix[i] = new StringBuffer("");
		}
		while(index<s.length()) {
			for(i=0;index<s.length()&&i<=(nRows-1);i++) {
				matrix[i].append(s.charAt(index++));
			}	
			
			for(end=nRows-2;index<s.length()&&end>0;end--) {
				matrix[end].append(s.charAt(index++));
			}
		}
		
        StringBuffer result = new StringBuffer("");
		for(int a=0;a<nRows;a++) {
			result.append(matrix[a]);
		}
		//System.out.println("result="+result.toString());
		return result.toString();
    }
}
