public class Solution {
    public int maxArea(int[] height) {
        int i = 0  , j = height.length -1 , max=0, temp = 0;
        while(i<j) {
            
            if (height[i]<height[j]) {
                temp = (j - i) * height[i];
                i++;
            } else {
                temp = (j - i) * height[j];
                j--;
            }
            if(temp>max) {
                max = temp;
            }
            
        }
        return max;
    }
}
