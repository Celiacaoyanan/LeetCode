//for every prices, record min in the previous prices, use the current prices-min to see if it is larger than current profit
//two pointers, one traverse all prices, another point to min
class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0) return 0;
        int min=prices[0];
        int profit=0;
        for (int i=0;i<prices.length;i++) {
            if (prices[i]<min) min=prices[i];
            if (profit<prices[i]-min) profit=prices[i]-min;
        }
        return profit;
    }
}
