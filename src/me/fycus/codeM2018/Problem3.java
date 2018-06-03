package me.fycus.codeM2018;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args){
        float ewin;
        float fwin;
        Scanner in = new Scanner(System.in);
        float[][] winRate = new float[16][16];
        for(int i = 0; i < 16; i++)
            for(int j = 0; j < 16; j++)
                winRate[i][j] = in.nextFloat();

        Map<Integer, Float>[] oneOfEight = new HashMap[8];
        for(int i = 0; i < 4; i++){
            oneOfEight[2 * i] = new HashMap<>();
            oneOfEight[2 * i + 1] = new HashMap<>();
            int start = i * 4;
            int counter1 = start + 1;
            int counter2 = start + 2;
            oneOfEight[2 * i].put(counter1, winRate[counter1][counter2]);
            oneOfEight[2 * i].put(counter2, winRate[counter2][counter1]);
            counter1 = start;
            counter2 = start + 3;
            oneOfEight[2 * i + 1].put(counter1, winRate[counter1][counter2]);
            oneOfEight[2 * i + 1].put(counter2, winRate[counter2][counter1]);
        }

        Map<Integer, Float>[] oneOfFour = new HashMap[4];
        for(int i = 0; i < 2; i++){
            oneOfFour[2 * i] = new HashMap<>();
            oneOfFour[2 * i + 1] = new HashMap<>();
            int start = i * 4;
            int counter1 = start;
            int counter2 = start + 2;
            for(Map.Entry<Integer, Float> e : oneOfEight[counter1].entrySet()) {
                for (Map.Entry<Integer, Float> f : oneOfEight[counter2].entrySet()){
                    if(oneOfFour[2 * i].get(e.getKey()) != null) {
                        ewin = oneOfFour[2 * i].get(e.getKey());
                    }else
                        ewin = 0;
                    if(oneOfFour[2 * i].get(f.getKey()) != null) {
                        fwin = oneOfFour[2 * i].get(f.getKey());
                    }else
                        fwin = 0;
                    oneOfFour[2 * i].put(e.getKey(),ewin + e.getValue() * f.getValue() * winRate[e.getKey()][f.getKey()]);
                    oneOfFour[2 * i].put(f.getKey(),fwin + e.getValue() * f.getValue() * winRate[f.getKey()][e.getKey()]);
                }
            }
            counter1 = start + 1;
            counter2 = start + 3;
            for(Map.Entry<Integer, Float> e : oneOfEight[counter1].entrySet()) {
                for (Map.Entry<Integer, Float> f : oneOfEight[counter2].entrySet()){
                    if(oneOfFour[2 * i + 1].get(e.getKey()) != null) {
                        ewin = oneOfFour[2 * i + 1].get(e.getKey());
                    }else
                        ewin = 0;
                    if(oneOfFour[2 * i + 1].get(f.getKey()) != null) {
                        fwin = oneOfFour[2 * i + 1].get(f.getKey());
                    }else
                        fwin = 0;
                    oneOfFour[2 * i + 1].put(e.getKey(),ewin + e.getValue() * f.getValue() * winRate[e.getKey()][f.getKey()]);
                    oneOfFour[2 * i + 1].put(f.getKey(),fwin + e.getValue() * f.getValue() * winRate[f.getKey()][e.getKey()]);
                }
            }
        }

        Map<Integer, Float>[] oneOfTwo = new HashMap[2];
        oneOfTwo[0] = new HashMap<>();
        oneOfTwo[1] = new HashMap<>();
        for(Map.Entry<Integer, Float> e : oneOfFour[0].entrySet()){
            for(Map.Entry<Integer, Float> f : oneOfFour[2].entrySet()){
                if(oneOfTwo[0].get(e.getKey()) != null){
                    ewin = oneOfTwo[0].get(e.getKey());
                }else
                    ewin = 0;
                if(oneOfTwo[0].get(f.getKey()) != null){
                    fwin = oneOfTwo[0].get(f.getKey());
                }else
                    fwin = 0;
                oneOfTwo[0].put(e.getKey(),ewin + e.getValue() * f.getValue() * winRate[e.getKey()][f.getKey()]);
                oneOfTwo[0].put(f.getKey(),fwin + e.getValue() * f.getValue() * winRate[f.getKey()][e.getKey()]);
            }
        }
        for(Map.Entry<Integer, Float> e : oneOfFour[1].entrySet()){
            for(Map.Entry<Integer, Float> f : oneOfFour[3].entrySet()){
                if(oneOfTwo[1].get(e.getKey()) != null){
                    ewin = oneOfTwo[1].get(e.getKey());
                }else
                    ewin = 0;
                if(oneOfTwo[1].get(f.getKey()) != null){
                    fwin = oneOfTwo[1].get(f.getKey());
                }else
                    fwin = 0;
                oneOfTwo[1].put(e.getKey(),ewin + e.getValue() * f.getValue() * winRate[e.getKey()][f.getKey()]);
                oneOfTwo[1].put(f.getKey(),fwin + e.getValue() * f.getValue() * winRate[f.getKey()][e.getKey()]);
            }
        }

        Map<Integer, Float> champion = new HashMap<>();
        for(Map.Entry<Integer, Float> e : oneOfTwo[0].entrySet()){
            for(Map.Entry<Integer, Float> f : oneOfTwo[1].entrySet()){
                if(champion.get(e.getKey()) != null){
                    ewin = champion.get(e.getKey());
                }else
                    ewin = 0;
                if(champion.get(f.getKey()) != null) {
                    fwin = champion.get(f.getKey());
                }else
                    fwin = 0;
                champion.put(e.getKey(), ewin + e.getValue() * f.getValue() * winRate[e.getKey()][f.getKey()]);
                champion.put(f.getKey(), fwin + e.getValue() * f.getValue() * winRate[f.getKey()][e.getKey()]);
            }
        }

        for(int i = 0; i < 16; i++){
            System.out.print(champion.get(i));
            if(i != 15)
                System.out.print(" ");
        }
    }
}
