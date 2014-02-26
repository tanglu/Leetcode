//首先把所有数字放入一个hash表，然后对数组中的每个元素在hash表中查找
//然后对元素加1并继续在hash表中查找直到找不到
//同理元素减1，然后在hash表中查找。
//对所有查找到的元素从hash表中删除
public class Solution {
    public int longestConsecutive(int[] num) {
        if(num==null || num.length==0)
            return 0;
        Map<Integer, Integer> hashmap = new HashMap<Integer,Integer>();
        for(int i=0;i<num.length;i++) {
            hashmap.put(num[i],1);
        }
        
        int max_sequence_num = 0;
        int sequence_num = 1;
        int value;
        for(int i=0;i<num.length;i++) {
            value = num[i] + 1;
            while(hashmap.get(value)!=null) {
                hashmap.remove(value);
                value++;
                sequence_num++;
            }
            value = num[i] - 1;
            while(hashmap.get(value)!=null) {
                hashmap.remove(value);
                value--;
                sequence_num++;
            }
            if(sequence_num>max_sequence_num){
                max_sequence_num = sequence_num;
            }
            sequence_num = 1;
        }
        return max_sequence_num;
    }
}
