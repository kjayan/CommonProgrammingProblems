package com.learn.sorting;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {10,1,3,2,7,4,9,6};
        heapSortUsingMinHeap(arr);
        for(int i:arr){
            System.out.println(i);
        }

        int[] arr2 = {10,1,3,2,7,4,9,6};
        heapSortUsingMaxHeap(arr2);
        for(int i:arr2){
            System.out.println(i);
        }
    }

    private static void heapSortUsingMinHeap(int[] arr){
        int n = arr.length;
        for(int i=n/2-1;i>=0;i--){
            minHeapify(arr,n,i);
        }

        for(int i=n-1;i>=0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            minHeapify(arr,i,0);
        }
    }

    private static void minHeapify(int[] arr, int size, int start){
        int largest = start;
        int left = 2 * largest +1;
        int right = 2*largest +2;

        if(left < size && arr[left] > arr[largest]){
            largest = left;
        }

        if(right < size && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest != start){
            int temp = arr[start];
            arr[start] = arr[largest];
            arr[largest] = temp;

            minHeapify(arr,size,largest);
        }
    }

    private static void heapSortUsingMaxHeap(int[] arr){
        int n = arr.length;
        for(int i=n/2-1;i>=0;i--){
            maxHeapify(arr,n,i);
        }

        for(int i=n-1;i>=0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeapify(arr,i,0);
        }
    }

    private static void maxHeapify(int[] arr, int size, int start){
        int smallest = start;
        int left = 2 * smallest +1;
        int right = 2*smallest +2;

        if(left < size && arr[left] < arr[smallest]){
            smallest = left;
        }

        if(right < size && arr[right] < arr[smallest]){
            smallest = right;
        }

        if(smallest != start){
            int temp = arr[start];
            arr[start] = arr[smallest];
            arr[smallest] = temp;

            maxHeapify(arr,size,smallest);
        }
    }

}
