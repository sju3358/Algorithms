import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        List<Problem> problemList = new ArrayList<>();
        int alpReqMax = 0;
        int copReqMax = 0;

        problemList.add(new Problem(0, 0, 1, 0, 1));
        problemList.add(new Problem(0, 0, 0, 1, 1));

        for (int i = 0; i < problems.length; i++) {
            int[] problem = problems[i];
            alpReqMax = Math.max(alpReqMax, problem[0]);
            copReqMax = Math.max(copReqMax, problem[1]);
            problemList.add(new Problem(problem[0], problem[1], problem[2], problem[3], problem[4]));
        }
        Collections.sort(problemList);

        PriorityQueue<Power> pq = new PriorityQueue<>();
        int[][] isVisited = new int[1000][1000];
        for(int i = 0; i < 1000; i++) {
            Arrays.fill(isVisited[i], Integer.MAX_VALUE);
        }

        isVisited[alp][cop] = 0;
        pq.add(new Power(alp, cop, 0));

        int answer = 0;
        while (!pq.isEmpty()) {
            Power p = pq.poll();
            int nowAlp = p.alp;
            int nowCop = p.cop;
            int time = p.time;

            if(isVisited[nowAlp][nowCop] < time) continue;
            if (alpReqMax <= nowAlp && copReqMax <= nowCop) {
                answer = time;
                break;
            }

            for (Problem pr : problemList) {
                int alpReq = pr.alpReq;
                int copReq = pr.copReq;
                int nextAlp = nowAlp + pr.alpRwd;
                int nextCop = nowCop + pr.copRwd;
                int nextCost = time + pr.cost;

                if (nowAlp >= alpReq && nowCop >= copReq && isVisited[nextAlp][nextCop] > nextCost) {
                    isVisited[nextAlp][nextCop] = nextCost;
                    pq.add(new Power(nextAlp, nextCop, nextCost));
                }
            }
        }

        return answer;
    }
}
class Power implements Comparable<Power> {
    int alp;
    int cop;
    int time;

    public Power(int alp, int cop, int time) {
        this.alp = alp;
        this.cop = cop;
        this.time = time;
    }

    @Override
    public int compareTo(Power p) {
        return Integer.compare(this.time, p.time);
    }
}

class Problem implements Comparable<Problem> {
    int alpReq;
    int copReq;
    int alpRwd;
    int copRwd;
    int cost;

    public Problem(int alpReq, int copReq, int alpRwd, int copRwd, int cost) {
        this.alpReq = alpReq;
        this.copReq = copReq;
        this.alpRwd = alpRwd;
        this.copRwd = copRwd;
        this.cost = cost;
    }

    @Override
    public int compareTo(Problem p) {
        return Integer.compare(this.cost, p.cost);
    }
}