**335**
实际上线段相交只有四种情况：
第i根线段与i-3相交，与i-4相交，与i-5相交。其他的都不可能。然就就可以递归。

**336**
什么情况下两个String，S1和S2，相加以后（S1+S2）形成一个Palindrome？四种情况：
第一，S1是空，S2是Palindrome，则both S1+S2和S2+S1都是Palindrome
第二，S2是S1的逆序，则both S1+S2和S2+S1都是Palindrome
第三，S1的sub[0:cut]是Palindrome，且S2是S1的剩余sub[cut+1:]的逆序，则S2+S1是Palindrome
第四，跟第三个类似，如果S1的sub[cut+1:]是Palindrome，且S2是S1首段[0:cut]的逆序，则S1+S2是Palindrome

**338**
偶数x与x/2，二进制表达末尾差1个0.
奇数y与y/2，二进制表达之间什么关系？对于奇数y，y/2相当于（y-1）/2，所以奇数y与y/2之间除了差一个0，还差末尾的1。

**342**
Power of 4. 看Code，原创的很清晰的思路。
或者：binary表达里面只有1个1，后面跟着偶数个0。

**343**
一个数，分成几个数的和，要求几个数的乘积最大。要尽量用更多3，不超过用两个2.

**344**
逆序数组，只需要首位一对对swap

**347**
排序的时候用到comparator，别自己写了：
正序直接 sort(), 
逆序 Map.Entry.<Integer, Integer>comparingByValue().reversed()， 或者
Collections.reverseOrder()

**349**
Set有个retainAll方法，保留两个Set的intersection

**349**
先sort，然后两个指针往前推

**352**
TreeMap自动会按照Key来排序，然后lowerKey(n)可以得到小于n的最大key，higherKey(n)可以得到大于n的最小key

**354**
Longest Increasing Subsequence的DP重要思想：dp[i]代表从头开始到num[i]为止,以num[i]为末尾元素的最长升序.
后面到dp[i+1]的时候,把num[0]到[i]的元素依次与num[i+1]比较,哪一个(num[x])不如num[i+1]大,就更新dp[i+1]为dp[x]+1
另: Comparator接口的使用,升序a-b,降序b-a.

**355**
Design Twitter最难的一步,是如何fetch一个用户follow的所有用户(包含自己)最近发布的10条推文.这里面用到PriorityQueue(用时间排序).
每一个用户发的推文按照时间顺序连成一个单向链表,head是最新推文.然后,把所有followee(包括自己)的head推文放在一个PriorityQueue里面,每次fetch
一个之后,就把这条推文的next推文add进入queue,这样就能保证获取最新的推文

**357**
纯粹数学问题：排列组合

**<span style="color: red">363</span>**
超级难。相关子数组和最大问题：dp[i]为以num[i]结尾的最大子数组.则dp[i+1]要么为dp[i]+num[i],要么为num[i]

**365**
纯数学：两个不同容量的水壶倒水，凑一个水量的问题。目标水量必须是两个水壶水量最大公约数的倍数。且目标水量不超过两个水壶水量之和。

**367**
注意！一旦有Integer过大的危险，一定要用long

**368**
dp方法找Largest Divisible Subset(最大整除子集),先sort,然后设定dp[i]为以i为最大被除数的最大整除子集的元素数.每次只需遍历0~i-1的元素j,若能被dp[i]整除
且dp[j] + 1 > dp[i]就更新.

**371**
整数加法的微操作：相加就是抑或^, 进位靠与&. 一个递归就行了.

**372**
ab % k = (a % k)(b % k) % k

**373**
PriorityQueue，自动排序好帮手。一个个加到这里来，就能给多个数组联合merge排序。

**376**
dp的时候，降低时间复杂度的一个重要方法是，尽量定义dp[i]为"前i个元素的状况",而不是"以第i个元素为结尾的状况".前者的复杂度为n,后者为n^2

**377**
每次1,2级上台阶方法问题、从一堆硬币里每次可以拿走xyz枚硬币的问题,或者一数组元素可重复使用求某target的问题.用递归,从target往下减每个元素.初始状况:要么是target降低
到了最基础数组元素了就开始赋值,要么就是0的时候按照1算,负数按照零算.

**378**
PriorityQueue很强大，任何东西进去在poll的时候，就是按顺序的。

**380**
HashSet has complexity of O(1) for insertion and lookup

**381**
HashMap has complexity of O(1) for insertion and lookup

**382**
reservoir algorithm 未知个数的数列按照平均分布随机取值：数列nums，变量n。i从0开始遍历到nums.length - 1, 按照 1/(i+1) 的概率替换掉n：第0个数概率为1，第一个概率为1/2，第二个概率为1/3……
遍历完后自然是获得在nums平均分布随机取值的数字n。

**383**
List list = Arrays.asList(new Character[]{'a', 'b', 'c'});
List list = Arrays.asList(new char[]{'a', 'b', 'c'}); 或者 List list = Arrays.asList("abc".toCharArray());
不一样！上面那个得到正确的list，包含3个elements。下面那个只有一个element，是个char[]

**384**
数组洗牌，只需要用i遍历数组,每次用random.nextInt(nums.length)生成一个在数组length以内的随机数,与i进行swap即可.这是O(n)的线性操作,很牛逼的.

**<span style="color: red">385</span>** 
超级难的递归。如果是String parsing的题目，要考虑递归，一段一段地parse。

**386**
George说,返回对象不占用空间复杂度.自然数列字典序，用递归。先排1打头的，1，1乘10加0，1乘10加1……每一个数再循环乘10加1，2……

**387**
LinkedHashMap 是可以保持insert顺序的map

**<span style="color: red">388</span>**
parse目录树，注意\t,\n这类东西只占一个位置，而且可以用queue来追踪目前目录的级别

**390**
观察之后找规律。首位数字是否变化，仅和当前数列数字个数的奇偶有关。首位数字变化的幅度（step），每一轮翻倍。

**391**
观察。长方形能组合成大长方形的条件：
1-四个定点只用一次
2-其他顶点不是两次就是四次
3-大长方形面积等于各个长方形的面积总和

**393**
UTF-8处理，注意这个函数：String binRep = Integer.toBinaryString(data[i]);

**394**
循环parse。注意当出现连续阿拉伯数字的时候，最好的解决方式是：
if (Character.isDigit(s.charAt(idx))) {
    int count = 0;
    while (Character.isDigit(s.charAt(idx))) {
        count = 10 * count + (s.charAt(idx) - '0');
        idx++;
    }
    countStack.push(count);
}

**395**
子字符串每个字符至少重复k次：D & C，每次用单一字符出现总次数小于k为分界线。初始条件是每个字符都超过k次则返回字符串长度，字符串为null或者长度小于k
就返回0

**396**
array平移运算，一定要先观察规律再编写程序。往往可以找出每次平移和前一次之间的delta。

**397**
位运算只有7种：&，|，~，^，>>，<<，>>>。
>> 相当于除以2
<< 相当于乘以2
>>> 是带着最高位符号(1或0)右移.

**399**
UnionFind方法，只看这道题就行。

**400**
