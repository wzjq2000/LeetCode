package binarySearch;

public class HIndex {
    public static int hIndex(int[] citations) {
        int left = 1;
        int right = citations.length;

        int mid = 1;
        int count = 0;
        while (left <= right) {
            count = 0;
            mid = (left + right) / 2;
            for (Integer i : citations) {
                if (i >= mid) count++;
            }
            if (count == mid) return mid;
            if (count < mid) {
                right = mid - 1;

            } else {
                if (left==right) {
                    return mid;
                }
                left = mid + 1;

            }
        }
        return right;

    }

    public static void main(String[] args) {
//        int[] citations = {3,1,1,5,8};
        int[] citations = {1, 1};
        System.out.println(hIndex(citations));
    }
}
