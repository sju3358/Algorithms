import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    private final int MAX_WEIGHT = 10000001;

    private List<List<Node>> map;
    private List<Integer> gates;
    private List<Integer> summits;



    private class Node{
        int node;
        int weight;

        public Node(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    private int[] findMinIntensity(){

        int[] intensity = new int[map.size()];
        Queue<Node> queue = new LinkedList<>();

        Arrays.fill(intensity, MAX_WEIGHT);

        for(int gate : gates){
            queue.add(new Node(gate,0));
            intensity[gate] = 0;
        }

        while(queue.isEmpty() != true){

            Node curNode = queue.poll();

            if(intensity[curNode.node] < curNode.weight)
                continue;
            else{
                for(Node nextNode : map.get(curNode.node)){

                    int nextIntensity = Math.max(curNode.weight, nextNode.weight);
                    if(intensity[nextNode.node] > nextIntensity){
                        intensity[nextNode.node] = nextIntensity;
                        queue.add(new Node(nextNode.node, nextIntensity));
                    }
                }
            }
        }

        List<Node> intensityList = new ArrayList<>();
        for(int summit : summits){
            intensityList.add(new Node(summit+1, intensity[summit]));
        }

        intensityList.sort((node1, node2) ->{
            if(node1.weight != node2.weight)
                return node1.weight - node2.weight;
            else
                return node1.node - node2.node;
        });

        return new int[]{intensityList.get(0).node, intensityList.get(0).weight};
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        map = new ArrayList<>();
        for(int i = 0; i < n; i++)
            map.add(new ArrayList<>());

        this.gates = new ArrayList<>();
        for(int i = 0; i < gates.length; i++)
            this.gates.add(gates[i] - 1);

        this.summits = new ArrayList<>();
        for(int i = 0; i < summits.length; i++)
            this.summits.add(summits[i] - 1);

        for(int i = 0; i < paths.length; i++){
            int from = paths[i][0] - 1;
            int to = paths[i][1] - 1;
            int weight = paths[i][2];

            if(this.gates.contains(to) || this.summits.contains(from)){
               this.map.get(to).add(new Node(from, weight));
            } else if(this.gates.contains(from) || this.summits.contains(to)){
                this.map.get(from).add(new Node(to, weight));
            } else{
                this.map.get(from).add(new Node(to, weight));
                this.map.get(to).add(new Node(from, weight));
            }
        }



        return findMinIntensity();
    }

    public static void main(String[] args){
        new Solution()
            .solution(
                6,
                new int[][]{{1,2,3},{2,3,5},{2,4,2},{2,5,4},{3,4,4},{4,5,3},{4,6,1},{5,6,1}},
                new int[]{1,3},
                new int[]{5});
    }
}