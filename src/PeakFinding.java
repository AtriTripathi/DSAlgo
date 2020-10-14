public class PeakFinding {
    enum SortOrder {
        ASC, DSC
    }

    public static int findPeak(int[] arr) {
        int len = arr.length;
        int low = 0;
        int high = len - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(mid > 0 && mid < len-1) {
                if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                    return mid;
                } else if(arr[mid+1] >= arr[mid]) {
                    low = mid + 1;
                } else {
                    high = mid -1;
                }
            } else if(mid == 0) {
                return arr[0] > arr[1] ? 0: 1;
            } else if(mid == len-1) {
                return arr[len-1] > arr[len-2] ? len-1: len-2;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int key, int low, int high, SortOrder sortOrder) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(key == arr[mid])
                return mid;
            else if(sortOrder == SortOrder.ASC && key < arr[mid] ||
                    sortOrder == SortOrder.DSC && key > arr[mid])
                high = mid - 1;
            else if(sortOrder == SortOrder.ASC && key > arr[mid] ||
                    sortOrder == SortOrder.DSC && key < arr[mid])
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,5,7,6,2,0};
        int len = arr.length;
        int key = 11;
        int peak = findPeak(arr);
        int leftSearch = binarySearch(arr, key, 0, peak - 1, SortOrder.ASC);
        int rightSearch = binarySearch(arr, key, peak, len - 1, SortOrder.DSC);

        System.out.println("Element found at: " + (Math.max(leftSearch, rightSearch)));
    }
}
