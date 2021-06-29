package com.company;

import java.util.Arrays;

public class Stock {

    public static void main(String[] args) {
        int[] prices = new int[]{2, 4, 1};
        System.out.println(maxProfit(2, prices));
    }

    public static int maxProfit(int[] prices) {
        int oneSell = 0;
        int twoSell = 0;
        int oneBuy = Integer.MAX_VALUE;
        int twoBuy = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            oneBuy = Math.min(oneBuy, prices[i]);               //到现在最低成本
            oneSell = Math.max(oneSell, prices[i] - oneBuy);    //到现在最高收益

            twoBuy = Math.min(twoBuy, prices[i] - oneSell);     //到现在的事实最低投入（有可能是负的，代表第一次已经挣钱了）
            twoSell = Math.max(twoSell, prices[i] - twoBuy);    //到现在最高收益
        }
        return twoSell;
    }

    public static int maxProfit(int k, int[] prices) {
        int[] sells = new int[k + 1]; Arrays.fill(sells, 0);
        int[] buys = new int[k + 1]; Arrays.fill(buys, Integer.MAX_VALUE);

        for (int i = 0; i < prices.length; i++) {                       //每一天
            for (int j = 1; j<=k; j++) {                                //每一次可能的交易
                buys[j] = Math.min(buys[j], prices[i] - sells[j - 1]);  //本次买入后，最低的投入资金（负值代表之前已经挣钱了）
                sells[j] = Math.max(sells[j], prices[i] - buys[j]);     //本次卖出后，最高的持有现金
            }
        }
        return sells[k];
    }
}
