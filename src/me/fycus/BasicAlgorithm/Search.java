package me.fycus.BasicAlgorithm;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

public class Search {
    public static void main(String[] args){
        Integer[] data = new Integer[]{new Integer(1), new Integer(2),
        new Integer(3), new Integer(7), new Integer(25), new Integer(30)};
        System.out.println(fibonacci(data, 26));
        System.out.println(fibonacci(data, 25));
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
        int high = data.length - 1;
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

    private static int fibonacciRank = 20;
    public static int[] generateFibonacci(){
        int[] result = new int[fibonacciRank];
        result[0] = 0;
        result[1] = 1;
        for(int i = 2; i < fibonacciRank; i++)
            result[i] = result[i - 1] + result[i - 2];
        return result;
    }

    public static int fibonacci(Comparable[] data, Comparable target){
        int[] fibonacci = generateFibonacci();
        int k = 0;
        int len = data.length;
        while(fibonacci[++k] - 1 < len);
        Comparable[] array = Arrays.copyOf(data, fibonacci[k]);
        for(int i = len; i < array.length; i++)
            array[i] = null;
        int low = 0;
        int high = array.length;
        while(low <= high){
            int mid = low + fibonacci[k - 1] - 1;
            if(array[mid] == null){
                high = mid - 1;
                k -= 1;
                continue;
            }
            int result = array[mid].compareTo(target);
            if(result < 0) {
                low = mid + 1;
                k -= 2;
            }
            else if(result > 0) {
                high = mid - 1;
                k -= 1;
            }
            else
                return mid;
        }
        return -1;
    }
}
