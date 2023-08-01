    import java.util.*;

    class Solution {
        int[][] dp = new int[151][151];
        int maxAlp = 0;
        int maxCop = 0;

        private class Node{
            int curAlp;
            int curCop;
            int curCost;

            public Node(int curAlp, int curCop, int curCost){
                this.curAlp = curAlp;
                this.curCop = curCop;
                this.curCost = curCost;
            }
        }

        public int solution(int alp, int cop, int[][] problems) {


            for(int i = 0; i < problems.length; i++){
                maxAlp = Math.max(maxAlp, problems[i][0]);
                maxCop = Math.max(maxCop, problems[i][1]);
            }


            for(int i = 0; i <= 150; i++)
                for(int j = 0; j <= 150; j++)
                    dp[i][j] = Integer.MAX_VALUE;

            for(int i = 0; i <= alp; i++)
                for(int j = 0; j <= cop; j++)
                    dp[i][j] = 0;

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(alp,cop,0));

            while(queue.isEmpty() != true){

                Node curNode = queue.poll();

                int curAlp = curNode.curAlp;
                int curCop = curNode.curCop;
                int curCost = curNode.curCost;

                if(curAlp == maxAlp && curCop == maxCop){
                    dp[curAlp][curCop] = Math.min(dp[curAlp][curCop],curCost);
                } else {

                    for (int i = 0; i < problems.length; i++) {

                        int alp_req = problems[i][0];
                        int cop_req = problems[i][1];
                        int alp_rwd = problems[i][2];
                        int cop_rwd = problems[i][3];
                        int cost = problems[i][4];

                        if (curAlp >= alp_req && curCop >= cop_req) {

                            int nextAlp = curAlp + alp_rwd;
                            int nextCop = curCop + cop_rwd;

                            if (nextAlp > maxAlp)
                                nextAlp = maxAlp;

                            if (nextCop > maxCop)
                                nextCop = maxCop;

                            if (dp[nextAlp][nextCop] > curCost + cost) {
                                dp[nextAlp][nextCop] = curCost + cost;
                                queue.add(new Node(nextAlp, nextCop, curCost + cost));
                            }
                        }
                    }

                    if (curAlp < maxAlp && dp[curAlp + 1][curCop] > curCost + 1) {
                        dp[curAlp + 1][curCop] = curCost + 1;
                        queue.add(new Node(curAlp + 1, curCop, curCost + 1));
                    }
                    if (curCop < maxCop && dp[curAlp][curCop + 1] > curCost + 1) {
                        dp[curAlp][curCop + 1] = curCost + 1;
                        queue.add(new Node(curAlp, curCop + 1, curCost + 1));
                    }
                }
            }

            return dp[maxAlp][maxCop];

        }

        public static void main(String args[]){
            new Solution().solution(2, 0,new int[][]{{1,1,0,0,0}});
        }
    }