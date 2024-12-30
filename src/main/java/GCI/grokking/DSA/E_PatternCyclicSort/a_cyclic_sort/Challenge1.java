package GCI.grokking.DSA.E_PatternCyclicSort.a_cyclic_sort;

import java.util.ArrayList;

public class Challenge1 {
    public static ArrayList<Integer> challenge1(int[] arr){
        int i = 0;
        ArrayList<Integer> result=new ArrayList<>();
        while (i < arr.length){
            int realIndex=arr[i]-1;

            if(arr[i] != arr[realIndex]){
                int temp = arr[i];
                arr[i] = arr[realIndex];
                arr[realIndex] = temp;
            }else{
                if(i!=realIndex){
                    result.add(arr[i]);
                    //result.add(i+1);
                }

                i++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] arr = new int[] {3, 1, 2, 3, 6, 4};
        System.out.println(Challenge1.challenge1(arr));

    }
}
