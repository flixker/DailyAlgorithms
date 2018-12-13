package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 * Given intervals[1,3],[6,9], insert and merge[2,5]in as[1,5],[6,9].
 *
 * Example 2:
 * Given[1,2],[3,5],[6,7],[8,10],[12,16], insert and merge[4,9]in as[1,2],[3,10],[12,16].
 *
 * This is because the new interval[4,9]overlaps with[3,5],[6,7],[8,10].
 */
public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval){
        double startIndex = findPosition(intervals, newInterval.start);
        double endIndex = findPosition(intervals, newInterval.end);
        ArrayList<Interval> res = new ArrayList<>(intervals.size() + 1);
        for(int i = 0; i < startIndex; i++)
            res.add(intervals.get(i));
        // 造中间节点
        Interval in = new Interval();
        in.start = isInteger(startIndex) ? intervals.get((int)startIndex).start : newInterval.start;
        in.end = isInteger(endIndex) ? intervals.get((int)endIndex).end : newInterval.end;
        res.add(in);
        int e = (int)Math.floor(endIndex) + 1;
        for(int i = e; i < intervals.size(); i++)
            res.add(intervals.get(i));
        return res;
    }

    public double findPosition(ArrayList<Interval> intervals, int val){
        double index = -1;
        for(int i = 0; i < intervals.size(); i++){
            Interval tmp = intervals.get(i);
            if(val <= tmp.end){
                if(val >= tmp.start)
                    index = i;
                else
                    index = i - 0.5;
                break;
            }
        }
        return index == -1 ? intervals.size() - 0.5 : index;
    }

    public boolean isInteger(double d){
        double eps = 1e-10;
        return d - Math.floor(d) < eps;
    }
}
