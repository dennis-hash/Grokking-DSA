package GCI.grokking.DSA.E_PatternCyclicSort.a_cyclic_sort;

public class CyclicSort {
    public static void sort(int[] nums){
        int i = 0;
        while (i < nums.length){
            int j = nums[i] - 1; //getting its index
            if(nums[i] != nums[j]){
                swap(nums, i, j);
            }else{
                i++;
            }

        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] arr = new int[] {3, 1, 5, 4 ,2};
        CyclicSort.sort(arr);

        for (int num: arr){
            System.out.println(num + " ");
        }
    }

}
