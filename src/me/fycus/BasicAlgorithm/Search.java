package me.fycus.BasicAlgorithm;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Search {
    public static void main(String[] args){
        Integer[] data = new Integer[]{new Integer(1), new Integer(2),
        new Integer(3), new Integer(7), new Integer(25), new Integer(30)};
        System.out.println(binaryRecursion(data, 26, 0, data.length - 1));
        System.out.println(binaryRecursion(data, 7, 0, data.length - 1));
    }
    public static int sequence(Comparable[] data, Comparable target){
        for(int i = 0; i < data.length; i++){
            if(data[i].compareTo(target) == 0)
                return i;
        }
        return -1;
    }

    public static int binary(Comparable[] data, Comparable target){
        int low = 0;
        int high = data.length;
        int mid;
        while(low <= high){
            mid = (low + high) / 2;
            int result = data[mid].compareTo(target);
            if(result < 0)
                low = mid + 1;
            else if(result > 0)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static int binaryRecursion(Comparable[] data, Comparable target, int low, int high){
        if(low > high)
            return -1;
        int mid = (low + high) / 2;
        int result = data[mid].compareTo(target);
        if(result == 0)
            return mid;
        if(result < 0)
            return binaryRecursion(data, target, mid + 1, high);
        else
            return binaryRecursion(data, target, low, mid - 1);
    }

    public static int insertion(Comparable[] data, Comparable target, int low, int high){
        throw new NotImplementedException();
    }

    public static int fibonacci(Comparable[] data, Comparable target){

    }
}
