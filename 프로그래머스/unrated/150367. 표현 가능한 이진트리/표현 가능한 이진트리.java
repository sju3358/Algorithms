import java.util.Arrays;

class Solution {

    private long[] cntOfHeight = new long[55];

    private void initCntOfHeight(){

        cntOfHeight[0] = 1;

        for(int i = 1; i < 50; i++){
            cntOfHeight[i] = (cntOfHeight[i-1]+1)*2-1;
        }
    }

    private String toBinary(Long number){

        String binaryNumber = "";

        while(number > 0){
            if(number % 2 == 1)
                binaryNumber = "1" + binaryNumber;
            else
                binaryNumber = "0" + binaryNumber;

            number = number / 2;
        }

        return binaryNumber;
    }

    private int findUpperbound(int length){
        for(int i = 0; i < cntOfHeight.length; i++)
            if(length <= cntOfHeight[i])
                return i;
        return -1;
    }

    private String fullBinaryTree(String tree){

        int targetIndex = findUpperbound(tree.length());

        while(tree.length() != cntOfHeight[targetIndex])
            tree = "0" + tree;

        return tree;
    }

    private boolean isAllZero(String tree){
        for(int i = 0; i < tree.length(); i++)
            if(tree.charAt(i) != '0')
                return false;
        return true;
    }

    private boolean canMakeToBinaryTree(String binaryNumber){

        if(isAllZero(binaryNumber) == true)
            return true;

        if(binaryNumber.length() == 1)
            return true;




        int midIndex = (binaryNumber.length()-1) / 2;

        if(binaryNumber.charAt(midIndex) == '0')
            return false;

        String left = binaryNumber.substring(0,midIndex);
        String right = binaryNumber.substring(midIndex+1);

        if( canMakeToBinaryTree(left) != true )
            return false;
        if( canMakeToBinaryTree(right) != true)
            return false;

        return true;
    }


    public int[] solution(long[] numbers) {

        initCntOfHeight();
        int[] answer = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++){

            String binaryNumber = toBinary(numbers[i]);
            binaryNumber = fullBinaryTree(binaryNumber);

            if(canMakeToBinaryTree(binaryNumber) == true)
                answer[i] = 1;
            else
                answer[i] = 0;
        }
        return answer;
    }

    public static void main(String args[]){
        System.out.println(Arrays.toString(new Solution().solution(new long[]{7})));
    }
}