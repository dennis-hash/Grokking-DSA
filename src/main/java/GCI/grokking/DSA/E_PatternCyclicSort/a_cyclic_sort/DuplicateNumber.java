package GCI.grokking.DSA.E_PatternCyclicSort.a_cyclic_sort;

public class DuplicateNumber {
    public static int findDuplicateNumber(int[] nums){
    int i = 0;
    int duplicate = 0;
    while (i < nums.length){
         int correctIndex = nums[i]-1;

         if(nums[i] != nums[correctIndex]){
             int temp = nums[i];
             nums[i] = nums[correctIndex];
             nums[correctIndex] = temp;

         }else{
             if(i!=correctIndex){
                 duplicate=nums[i];
             }
             i++;
         }
    }
    return duplicate;
    }
    public static void main(String[] args){
        int[] arr = new int[] {2, 1, 3, 3, 5, 4};
        System.out.println(DuplicateNumber.findDuplicateNumber(arr));

    }
}
