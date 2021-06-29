package com.company;

public class DigitOne {
    public static void main(String[] args) {
        System.out.println(countDigitOne(124));
    }

    public static int countDigitOne(int n) {
        int count=0;
        int base=1;
        int numberLower=0;
        while (n>0){//从低位开始
            int curr=n % 10;//当前数字
            System.out.println("base: " + base);
            System.out.println("curr: "+ curr);
            if(curr>1)
                count+=base;//如果当前数字大于1 ，加上一个基数即可
            else if(curr==1){//如果当前数字等于1 ，加上低位的数字+1
                count+=numberLower+1;
            }
            System.out.println("count: " + count);
            n/=10;
            count+=n*base;//左边的高位数字 * 基数
            numberLower+=curr*base;  //更新低边数字
            base*=10;//基数*10
            System.out.println("count: " + count);
            System.out.println("----------");
        }
        return count;
    }
}
