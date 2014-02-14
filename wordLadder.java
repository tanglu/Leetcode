//DFS Time Limit Exceeded
//BFS and Use two queues, one for words and another for counting

public class Solution {
        boolean oneCharDiff(String str1, String str2) {
            if(str1.equals(str2)==true) {
                return false;
            }
            short difference = 0;
            for(int i=0;i<str1.length();i++) {
                if(str1.charAt(i)==str2.charAt(i))
                    continue;
                else {
                    difference++;
                    if(difference>1) {
                        return false;
                    }
                }
            }
            return true;
        }
        
        public int ladderLength(String start, String end, HashSet<String> dict) {
            
            if(start.equals(end)==true||start==null||end==null) {
                return 0;
            }
            
            Queue queue = new LinkedList<String>();
            //Use to record the distance of string. You also can use a map to store this value.
            LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
            queue.add(start);
            distanceQueue.add(1);
            int ret = 0;
            while(!queue.isEmpty()) {
                String str = (String)queue.poll();
                ret = (int)distanceQueue.poll();
                //change one char of the current string
                for(int i=0; i<str.length(); i++){
                    char[] strCharArr = str.toCharArray();
                    for(char c='a'; c<='z'; c++){
                        strCharArr[i] = c;
                        String newWord = new String(strCharArr);
                        if(dict.contains(newWord)){
                            if(newWord.equals(end)) {
                                return ret + 1;
                            }
                            queue.add(newWord);
                            distanceQueue.add(ret + 1);
                            dict.remove(newWord);
                        }
                    }
                }
            }
            return 0;
        }
}
