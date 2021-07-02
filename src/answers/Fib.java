package answers;

public class Fib {
    // 递归：
    // 最简单状态返回值
    // 调用自己，但是传入比之前更趋近于简单状态的参数

    // recursive
    public int fib(int n) {
        if (n == 1 || n == 2)
            return 1;
        else
            return fib(n - 2) + fib(n-1);
    }

    // 动态规划：
    // 建立一个helper函数，接收条件参数和cache数组
    // helper函数：
    // 第一步：跟递归一样，最简单状态返回值
    // 第二步：一般状态，返回cache中相应位置的值
    // 第三步：调用自己，但是使用cache，并把每一步的值赋值给cache
    // 最后：返回cache相应位置的值

    // dynamic
    public int fib_v2(int n) {
        int[] cache = new int[n + 1];
        return helper(n, cache);
    }
    public int helper(int n, int[] cache) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        cache[n] = helper(n-2, cache) + helper(n-1, cache);
        return cache[n];
    }

    // iterative
    public int fib_v3(int n) {
        if (n == 1 || n == 2)
            return 1;
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            res[i] = res[i-2] + res[i-1];
        }
        return res[n];
    }
}