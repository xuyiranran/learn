package sort;

import java.util.Arrays;

public class OneByOneSort {


    public static void main(String[] args) {

        int[] data = {10, 7, 3, 1, 0};
        data = oneByone(data);
        System.out.println(Arrays.toString(data));
    }


    private static int[] oneByone(int[] data) {


        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[j - 1] > data[j]) {
                    SortUtils.swap(data, j - 1, j);
                }
            }
        }
        return data;

    }
}
