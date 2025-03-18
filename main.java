import java.util.Scanner; // Importing Scanner class for user input

public class main { // Main class
    public static void main(String args[]) { // Main method
        // Array to be sorted
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        // Print the given array
        System.out.println("Given array is");
        printArray(arr);

        // Create a Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);
        // Ask the user to choose a sorting algorithm
        System.out.println("Choose sorting algorithm: \n1. Merge Sort\n2. Selection Sort");
        int choice = scanner.nextInt(); // Store the user's choice

        // Perform sorting based on user's choice
        switch (choice) {
            case 1:
                // Perform Merge Sort
                sort(arr, 0, arr.length - 1);
                System.out.println("\nArray sorted using Merge Sort:");
                break;
            case 2:
                // Perform Selection Sort
                selectionSort(arr);
                System.out.println("\nArray sorted using Selection Sort:");
                break;
            default:
                // Handle invalid choice
                System.out.println("Invalid choice!");
                scanner.close(); // Close the scanner
                return; // Exit the program
        }

        // Print the sorted array
        printArray(arr);
        // Close the scanner object to release resources
        scanner.close();
    }

    // Method to print the contents of an array
    static void printArray(int arr[]) {
        int n = arr.length; // Length of the array
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " "); // Print each element followed by a space
        System.out.println(); // Move to the next line after printing the array
    }

    // Recursive method for Merge Sort
    static void sort(int arr[], int l, int r) {
        if (l < r) { // Check if there are elements to sort
            int m = (l + r) / 2; // Find the middle point

            // Recursively sort the first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Method to merge two sorted sub-arrays
    static void merge(int arr[], int l, int m, int r) {
        // Calculate sizes of two sub-arrays
        int n1 = m - l + 1; // Size of the left sub-array
        int n2 = r - m; // Size of the right sub-array

        // Temporary arrays to hold the data
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Initial indices for left (L[]), right (R[]), and merged array (arr[])
        int i = 0, j = 0, k = l;

        // Merge the temporary arrays back into the original array
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[], if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[], if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Method for Selection Sort
    static void selectionSort(int arr[]) {
        int n = arr.length; // Length of the array

        // Traverse the array
        for (int i = 0; i < n - 1; i++) {
            // Assume the current element is the minimum
            int min_idx = i;
            // Find the minimum element in the remaining unsorted array
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        
        }// End of outer loop
    }// End of selectionSort method
}// End of main class
