class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval p1, Interval p2) {
        return p1.start - p2.start;
    }
}

public class Solution {
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        Iterator<Interval> it = intervals.listIterator();  
        Interval current = null;
        Interval next     = null;
        while(it.hasNext()) {
            if(current==null) {
                current = it.next();
                continue;
            }
            next =  it.next();
            if(current.end<next.start) {
                current = next;
            } else {
                if(next.end<=current.end) {
                    it.remove();
                } else {
                    current.end = Math.max(next.end,current.end);
                    it.remove();
                }
            }
        }
        return intervals;
    }
}
