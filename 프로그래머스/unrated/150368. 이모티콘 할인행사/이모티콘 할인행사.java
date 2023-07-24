import java.util.Arrays;

public class Solution {

    private int max_users = 0;
    private int max_profit = 0;

    private int[] discountPer = {10,20,30,40};
    private int[][] users;
    private int[] emotions;

    public void getPermutation(int curLength, int[] permutation){

        if(curLength == permutation.length){

            int sumOfUsers = 0;
            int sumOfProfit = 0;

            for(int i = 0; i < users.length; i++){

                int profit = 0;

                for(int j = 0; j < permutation.length; j++){
                    if(users[i][0] <= discountPer[permutation[j]]) {
                        profit += emotions[j] * (100-discountPer[permutation[j]]) / 100;
                    }
                }

                if(profit >= users[i][1])
                    sumOfUsers++;
                else
                    sumOfProfit += profit;
            }


            if(max_users < sumOfUsers){
                max_users = sumOfUsers;
                max_profit = sumOfProfit;
            }
            else if( max_users == sumOfUsers){
                if(max_profit < sumOfProfit)
                    max_profit = sumOfProfit;
            }

        }
        else {
            for(int i = 0; i < 4; i++){
                permutation[curLength] = i;
                getPermutation(curLength + 1, permutation);
            }
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {

        int[] answer = new int[2];

        this.users = users;
        this.emotions = emoticons;

        getPermutation(0,new int[emoticons.length]);

        answer[0] = max_users;
        answer[1] = max_profit;
        return answer;
    }

    public static void main(String args[]){

        System.out.println(Arrays.toString(new Solution()
            .solution(
                new int[][]{{40, 10000}, {25, 10000}},
                new int[]{7000, 9000}))
        );
    }
}