import java.util.*;
class QuickSort {
	public static void main(String[] args) {
		int arr[] = { 25, 54, 24, 878, -8, 53, 2, 1, -74, 2 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	static void quickSort(int arr[], int low, int high) {
		if(low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	static int partition(int arr[], int low, int high) {
		int pivot = arr[high], i = low;
		for(int j = low; j < high; ++j)
			if(arr[j] < pivot)
				swap(arr, j, i++);
		swap(arr, i, high);
		return i;
	}

	static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
