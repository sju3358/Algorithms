import java.util.HashMap;

class Solution {

    private static class Node{
        private Node parent;
        private int profit;

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }

        public Node(Node parent, int profit){
            this.parent = parent;
            this.profit = profit;
        }


    }


    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        HashMap<String, Node> map = new HashMap<>();

        Node root = new Node(null, 0);

        for(int i = 0; i < enroll.length; i++){
            String parent = referral[i];
            String child = enroll[i];

            Node parentNode;
            if(parent.equals("-") == true){
                parentNode = root;
            } else {
                parentNode = map.get(parent);
            }
            Node childNode = new Node(parentNode,0);
            map.put(child,childNode);
        }

        for(int i = 0; i < seller.length; i++){

            Node sellerNode = map.get(seller[i]);
            int sellAmount = amount[i] * 100;

            while(sellerNode.getParent() != null){

                if(sellAmount == 0)
                    break;

                int parentProfit = sellAmount / 10;
                Node parentNode = sellerNode.getParent();

                sellerNode.setProfit(sellerNode.getProfit() + sellAmount - parentProfit);
                sellAmount = parentProfit;
                sellerNode = parentNode;
            }
        }


        int[] answer = new int[enroll.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = map.get(enroll[i]).getProfit();
        }

        return answer;
    }

    public static void main(String args[]){
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        new Solution().solution(enroll,referral,seller,amount);

    }
}