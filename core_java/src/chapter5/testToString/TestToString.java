package chapter5.testToString;

import java.util.Arrays;

public class TestToString {



    public static void main(String[] args) {
        int[] arr = {1,2, 3, 4};
//        数组不支持tostring
        System.out.println(arr.toString());
        System.out.println(Arrays.toString(arr));
//        多维数组用deeptostring
        int[][] arr2 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println(Arrays.deepToString(arr2));
    }
}
