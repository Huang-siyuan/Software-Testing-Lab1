// Radix Sort in Java Programming

import lombok.Data;

import java.util.ArrayList;

@Data
public class RadixSort {

    // Using counting sort to sort the elements in the basis of significant places
    static void countingSort(ArrayList<Integer> array, int size, int place) {
        int[] output = new int[size + 1];
        int max = array.get(0);
        for (int i = 1; i < size; i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }

        if (size == 0) {
            return;
        }

        // Calculate count of elements
        for (int i = 0; i < size; i++) {
            count[(array.get(i) / place) % 10]++;
        }

        // Calculate cumulative count
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            output[count[(array.get(i) / place) % 10] - 1] = array.get(i);
            count[(array.get(i) / place) % 10]--;
        }

        for (int i = 0; i < size; i++) {
            array.set(i, output[i]);
        }
    }

    // Function to get the largest element from an array
    int getMax(ArrayList<Integer> array, int n) {
        int max = array.get(0);
        for (int i = 1; i < n; i++) {
            if (array.get(i) > max) max = array.get(i);
        }
        return max;
    }

    // Main function to implement radix sort
    void radixSort(ArrayList<Integer> array) {

        int size = array.size();

        // Get maximum element
        int max = getMax(array, size);

        // Apply counting sort to sort elements based on place value.
        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(array, size, place);
        }
    }
}