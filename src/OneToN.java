
/*
    1 to N problem type
    Find the Missing and the Duplicate number in an N sized array where numbers only lie within 1 to N
 */
public class OneToN {
    public static void main(String[] args) {
        int[] arr = {1,2,5,3,5};
        findMissingAndDuplicate(arr);
    }

    private static void findMissingAndDuplicate(int[] arr) {
        int i = 0;
        int size = arr.length;
        while(i < size) {
            if (arr[i] != arr[arr[i] - 1])
                swapSort(arr, i, arr[i] - 1);
            else
                i++;
        }
        for (i = 0; i < size; i++) {
            if(arr[i] != i+1) {
                System.out.println("Missing: " + (i+1));
                System.out.println("Duplicate: " + arr[i]);
            }
        }
    }

    private static void swapSort(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
