package GCI.grokking.DSA.E_PatternCyclicSort.a_cyclic_sort;

import java.util.ArrayList;
import java.util.Arrays;

public class AllMissingNumbers {
    public static ArrayList<Integer> findallMissingNumbers(int[] arr){
        //use cyclic sort
        //iterate through array check if the numbers are in their correct index
        //if not, do a swap
        //iterate through the sorted array and find numbers that dont match their indexes, add the indexex+1 to the mssing numbers array
        ArrayList<Integer> missingNumbers =  new ArrayList<>();
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;

            if (arr[i] != arr[correctIndex]) {
                // Swap arr[i] with arr[correctIndex]
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
            System.out.println(Arrays.toString(arr));
        }

        for (int j = 0; j < arr.length; j++){
            if(arr[j] != j+1){
                missingNumbers.add(j+1);
            }
        }

      return  missingNumbers;
    }
    public static void main(String[] args){
        int[] arr = new int[] {5,  3, 4 ,2};
        System.out.println(AllMissingNumbers.findallMissingNumbers(arr));

    }

}
