import java.util.Random;

public class Main {

    // Binary Search function
    public static int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target)
                return mid;

            // If target is greater, ignore the left half
            if (arr[mid] < target)
                left = mid + 1;
            // If target is smaller, ignore the right half
            else
                right = mid - 1;
        }

        // If the target is not found, return -1
        return -1;
    }

    // Linear Search function
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1; // If target is not found
    }

    // Exponential Search function
    public static int exponentialSearch(int[] arr, int target) {
        // If the target is the first element
        if (arr[0] == target)
            return 0;

        // Find the range for binary search by doubling the index
        int i = 1;
        while (i < arr.length && arr[i] <= target)
            i = i * 2;

        // Perform binary search within the found range
        return binarySearch(arr, i / 2, Math.min(i, arr.length - 1), target);
    }

    public static void main(String[] args) {
        // Create an array with 1 billion sorted elements
        int[] arr = new int[1_000]; // 1 billion elements
        Random rand = new Random();
        int startValue = 0;

        // Populate the array with random values, ensuring it's sorted
        for (int i = 0; i < arr.length; i++) {
            startValue += rand.nextInt(10) + 1; // Incrementing values to keep it sorted
            arr[i] = startValue;
        }

        // Target element to search for
        int target = arr[500]; // Search for the element at index 500 million

        // Binary Search
        long binaryStartTime = System.currentTimeMillis(); // Start time for binary search
        int binaryResult = binarySearch(arr, 0, arr.length - 1, target);
        long binaryEndTime = System.currentTimeMillis(); // End time for binary search
        long binaryTimeTaken = binaryEndTime - binaryStartTime;

        // Output binary search result and time taken
        if (binaryResult == -1)
            System.out.println("Element not found (binary search).");
        else
            System.out.println("Element found at index (binary search): " + binaryResult);
        System.out.println("Binary Search Time taken: " + binaryTimeTaken + " ms");

        // Linear Search
        long linearStartTime = System.currentTimeMillis(); // Start time for linear search
        int linearResult = linearSearch(arr, target);
        long linearEndTime = System.currentTimeMillis(); // End time for linear search
        long linearTimeTaken = linearEndTime - linearStartTime;

        // Output linear search result and time taken
        if (linearResult == -1)
            System.out.println("Element not found (linear search).");
        else
            System.out.println("Element found at index (linear search): " + linearResult);
        System.out.println("Linear Search Time taken: " + linearTimeTaken + " ms");

        // Exponential Search
        long exponentialStartTime = System.currentTimeMillis(); // Start time for exponential search
        int exponentialResult = exponentialSearch(arr, target);
        long exponentialEndTime = System.currentTimeMillis(); // End time for exponential search
        long exponentialTimeTaken = exponentialEndTime - exponentialStartTime;

        // Output exponential search result and time taken
        if (exponentialResult == -1)
            System.out.println("Element not found (exponential search).");
        else
            System.out.println("Element found at index (exponential search): " + exponentialResult);
        System.out.println("Exponential Search Time taken: " + exponentialTimeTaken + " ms");
    }
}
