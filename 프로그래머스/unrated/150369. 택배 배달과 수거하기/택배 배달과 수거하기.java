class Solution {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        long answer = 0;

        int deliveryIndex = n-1;
        int pickupIndex = n-1;


        while(deliveryIndex >= 0 || pickupIndex >= 0) {

            while(deliveryIndex >=0 && deliveries[deliveryIndex] == 0)
                deliveryIndex--;
            while(pickupIndex >=0 && pickups[pickupIndex] == 0)
                pickupIndex--;

            answer += deliveryIndex > pickupIndex ? (deliveryIndex+1)*2 : (pickupIndex+1)*2;

            int deliveryCap = cap;

            while (deliveryIndex >= 0 && deliveryCap > 0) {

                if (deliveryCap >= deliveries[deliveryIndex]) {

                    deliveryCap = deliveryCap - deliveries[deliveryIndex];
                    deliveries[deliveryIndex] = 0;
                    deliveryIndex--;

                } else {
                    deliveries[deliveryIndex] -= deliveryCap;
                    deliveryCap = 0;
                }
            }

            int pickupCap = cap;

            while (pickupIndex >= 0 && pickupCap > 0) {
                
                if (pickupCap >= pickups[pickupIndex]) {

                    pickupCap = pickupCap - pickups[pickupIndex];
                    pickups[pickupIndex] = 0;
                    pickupIndex--;

                } else {
                    pickups[pickupIndex] -= pickupCap;
                    pickupCap = 0;
                }
            }
        }

        return answer;
    }

    public static void main(String args[]){
        System.out.println(new Solution().solution(2,7,new int[]{1, 0, 2, 0, 1, 0, 2},new int[]{0, 2, 0, 1, 0, 2, 0}));
    }
}