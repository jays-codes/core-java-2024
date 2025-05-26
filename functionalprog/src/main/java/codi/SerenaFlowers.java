package codi;

import java.util.Arrays;

public class SerenaFlowers {
    public static void main(String[] args) {
        System.out.println("Serena Flowers");
        
        var arr =  new int[] {1, 2, 7, 1, 5,2,3,1,1,8};

        System.out.println("uniques: " + serenaFlowers(5, arr));
    }

    public static int serenaFlowers(int steps, int[] arr){
        return (int) Arrays.stream(arr).limit(steps).distinct().count();
    }
}
