package LeetCode;

public class s952并查集欧式筛 {
    
    
    public static int n = (int)1e5 + 7;
    //判断是否是质数
    public static int[] isPrime = new int[n];
    
    //存放质数
    public static int[] primes = new int[n];
    //并查集
    public static int[] parent = new int[n];
    static int k = 0;
    
    // 并查集改进方法+欧式筛
    public static int largestComponentSize_Improvement(int[] nums) {
        //欧拉筛，找出1-n的所有质数
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 0) {
                primes[k++] = i;
            }
            for (int j = 0; primes[j] * i < n; j++) {
                //每个质数都和i相乘 得到合数
                isPrime[primes[j] * i] = 1;
                //primes[j]是i的一个质因数
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }
        //初始化并查集
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        //遍历nums中的每个数,和他们的质因数连接
        for (int num: nums) {
            int quotient = num;
            for (int j = 0; j < k && primes[j] * primes[j] <= quotient; j++) {
                if (quotient % primes[j] == 0) {
                    //primes[i]是他的质因数
                    union(num, primes[j]);
                    while (quotient % primes[j] == 0) {
                        quotient /= primes[j];
                    }
                }
            }
            //假如剩下了一个质因数，也和num连接，使得不同的质因数可以联合到一起
            //这种情况是因为 num是一个合数 由不同的质因数相乘组成 把他的质因数 连接起来
            if (quotient > 1) {
                union(quotient, num);
            }
        }
        int[] cnt = new int[n];
        int ans = 0;
        //是否属于某个根
        for (int num: nums) {
            ans = Math.max(ans, ++ cnt[find(num)]);
        }
        return ans;
    }
    
    
    public static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        
        if (parentX != parentY) {
            parent[parentX] = parentY;
        }
    }
    
    public static int find(int x) {
        // 采用路径压缩
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }
    
    public static int[] sign;
    
    //  暴力建图+BFS，时间复杂度O(n^2logC)，其中C指的是nums中的每一个数，超时，超时原因主要在建图过程
    public static int largestComponentSize(int[] nums) {
        sign = new int[nums.length];
        int max = 0;
        int temp = 0;
        //  邻接矩阵
        int[][] GraphMatrix = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (IsHaveCommonFactor(nums[i], nums[j]) > 1) {
                    GraphMatrix[i][j] = 1;
                }
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            DFS(GraphMatrix, nums.length, i);
            
            for (int j = 0; j < nums.length; j++) {
                temp += sign[j];
            }
            if (max < temp) {
                max = temp;
            }
            for (int j = 0; j < nums.length; j++) {
                sign[j] = 0;
            }
            temp = 0;
        }
        return max;
    }
    
    //    计算图中最大联通组件
    public static void DFS(int[][] Graph, int n, int startid) {
        sign[startid] = 1;
        for (int i = 0; i < n; i++) {
            if (sign[i] == 0) {
                if (Graph[startid][i] == 1) {
                    sign[i] = 1;
                    DFS(Graph, n, i);
                }
            }
        }
    }
    
    //    计算最大公约数
    public static int IsHaveCommonFactor(int a, int b) {
        if (a == b) {
            // 不存在a=b的情况 否则返回a
            return - 1;
        } else if (a > b) {
            while (true) {
                a = a % b;
                if (a == 0) {
                    return b;
                }
                b = b % a;
                if (b == 0) {
                    return a;
                }
            }
            
        } else {
            while (true) {
                b = b % a;
                if (b == 0) {
                    return a;
                }
                a = a % b;
                if (a == 0) {
                    return b;
                }
            }
        }
    }
}
