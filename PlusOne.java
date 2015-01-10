public class Solution {
    public int[] plusOne(int[] digits) {
      int flag = 1;
		  int i = 0;
		
		  for(i=digits.length-1;i>=0;i--) {
			  digits[i] = digits[i] + flag;
			  if(digits[i]>9) {
          flag = 1;
          digits[i] = 0;
        } else {
          return digits;
        }
      }
		
		  //发生进位
		  if(i==-1&&flag==1) {
			  int[] newdigits = new int[digits.length+1];
			  newdigits[0] = 1;
			  for(i=1;i<=digits.length;i++) {
				  newdigits[i] = digits[i-1];
			  }
			  return newdigits;
		  } else {
			  return digits;
		  }
  }
}
