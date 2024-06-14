package binarySearch;

public class MySqrt {
    public static void main(String[] args) {
        int x = 121;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        int left = 1;
        int right = x;
        int mid = 0;
        while (left <= right) {
            mid = (right - left) / 2 + left;

            if (mid <= x / mid) {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return -1;

    }
}
