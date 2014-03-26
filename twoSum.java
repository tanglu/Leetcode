public class Solution {
    class Element{
        int val;
        int index;
        Element(int val, int index) {
            this.val   = val;
            this.index = index;
        }
    }
    
    public int[] twoSum(int[] numbers, int target) {
        int [] ret = new int[2];
        if (numbers==null || numbers.length<2 ) {
            return ret;
        }
        Element[] e = new Element[numbers.length];
        for(int i=0;i<numbers.length;i++){
            e[i]=new Element(numbers[i],i);
        }
        
        Arrays.sort(e, new Comparator<Element>() { public int compare(Element a, Element b) {return a.val>b.val?1:(a.val==b.val?0:-1);}});
        int begin = 0;
        int end   = e.length - 1;
        while(begin<end) {
            if((e[begin].val + e[end].val)==target) {
                ret[0] = Math.min(e[begin].index, e[end].index) + 1;
                ret[1] = Math.max(e[begin].index, e[end].index) + 1;
                return ret;
            } else {
                if((e[begin].val + e[end].val)>target) {
                    end--;
                } else {
                    begin++;
                }
            }
        }
        return ret;
    }
}
