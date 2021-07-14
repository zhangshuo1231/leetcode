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

