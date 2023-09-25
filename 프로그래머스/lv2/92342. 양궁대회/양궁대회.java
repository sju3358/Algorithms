import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private int maxScoreSub = -1;
    private int[] maxLionScoreHistory;

    private int[] apeachSoreHistory;

    private int countOfArrow;

    private void findMaxScore(int scoreIndex, int sumOfArrows,int[] lionScoreHistory){
        if(scoreIndex == 11 || sumOfArrows == countOfArrow){

            if(sumOfArrows != countOfArrow)
                return;

            int lionScore = 0;
            int apeachScore = 0;

            for(int i = 0; i < 11; i++){

                if(lionScoreHistory[i] == 0 && apeachSoreHistory[i] == 0)
                    continue;

                if(apeachSoreHistory[i] == 0 && lionScoreHistory[i] > 0) {
                    lionScore += 10 - i;
                    continue;
                }

                if(apeachSoreHistory[i] >0 && lionScoreHistory[i] == 0){
                    apeachScore += 10 - i;
                    continue;
                }

                if(lionScoreHistory[i] > apeachSoreHistory[i])
                    lionScore += 10 - i;
                else
                    apeachScore += 10 - i;

            }


            if(lionScore > apeachScore){
                if(lionScore-apeachScore > maxScoreSub) {
                    maxScoreSub = lionScore-apeachScore;
                    maxLionScoreHistory = lionScoreHistory;
                }else if(lionScore-apeachScore == maxScoreSub){

                    for(int i = 10; i >= 0; i--){
                        int originHistoryCount = maxLionScoreHistory[i];
                        int newHistoryCount = lionScoreHistory[i];

                        if(originHistoryCount > newHistoryCount){
                            break;
                        }else if(originHistoryCount < newHistoryCount){
                            maxLionScoreHistory = lionScoreHistory;
                            break;
                        }
                    }

                }
            }
        } else{
            for(int arrows = 0; arrows <= countOfArrow; arrows++){
                if(sumOfArrows + arrows <= countOfArrow) {
                    int[] nextLionHistory = Arrays.copyOf(lionScoreHistory, lionScoreHistory.length);
                    nextLionHistory[scoreIndex] = arrows;
                    findMaxScore(scoreIndex + 1, sumOfArrows + arrows, nextLionHistory);
                }
            }
        }
    }

    public int[] solution(int n, int[] info) {

        this.apeachSoreHistory = info;
        this.countOfArrow = n;

        int[] scoreHistory = new int[11];
        Arrays.fill(scoreHistory,0);

        findMaxScore(0,0,scoreHistory);

        if(maxScoreSub == -1)
            return new int[]{-1};
        return maxLionScoreHistory;
    }

    public static void main(String args[]){
        new Solution().solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3});
    }
}