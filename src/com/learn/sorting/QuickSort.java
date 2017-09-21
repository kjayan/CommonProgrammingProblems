package com.learn.sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {10,1,3,2,7,4,9,6};
        quickSort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.println(i);
        }


    }

    private static void quickSort(int[] arr,int low, int high){
        if(low < high){
            int pivot = partition(arr,low,high);
            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot+1,high);
        }
    }

    private static int partition(int[] arr, int low,int high){
        int i = low -1;
        int pivot = arr[high];

        for(int j = low; j< high;j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
}
