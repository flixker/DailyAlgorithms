package me.fycus.codeM2018;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args){
        double special = 0;
        double noSpecial = 0;
        double minFullminus = Double.MAX_VALUE;
        Scanner in = new Scanner(System.in);
        int objectNum = in.nextInt();
        int fullminusNum = in.nextInt();

        for(int i = 0; i < objectNum; i++){
            int price = in.nextInt();
            noSpecial += price;
            int allowSpecial = in.nextInt();
            if(allowSpecial == 1)
                special += price * 0.8;
            else
                special += price;
        }

        for(int i = 0; i < fullminusNum; i++){
            int b = in.nextInt();
            int c = in.nextInt();
            double fullminus;
            if(noSpecial >= b)
                fullminus = noSpecial - c;
            else
                fullminus = noSpecial;
            if(fullminus < minFullminus)
                minFullminus = fullminus;
        }

        double result = Math.min(special, minFullminus);
        System.out.println(String.format("%.2f", result));
    }
}
