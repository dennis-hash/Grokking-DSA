package GCI.grokking.DSA.E_PatternCyclicSort.a_cyclic_sort;

public class MissingNumber {
    public static int findMissingNumber(int[] nums){
        int i = 0;
        int missingNUmber = 0;
        while (i < nums.length){
            int j = nums[i]; //getting its index
            if(nums[i] < nums.length && nums[i] != nums[j]){
                System.out.println("num"+nums[i]);
                swap(nums, i, j);
            }else{
                i++;
            }

        }

        for(int m = 0; m < nums.length - 1; m++ ){
            if(m != nums[m]){
                missingNUmber = m;
            }
        }
        return missingNUmber;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] arr = new int[] {5, 0, 3, 4 ,2};
        MissingNumber.findMissingNumber(arr);
        System.out.println(MissingNumber.findMissingNumber(arr));

    }

}
