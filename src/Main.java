import java.util.Random;

public class Main {

    // Binary Search function
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

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

    public static void main(String[] args) {
        // Create an array with 1 billion sorted elements
        int[] arr = new int[1_000_000_000]; // 1 billion elements
        Random rand = new Random();
        int startValue = 0;

        // Populate the array with random values, ensuring it's sorted
        for (int i = 0; i < arr.length; i++) {
            startValue += rand.nextInt(10) + 1; // Incrementing values to keep it sorted
            arr[i] = startValue;
        }

        // Target element to search for
        int target = arr[500_000_000]; // Search for the element at index 500 million

        // Binary Search
        long binaryStartTime = System.currentTimeMillis(); // Start time for binary search
        int binaryResult = binarySearch(arr, target);
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
    }
}
