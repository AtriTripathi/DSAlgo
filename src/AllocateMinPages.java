import java.util.Collections;

public class AllocateMinPages {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40};
        int maxStudents = 2;

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : arr) {
            if (i > max)
                max = i;
            sum += i;
        }

        int start = max;
        int end = sum;
        int res = -1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(isValid(arr,mid,maxStudents)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println("Result: " + res);
    }

    private static boolean isValid(int[] arr, int maxPapers, int maxStudents) {
        int countStudents = 1;
        int sum = 0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if(sum > maxPapers) {
                countStudents++;
                sum = arr[i];
                if (countStudents > maxStudents)
                    return false;
            }
        }
        return true;
    }
}
