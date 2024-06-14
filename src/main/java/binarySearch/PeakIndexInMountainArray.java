package binarySearch;

public class PeakIndexInMountainArray {
    public static void main(String[] args) {
//        int []arr = {1,3,5,4,2};
        int[] arr = {3, 5, 3, 2, 0};
        System.out.println(peakIndexInMountainArray(arr));

    }

    public static int peakIndexInMountainArray(int[] arr) {
        if (arr.length <= 1) return 0;
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (left == right) break;
            if (arr[mid] > arr[mid + 1]) {
                right = mid - 1;
            }
            if (mid == left && right != mid - 1) return mid + 1;

            if (arr[mid] > arr[mid - 1]) {
                left = mid + 1;
            }
        }
        return mid;
    }
}
