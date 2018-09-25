package me.fycus.nowcoder_leetcode;

import java.util.HashMap;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */

class Point{
    int x;
    int y;

    Point(int a, int b){
        x = a;
        y = b;
    }
}
public class MaxPointsOnALine {
    public static void main(String[] args){
        Point[] points = {new Point(0,0), new Point(1,1), new Point(0,0)};
        System.out.print(maxPoints2(points));
    }


    // 利用 gcd 计算出斜率的分数形式，固定一个点，用不同斜率作不同直线，然后判断后面的点是否在线上。
    // 还有种思路，不用 gcd，而是将判断斜率是否相同由除法改为乘法。
    public static int maxPoints2(Point[] points){
        if(points == null)
            return 0;
        int len = points.length;
        if(len <= 2)
            return len;
        HashMap<String, Integer> map = new HashMap<>();
        int result = 0;
        for(int i= 0; i < len; i++){
            map.clear();
            int overlap = 1;
            int thisMax = 1;
            for(int j = i + 1; j < len; j++){
                int dy = points[j].y - points[i].y;
                int dx = points[j].x - points[i].x;
                if(dy == 0 && dx == 0) {
                    overlap++;
                    thisMax++;
                    continue;
                }
                int gcd = gcd(dy, dx);
                String slope = (dy / gcd) + "/" + (dx / gcd);
                int count = map.getOrDefault(slope, 0);
                map.put(slope, ++count);
                thisMax = Math.max(thisMax, count + overlap);
            }
            result = result > thisMax ? result : thisMax;
        }
        return result;
    }

    public static int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b , a % b);
    }


    // 原始版本，不正确。
    // 枚举所有的直线,用一个集合保存已经计算过的直线。
   public static int maxPoints(Point[] points){
       class Line{
           double k;
           double b;
           Line(double k, double b){
               this.k = k;
               this.b = b;
           }

           @Override
           public boolean equals(Object obj) {
               if(obj == this)
                   return true;
               if(!(obj instanceof Line))
                   return false;
               Line l = (Line)obj;
               return k == l.k && b == l.b;
           }

           @Override
           public int hashCode() {
               int result = 17;
               result = result * 31 + Double.hashCode(k);
               result = result * 31 + Double.hashCode(b);
               return result;
           }
       }

       int len = points.length;
       if(len == 0)
           return 0;
       if(len == 1)
           return 1;
       HashMap<Line, Point> map = new HashMap<>();
       int result = 0;
       for(int i = 0;i < len; i++){
           for(int j = i + 1; j < len; j++){
               double k, b;
               if(points[j].x == points[i].x) {
                   if (points[j].y == points[i].y)
                       continue;
                   k = Double.MAX_VALUE;
                   b = points[j].x;
               }
               else {
                   k = (0d + points[j].y - points[i].y) / (0d + points[j].x - points[i].x);
                   b = points[j].y - k * points[j].x;
               }
               Line l = new Line(k, b);
//               int count = map.getOrDefault(l, 0) + 1;
//               result = result > count ? result : count;
//               map.put(l, count);
           }
       }
       return result;
   }
}
