package greedy;

public class MaxArea {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int tempLeft = 0;
        int tempRight = height.length - 1;

        for (int left = 0; left < height.length; left++) {
            if (height[left] < height[tempLeft]) {
                continue;
            }
            for (int right = tempRight; right > left; right--) {
                if (height[right] < height[tempRight]) {
                    continue;
                }

                int area = Math.min(height[left], height[right]) * (right - left);

                if (area > maxArea) {
                    maxArea = area;
                    tempRight = right;
                }

            }
            tempLeft = left;
        }
        return maxArea;
//
//        int left = 0;
//        int right = height.length - 1;
//
//        int maxArea = 0;
//        while (left < right) {
//            maxArea = Math.max(maxArea, (right - left) * Math.min(height[right], height[left]));
//            if (height[left]>height[right]){
//                right--;
//            } else {
//                left++;
//            }
//        }
//        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
