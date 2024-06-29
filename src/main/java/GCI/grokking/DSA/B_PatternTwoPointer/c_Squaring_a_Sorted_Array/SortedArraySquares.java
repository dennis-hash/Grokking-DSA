package GCI.grokking.DSA.B_PatternTwoPointer.c_Squaring_a_Sorted_Array;

//Given a sorted array, create a new array containing squares of all the number of the input array in the
//sorted order.
//Example 1:
//Input: [-2, -1, 0, 2, 3]
//Output: [0, 1, 4, 4, 9]
//Example 2:
//Input: [-3, -1, 0, 1, 2]
//Output: [0 1 1 4 9]
public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int squareIndex = arr.length-1;
        int negativePointer = 0, positivePointer = arr.length - 1;

        while (negativePointer <= positivePointer) {

          int squareLeft = arr[negativePointer] * arr[negativePointer];
          int squareRight = arr[positivePointer] * arr[positivePointer];

          if(squareLeft > squareRight){
              squares[squareIndex] = squareLeft;
              squareIndex--;
              negativePointer++;
          }else{
              squares[squareIndex] = squareRight;
              squareIndex--;
              positivePointer--;
          }
        }

        return squares;
    }
    public static void main(String[] args) {
        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}

//Time complexity #
//The time complexity of the above algorithm will be O(N ) as we are iterating the input array only once.
//Space complexity #
//The space complexity of the above algorithm will also be O(N ); this space will be used for the output
//array.
