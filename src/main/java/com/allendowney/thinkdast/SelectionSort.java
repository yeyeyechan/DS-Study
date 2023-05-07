package com.allendowney.thinkdast;

public class SelectionSort {

    public static void swapElements(int[] array, int i , int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int indexLowest(int [] array, int start){
        int lowIndex = start;
        for(int i = start; i < array.length ; i++){
            if(array[lowIndex] > array[i]){
                lowIndex= i;
            }
        }
        return lowIndex;
    }
/*
* n제곱에 비례하는 연산 횟수, 선택정인
* */

    public static void selectionSort(int[] array){
        for(int i = 0 ; i < array.length; i++){
            int lowIndex = indexLowest(array,i);
            swapElements(array, i, lowIndex);
        }
    }
}
