package me.fycus.nowcoder_leetcode;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *
 * Note:
 * The solution is guaranteed to be unique.
 */
public class GasStation{
    public static int canCompletecircuit(int[] gas, int[] cost){
        for(int i = 0; i < gas.length; i++){
            int remaining = gas[i];
            int j = i;
            boolean off = false;
            while(j != i || !off){
                if(j == i)
                    off = true;
                if(cost[j] > remaining)
                    break;
                remaining -= cost[j];
                j = (j + 1) % gas.length;
                remaining += gas[j];
                if(j == i)
                    return i;
            }
        }
        return -1;
    }
}