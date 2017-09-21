package com.learn.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {10,1,3,2,7,4,9,6};
        mergeSort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.println(i);
        }
    }

    private static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right){

        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] l = new int[n1];
        int[] r = new int[n2];

        for(int i = 0 ; i < n1;i++){
            l[i] = arr[left + i];
        }

        for(int i=0;i<n2;i++){
            r[i] = arr[mid+1+i];
        }

        int i =0,j=0,k=left;
        while(i<n1 && j< n2){
            if(l[i] < r[j]){
                arr[k] = l[i];
                i++;
            }
            else{
                arr[k] = r[j];
                j++;
            }
            k++;
        }

        while( i< n1){
            arr[k] = l[i];
            i++;
            k++;
        }

        while(j < n2){
            arr[k] = r[j];
            j++;
            k++;
        }
    }
}
