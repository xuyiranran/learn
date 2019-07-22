package learn_leetcode;

public class Test {

    public static int search(int[] nums, int target) {


        //nums = [4,5,6,7,0,1,2], target = 0 result=4
        if (nums.length == 0) return -1;
        if (nums.length == 0) {
            if (nums[0] == target) return 0;
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (nums[start] == target) return start;
            if (nums[end] == target) return end;
            int middle = (start + end) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                if ((nums[middle] > nums[start] && target < nums[start]) || target < nums[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            } else if (target < nums[middle]) {
                if ((nums[middle] > nums[start] && target > nums[start]) || target < nums[start]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {


//        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};

        System.out.println(search(nums, 4));
    }


}
